package model;

import input.EventManager;
import util.math.AABB;
import util.math.Vector2;

import java.lang.reflect.Type;
import java.util.HashMap;

public abstract class Entity
{
    public AABB rect;
    protected Vector2 velocity;
    private String name;
    private static final HashMap<String, Entity> manager;

    static
    {
        manager = new HashMap<>();
    }

    /**
     *
     * @param rect
     */
    public Entity(AABB rect)
    {
        this.rect = rect;
        velocity = Vector2.getZERO();
        this.name = name;
        manager.putIfAbsent(name, this);
    }

    /**
     *
     * @param rect
     * @param name
     */
    public Entity(AABB rect, String name)
    {
        this.rect = rect;
        velocity = Vector2.getZERO();
        this.name = name;
        manager.putIfAbsent(name, this);
    }

    /**
     *
     * @param manager EventManager that processes input events
     */
    public void input(EventManager manager)
    {}

    /**
     * Update the entity
     */
    public void update()
    {
        rect.x += velocity.getX();
        rect.y += velocity.getY();
    }

    public Entity getEntity(String name)
    {
        return manager.getOrDefault(name, null);
    }
}
