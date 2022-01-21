package model

import input.EventManager
import util.math.AABB
import util.math.Vector2
import java.awt.event.KeyEvent

class Enemy : Entity(AABB(800-64f, 600f/2 - 64, 16f, 128f), "Enemy")
{
    var direction: Vector2 = Vector2(0f, 0f)
    private val speed = 12f
    private val player: Entity = getEntity("Player")
    private val ball: Entity = getEntity("Ball")

    override fun update()
    {
        direction.y = ball.velocity.y
        direction = direction.normalize()
        velocity = direction * speed
        super.update()
    }
}
