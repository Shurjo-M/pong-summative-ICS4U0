package util.math;

public class Vector2
{
    private float x, y;

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void setXY(float x, float y)
    {
        this.x = x;
        this.y = y;
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
