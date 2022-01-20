package model

import input.EventManager
import util.math.AABB
import util.math.Vector2
import java.awt.event.KeyEvent

class Player(rect: AABB?) : Entity(rect)
{
    var direction: Vector2 = Vector2.ZERO
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
