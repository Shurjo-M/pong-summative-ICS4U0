package model;

import util.math.AABB;
import util.math.Vector2;
import java.awt.event.KeyEvent;


public class Player extends Entity
{
    Vector2 direction = Vector2.ZERO;

    /**
     * Called every time a keyboard input event is polled
     * (refer to main game loop for input polling)
     * @param keyCode the keyboard key that was pressed
     */
    @Override
    public void input(final int keyCode)
    {
        System.out.println(keyCode);
    }

    @Override
    public void update()
    {

        super.update();
    }

    public Player(AABB rect)
    {
        super(rect);

        // subscribe to input events
        // event name, active
        events.putIfAbsent(KeyEvent.VK_W, 0);
        events.putIfAbsent(KeyEvent.VK_A, 0);
        events.putIfAbsent(KeyEvent.VK_S, 0);
        events.putIfAbsent(KeyEvent.VK_D, 0);
    }
}
