package model

import input.EventManager
import util.AABB
import util.Vector2
import java.awt.event.KeyEvent

class Player : Entity(AABB(32f, 600f/2 - 64, 16f, 128f), "Player")
{
    var direction: Vector2 = Vector2(0f, 0f)
    private val speed = 12f
    private lateinit var window: Entity

    override fun ready()
    {
        window = getEntity("Window")
    }

    override fun input(manager: EventManager)
    {
        direction.y = manager.getActionStrength(KeyEvent.VK_S) - manager.getActionStrength(KeyEvent.VK_W)
    }

    override fun update()
    {
        if (rect.y <= 0)
        {
            rect.y = 0f
        }
        if (rect.y + rect.h >= window.rect.h)
        {
            rect.y = window.rect.h - rect.h
        }

        velocity = direction.scale(speed)
        super.update()
    }
}
