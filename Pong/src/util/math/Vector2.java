package util.math;

public class Vector2
{
    public float x, y;


    public Vector2(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public static Vector2 ZERO = new Vector2(0, 0);

    public Vector2 scale(float a)
    {
        return new Vector2(this.x * a, this.y * a);
    }

    @Override
    public boolean equals(Object other)
    {
        if (other instanceof Vector2 o)
        {
            return (this.x == o.x && this.y == o.y);
        }
        return false;
    }
}
