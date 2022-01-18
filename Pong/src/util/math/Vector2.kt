package util.math

class Vector2(x: Float, y: Float)
{
    var y: Float = x
    var x: Float = y

    companion object
    {
        @JvmStatic public val ZERO = Vector2(0f, 0f)
    }

    /**
     *
     */
    fun plus(b: Vector2): Vector2
    {
        return Vector2(this.x + b.x, this.y + b.y)
    }

    /**
     *
     */
    fun minus(b: Vector2): Vector2
    {
        return Vector2(this.x - b.x, this.y - b.y)
    }

    /**
     *
     */
    fun unaryMinus(): Vector2
    {
        return Vector2(-x, -y)
    }

    /**
     *
     */
    fun times(a: Float): Vector2
    {
        return Vector2(this.x * a, this.y * a)
    }

    /**
     *
     */
    fun div(a: Float): Vector2
    {
        return Vector2(this.x / a, this.y / a)
    }

    /**
     *
     */
    override fun equals(other: Any?): Boolean
    {
        if (other is Vector2)
        {
            return (this.x == other.x && this.y == other.y)
        }
        return false
    }

    /**
     * No touchy!
     */
    override fun hashCode(): Int
    {
        var result = y.hashCode()
        result = 31 * result + x.hashCode()
        return result
    }
}
