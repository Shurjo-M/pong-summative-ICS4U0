package model

import Window
import util.AABB
import util.Vector2

class Enemy : Entity(AABB(800-64f, 600f/2 - 64, 16f, 128f), "Enemy")
{
    var direction: Vector2 = Vector2(0f, 0f)
    private val speed = 12f
    private lateinit var ball: Ball
    private lateinit var window: Window


    override fun ready()
    {
        ball = getEntity("Ball") as Ball
        window = getEntity("Window") as Window

        rect.x = window.rect.w - 64

    }

    override fun update()
    {
        direction.y = ball.velocity.y
        direction = direction.normalize()
        //velocity = direction * speed
        super.update()
    }
}
