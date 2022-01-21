package model

import util.math.AABB
import util.math.Vector2
import java.util.*
import kotlin.system.exitProcess

class Ball : Entity(AABB(800f/2 - 16f, 600f/2 - 16f, 32f, 32f), "Ball")
{
    private val player = getEntity("Player")
    private val enemy = getEntity("Enemy")
    var speed = 5f
    var direction = Vector2(0f, 0f)
    var rand = Random()

    init
    {
        //direction.y = rand.nextInt(-1, 1).toFloat()
        direction.x = if (rand.nextBoolean()) -1f else 1f
        direction.y = if (rand.nextBoolean()) -1f else 1f
        direction = direction.normalize()
    }

    override fun update() {

        if (rect.intersects(player.rect) || rect.intersects(enemy.rect))
        {
            direction.x = -direction.x
            speed += 0.2f
        }

        if (rect.y <= 0 || (rect.y + 64) >= 600)
        {
            direction.y = -direction.y
        }

        if (rect.x <= 0 || rect.x >= 800)
        {
            this.reset()
        }

        velocity = direction * speed

        super.update()
    }

    fun reset()
    {
        rect.x = 800f/2 - 16f
        rect.y = 800f/2 - 16f
        speed = 5f
        direction.x = if (rand.nextBoolean()) -1f else 1f
        direction.y = if (rand.nextBoolean()) -1f else 1f
        direction = direction.normalize()
    }
}
