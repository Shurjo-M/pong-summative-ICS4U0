package util.math;

public class Vector2
{
    public float x, y;

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
