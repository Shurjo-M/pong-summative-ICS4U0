package model;

import input.EventManager;
import util.math.AABB;
import util.math.Vector2;

import java.util.HashMap;

public abstract class Entity
{
    public AABB rect;
    protected Vector2 velocity;
    protected String name;
    private static final HashMap<String, Entity> entityLookupTable;

    static
    {
        entityLookupTable = new HashMap<>();
    }

    /**
     * A single anonymous entity within the game
     * @param rect encodes the position, width and height of the entity
     */
    public Entity(AABB rect)
    {
        this.rect = rect;
        velocity = new Vector2(0, 0);
        entityLookupTable.putIfAbsent(name, this);
    }

    /**
     * A single named entity within the game
     * @param rect encodes the position, width and height of the entity
     * @param name the name of the entity
     */
    public Entity(AABB rect, String name)
    {
        this.rect = rect;
        velocity = new Vector2(0, 0);
        this.name = name;
        entityLookupTable.putIfAbsent(name, this);
    }

    public void ready()
    {

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
        this.rect.x += this.velocity.getX();
        this.rect.y += this.velocity.getY();
    }

    public Entity getEntity(String name)
    {
        return entityLookupTable.get(name);
    }


}
