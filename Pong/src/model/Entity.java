package model;

import util.math.AABB;
import util.math.Vector2;

public abstract class Entity
{
    public AABB rect;
    protected Vector2 velocity;

    public Entity(AABB rect)
    {
        this.rect = rect;
        velocity = Vector2.getZERO();
    }

    public abstract void input(final int keyCode);

    /**
     * Update the entity
     */
    public void update()
    {
        rect.x += velocity.getX();
        rect.y += velocity.getY();
    }
}
