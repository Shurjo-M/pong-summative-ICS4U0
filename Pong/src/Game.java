import input.EventManager;
import input.KeyInput;
import model.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game extends Canvas implements Runnable
{
    // Variable Declaration
    public static int WIDTH = 800, HEIGHT = 600;
    public String title = "Pong";

    private Thread thread;
    private boolean isRunning = false;
    private final KeyInput keyInput;
    public EntityManager entities;
    EventManager eventManager;

    // Constructor
    public Game()
    {
        new Window(WIDTH, HEIGHT, title, this);
        keyInput = new KeyInput();
        this.addKeyListener(keyInput);
        entities = new EntityManager();
        eventManager = new EventManager();
        start();
    }

    private synchronized void start()
    {
        if (isRunning) return;

        thread = new Thread(this, "Game");
        isRunning = true;

        entities.add(new Player());
        entities.add(new Ball());
        entities.add(new Enemy());

        entities.ready();

        // player controls
        eventManager.track(KeyEvent.VK_W);
        eventManager.track(KeyEvent.VK_S);

        // pause/play game
        eventManager.track(KeyEvent.VK_ESCAPE);

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
            var keyEvents = keyInput.getKeyEvents();

            // update the game at 60hz.
            // ensure that any updates missed by lag are computed
            // (Is this the cause minecraft's lag spikes?)
            while(delta >= 1)
            {
                KeyEvent event;
                while ((event = keyEvents.pollFirst()) != null)
                {
                    eventManager.update(event);
                }

                tick();
                delta--;
            }

            // render the game to the screen
            // why is this called every frame? update is only called 60 times a second, so why is this even here?
            // changes to game state only happen in update, so why does moving this line break everything?
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
     */
    private void tick()
    {
        entities.forEach(
                entity -> entity.input(eventManager)
        );

        entities.update();
    }

    /**
     * private void render
     */
    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null)
        {
            this.createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        // Drawing the game
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.WHITE);

        entities.render(g);

        bs.show();
        g.dispose();
    }
}
