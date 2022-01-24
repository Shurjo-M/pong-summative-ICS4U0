import gui.MainMenu;
import gui.Scoreboard;
import gui.StatsPanel;
import input.EventManager;
import input.KeyInput;
import model.Ball;
import model.Enemy;
import model.EntityManager;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

public class Game extends Canvas implements Runnable
{
    // Variable Declaration
    public static int WIDTH = 800, HEIGHT = 600;
    public String title = "Pong";
    Window window;

    private Thread thread;
    private boolean isRunning = false;
    private final KeyInput keyInput = new KeyInput();
    public EntityManager entities;
    EventManager eventManager;
    Scoreboard scoreboard = new Scoreboard();
    MainMenu menu = new MainMenu();
    StatsPanel stats = new StatsPanel();
    LinkedList<KeyEvent> keyEvents = keyInput.getKeyEvents();

    // Constructor
    public Game()
    {
        window = new Window(WIDTH, HEIGHT, title, this, scoreboard, menu);
        this.addKeyListener(keyInput);
        stats.registerControllers(e -> window.setScreen(stats, menu));
        // Shurjo make it do Game.start() after new game is pressed in the menu
        // OK
    }

    public void reset()
    {
        System.out.println("This nightmare over here!");
        entities = new EntityManager();
        eventManager = new EventManager();

        isRunning = true;

        entities.add(new Player());
        entities.add(new Ball(scoreboard));
        entities.add(new Enemy());

        entities.ready();

        // player controls
        eventManager.track(KeyEvent.VK_W);
        eventManager.track(KeyEvent.VK_S);

        // pause/play game
        eventManager.track(KeyEvent.VK_ESCAPE);

        window.setScreen(menu, this);
    }

    public synchronized void start()
    {
        if (isRunning)
            return;
        else
            reset();

        entities = new EntityManager();
        eventManager = new EventManager();

        thread = new Thread(this, "Game");
        isRunning = true;

        entities.add(new Player());
        entities.add(new Ball(scoreboard));
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
    public void run()
    {
        this.requestFocus();

        // Variable Declaration
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;

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
                KeyEvent event;
                while ((event = keyEvents.pollFirst()) != null)
                {
                    eventManager.update(event);
                }

                tick();
                delta--;
            }

            if (eventManager.getActionStrength(KeyEvent.VK_ESCAPE) > 0)
            {
                window.setScreen(this, stats);
                break;
            }

            // render the game to the screen
            // why is this called every frame? update is only called 60 times a second, so why is this even here?
            // changes to game state only happen in update, so why does moving this line break everything?
            render();
        }
        stop();
    }

    /**
     * update the game
     */
    private void tick()
    {
        entities.input(eventManager);

        entities.update();
    }

    /**
     * draw things on the screen
     */
    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null)
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
