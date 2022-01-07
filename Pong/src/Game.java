import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable
{
    // Variable Declaration
    public static int WIDTH = 800, HEIGHT = 608;
    public String title = "Pong";

    private Thread thread;
    private boolean isRunning = false;
    private final KeyInput keyInput;

    // Constructor
    public Game()
    {
        new Window(WIDTH, HEIGHT, title, this);
        keyInput = new KeyInput();
        start();
        this.addKeyListener(keyInput);
    }

    private synchronized void start()
    {
        if (isRunning) return;

        thread = new Thread(this, "Game");
        thread.start();
        isRunning = true;
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
        while(isRunning)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1)
            {
                tick(delta);
                delta--;
            }

            render();

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
            }
        }

        stop();
    }

    // Updates the game
    private void tick(final double dt)
    {

    }

    // Renders the game
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

        bs.show();
        g.dispose();
    }
}
