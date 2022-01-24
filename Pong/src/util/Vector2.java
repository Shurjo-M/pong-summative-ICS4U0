package util;


public class Vector2
{
    public float x;
    public float y;

    public Vector2(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Add two vectors
     * @param b Vector to add this with
     * @return the new vector
     */
    public static Vector2 add(Vector2 a, Vector2 b)
    {
        return new Vector2(a.x + b.x, a.y + b.y);
    }

    /**
     * Add two vectors
     * @param b Vector to add this with
     * @return the new vector
     */
    public static Vector2 subtract(Vector2 a, Vector2 b)
    {
        return new Vector2(a.x - b.x, a.y - b.y);
    }

    /**
     * Negate this vector
     * @return
     */
    public Vector2 negate()
    {
        return new Vector2(-x, -y);
    }

    /**
     * Add two vectors
     * @param a scalar to scale by
     * @return the new vector
     */
    public Vector2 scale(float a)
    {
        return new Vector2(this.x * a, this.y * a);
    }

    public float length()
    {
        return (float) Math.sqrt(x*x + y*y);
    }

    public Vector2 normalize()
    {
        return ( this.scale( 1/length() ) );
    }

    /**
     * @param other The other object to check equality with
     * @return if the other vector is of equal direction and magnitude
     */
    public boolean equals(Object other)
    {
        if (other instanceof Vector2 o)
        {
            return (this.x == o.x && this.y == o.y);
        }
        return false;
    }
}
