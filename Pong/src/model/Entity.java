package model;

import util.math.AABB;
import util.math.Vector2;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public abstract class Entity
{
    public AABB rect;
    protected Vector2 velocity;
    protected HashMap<Integer, Integer> events;

    public Entity(AABB rect)
    {
        this.rect = rect;
        events = new HashMap<>();
        velocity = Vector2.ZERO;
    }

    public abstract void input(final int keyCode);

    /**
     * Update the entity
     */
    public void update()
    {
        rect.x += velocity.x;
        rect.y += velocity.y;
    }
}
