package model

import Scoreboard
import Window
import util.AABB
import util.Vector2
import java.util.*

class Ball(var scoreboard: Scoreboard)
    : Entity(AABB(800f/2 - 16f, 600f/2 - 16f, 32f, 32f), "Ball")
{
    private lateinit var player: Entity
    private lateinit var enemy: Entity
    var speed = 5f
    var direction = Vector2(0f, 0f)
    var rand = Random()
    private lateinit var window: Window
    var playerScore: Int = 0
    var enemyScore: Int = 0

    init
    {
        direction.x = if (rand.nextBoolean()) -1f else 1f
        direction.y = if (rand.nextBoolean()) -1f else 1f
        direction = direction.normalize()
    }

    override fun ready()
    {
        player = getEntity("Player")
        enemy = getEntity("Enemy")
        window = getEntity("Window") as Window
        println(window.rect.w)
        println(window.rect.h)
    }

    override fun update()
    {

        if (rect.intersects(player.rect) || rect.intersects(enemy.rect))
        {
            direction.x = -direction.x
            speed += 0.2f
        }

        if ((rect.y <= 0) || (rect.y + rect.h) >= window.rect.h)
        {
            direction.y = -direction.y
        }

        if (rect.x <= 0 || rect.x >= window.rect.w)
        {
            enemyScore += if (rect.x <= 0) 1 else 0
            playerScore += if (rect.x >= window.rect.w) 1 else 0
            this.reset()

            scoreboard.update(playerScore, enemyScore)
        }

        velocity = direction * speed

        super.update()
    }

    private fun reset()
    {
        rect.x = 800f/2 - 16f
        rect.y = 800f/2 - 16f
        speed = 5f
        direction.x = if (rand.nextBoolean()) -1f else 1f
        direction.y = if (rand.nextBoolean()) -1f else 1f
        direction = direction.normalize()
    }
}
