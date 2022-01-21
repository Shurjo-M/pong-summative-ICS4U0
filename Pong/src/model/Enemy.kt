package model

import util.AABB
import util.Vector2

class Enemy : Entity(AABB(800-64f, 600f/2 - 64, 16f, 128f), "Enemy")
{
    var direction: Vector2 = Vector2(0f, 0f)
    private val speed = 12f
    private lateinit var player: Entity
    private lateinit var ball: Entity

    override fun ready() {
        player = getEntity("Player")
        ball = getEntity("Ball")
    }

    override fun update()
    {
        direction.y = ball.velocity.y
        direction = direction.normalize()
        velocity = direction * speed
        super.update()
    }
}
