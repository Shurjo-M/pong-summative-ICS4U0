package util.math;

public class AABB
{
    float x, y;
    float w, h;

    /*
     * TODO: add methods to check for"
     *     - Collision with other AABB
     *     - Collision with point (Vec2)
     */

    public boolean intersects(AABB rect)
    {
        return this.x < rect.x + rect.w &&
               this.x + this.w > rect.x &&
               this.y < rect.y + rect.h &&
               this.h + this.y > rect.y;
    }

}

