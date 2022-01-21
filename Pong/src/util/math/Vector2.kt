package util.math

import kotlin.math.sqrt

class Vector2(var x: Float, var y: Float)
{
    /**
     * Add two vectors
     * @param b Vector to add this with
     * @return the new vector
     */
    operator fun plus(b: Vector2): Vector2
    {
        return Vector2(this.x + b.x, this.y + b.y)
    }

    /**
     * Add two vectors
     * @param b Vector to add this with
     * @return the new vector
     */
    operator fun minus(b: Vector2): Vector2
    {
        return Vector2(this.x - b.x, this.y - b.y)
    }

    /**
     * Negate this vector
     */
    operator fun unaryMinus(): Vector2
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
    operator fun div(a: Float): Vector2
    {
        return Vector2(this.x / a, this.y / a)
    }

    fun length(): Float
    {
        return sqrt(x*x + y*y)
    }

    fun normalize(): Vector2
    {
        return (this / length())
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
