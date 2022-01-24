package model;

import input.EventManager;
import util.AABB;
import util.Vector2;
import java.awt.event.KeyEvent;

class Player extends Entity
{
    private final Vector2 direction = new Vector2(0f, 0f);
    private Entity window;

    public Player()
    {
        super(new AABB(32f, 600f/2 - 64, 16f, 128f), "Player");
    }

    public void ready()
    {
        window = getEntity("Window");
    }

   public void input(EventManager manager)
    {
        direction.y = manager.getActionStrength(KeyEvent.VK_S) - manager.getActionStrength(KeyEvent.VK_W);
    }

    public void update()
    {
        if (rect.y <= 0)
        {
            rect.y = 0f;
        }
        if (rect.y + rect.h >= window.rect.h)
        {
            rect.y = window.rect.h - rect.h;
        }

        float speed = 12f;
        velocity = direction.scale(speed);
        super.update();
    }
}
