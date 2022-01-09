package model;

import util.math.AABB;
import util.math.Vector2;

public abstract class Entity
{
    public AABB rect;
    private Vector2 velocity;

    public Entity(AABB rect)
    {
        this.rect = rect;
        velocity = Vector2.ZERO;
    }

    /**
     * Update the entity
     */
    public void update()
    {
        rect.x += velocity.x;
        rect.y += velocity.y;
    }
}
