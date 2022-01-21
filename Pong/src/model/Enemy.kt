package model

import input.EventManager
import util.math.AABB
import util.math.Vector2
import java.awt.event.KeyEvent

class Enemy : Entity(AABB(800-64f, 32f, 16f, 128f), "Enemy")
{
    var direction: Vector2 = Vector2.ZERO
    private val speed = 12f
    private val player: Entity = getEntity("Player")

    override fun update()
    {
        velocity = player.velocity!!
        super.update()
    }
}
