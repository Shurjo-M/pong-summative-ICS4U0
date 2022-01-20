package util.math

class Vector2(var x: Float, var y: Float)
{

    companion object
    {
        @JvmStatic
        val ZERO = Vector2(0f, 0f)
    }

    /**
     * Add two vectors
     * @param b Vector to add this with
     * @return the new vector
     */
    fun plus(b: Vector2): Vector2
    {
        return Vector2(this.x + b.x, this.y + b.y)
    }

    /**
     * Add two vectors
     * @param b Vector to add this with
     * @return the new vector
     */
    fun minus(b: Vector2): Vector2
    {
        return Vector2(this.x - b.x, this.y - b.y)
    }

    /**
     * Negate this vector
     */
    fun unaryMinus(): Vector2
    {
        return Vector2(-x, -y)
    }

    /**
     * Add two vectors
     * @param a scalar to scale by
     * @return the new vector
     */
    operator fun times(a: Float): Vector2
    {
        return Vector2(this.x * a, this.y * a)
    }

    /**
     * Add two vectors
     * @param a scalar to scale by
     * @return the new vector
     */
    fun div(a: Float): Vector2
    {
        return Vector2(this.x / a, this.y / a)
    }

    /**
     * @param other The other object to check equality with
     * @return if the other vector is of equal direction and magnitude
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
