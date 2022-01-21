package model

import input.EventManager
import util.math.AABB
import util.math.Vector2
import java.awt.event.KeyEvent

class Player : Entity(AABB(32f, 32f, 16f, 128f), "Player")
{
    var direction: Vector2 = Vector2.ZERO
    private val speed = 12f

    init {
    }

    override fun input(manager: EventManager)
    {
        direction.y = manager.getActionStrength(KeyEvent.VK_S) - manager.getActionStrength(KeyEvent.VK_W)
    }

    override fun update()
    {
        velocity = direction * speed
        super.update()
    }
}
