package util.math;

public class AABB
{
    public float x, y;
    public float w, h;

    /**
     * public class AABB.
     * Defines a rectangular area aligned with both axes. Used for basic collision detection.
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public AABB(float x, float y, float w, float h)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    /*
     * TODO: add methods to check for:
     *     - CONSTRUCTOR cuz im stoopid :P
     *     - Collision with point (Vec2)
     */

    /**
     * Checks if this AABB is colliding with another AABB
     * @param other  AABB to check for collision with
     * @return  Whether the two AABBs intersect
     */
    public boolean intersects(AABB other)
    {
        return this.x < other.x + other.w &&
               this.x + this.w > other.x &&
               this.y < other.y + other.h &&
               this.h + this.y > other.y;
    }

}

