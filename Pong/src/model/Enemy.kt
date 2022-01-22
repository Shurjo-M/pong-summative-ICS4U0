package model

import Window
import util.AABB
import util.Vector2
import java.util.*

class Enemy : Entity(AABB(800-64f, 600f/2 - 64, 16f, 128f), "Enemy")
{
    var direction: Vector2 = Vector2(0f, 0f)
    private val speed = 12f
    private lateinit var ball: Ball
    private lateinit var window: Window
    private val random = Random()

    override fun ready()
    {
        ball = getEntity("Ball") as Ball
        window = getEntity("Window") as Window

        rect.x = window.rect.w - 64

    }

    override fun update()
    {

        if (rect.y + rect.h/2 > ball.rect.y)
        {
            direction.y = -1f
        }
        if (rect.y + rect.h/2 < ball.rect.y)
        {
            direction.y = 1f
        }

        direction = direction.normalize()
        //velocity = direction * speed

        if (rect.y <= 0)
        {
            rect.y = 0f
        }
        if (rect.y + rect.h >= window.rect.h)
        {
            rect.y = window.rect.h - rect.h
        }

        if (random.nextBoolean())
        {
            velocity = direction * speed
        }
        super.update()
    }
}
