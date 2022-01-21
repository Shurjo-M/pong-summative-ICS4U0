package model

import input.EventManager
import util.AABB
import util.Vector2

import java.awt.event.KeyEvent

class Player : Entity(AABB(32f, 600f/2 - 64, 16f, 128f), "Player")
{
    var direction: Vector2 = Vector2(0f, 0f)
    private val speed = 12f

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
