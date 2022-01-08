package model;

import util.math.AABB;
import util.math.Vector2;

public abstract class Entity
{
    public AABB rect;
    private Vector2 velocity;

    public void update()
    {
        rect.x += velocity.getX();
        rect.y += velocity.getY();
    }
}
