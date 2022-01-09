import model.Entity;
import util.math.AABB;
import util.math.Vector2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game extends Canvas implements Runnable
{
    // Variable Declaration
    public static int WIDTH = 800, HEIGHT = 608;
    public String title = "Pong";

    private Thread thread;
    private boolean isRunning = false;
    private final KeyInput keyInput;
    public ArrayList<Entity> entities;

    // Constructor
    public Game()
    {
        new Window(WIDTH, HEIGHT, title, this);
        keyInput = new KeyInput();
        this.addKeyListener(keyInput);
        entities = new ArrayList<>();
        start();
    }

    private synchronized void start()
    {
        if (isRunning) return;

        thread = new Thread(this, "Game");
        isRunning = true;

        // code to pull into a new file begins
        AABB playerRect = new AABB(50, 50, 32, 32);
        Entity player = new Entity(playerRect)
        {
            @Override
            public void update()
            {
                var keys = keyInput.getKeyEvents();

                velocity = Vector2.ZERO;
                for (var event : keys)
                {
                    var code = event.getKeyCode();
                    if (code == KeyEvent.VK_W)
                    {
                        velocity.y -= 2.5f;
                    }
                    if (code == KeyEvent.VK_A)
                    {
                        velocity.x -= 2.5f;
                    }
                    if (code == KeyEvent.VK_S)
                    {
                        velocity.y += 2.5f;
                    }
                    if (code == KeyEvent.VK_D)
                    {
                        velocity.x += 2.5f;
                    }
                }


                super.update();
            }
        };
        entities.add(player);
        // code to pull into new file ends

        thread.start();
    }

    private synchronized void stop()
    {
        if(!isRunning) return;

        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        isRunning = false;
    }

    // Game Loop
    public void run() {
        this.requestFocus();

        // Variable Declaration
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();

        // Loop to render and update game
        // This style of game loop was originally designed by Notch during the creation of minecraft
        // it updates the game 60 times a second and renders the game during each loop regardless of timing.
        while(isRunning)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            // update the game at 60hz.
            // ensure that any updates missed by lag are computed
            // (Is this the cause minecraft's lag spikes?)
            while(delta >= 1)
            {
                tick(delta);
                delta--;
                keyInput.flush();
            }

            // render the game to the screen
            render();

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
            }
        }

        stop();
    }



    /**
     * private void tick
     * @param dt  time elapsed
     */
    private void tick(final double dt)
    {
        entities.forEach(Entity::update);
    }

    /**
     * private void render
     */
    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        // Drawing the game
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.WHITE);
        entities.forEach(
            (entity -> g.fillRect((int) entity.rect.x, (int) entity.rect.y, (int) entity.rect.w, (int) entity.rect.h))
        );

        bs.show();
        g.dispose();
    }
}
