package model

import util.math.AABB
import util.math.Vector2
import java.awt.event.KeyEvent

class Player(rect: AABB?) : Entity(rect)
{
    var direction: Vector2 = Vector2.ZERO

    /**
     * Called every time a keyboard input event is polled
     * (refer to main game loop for input polling)
     * @param keyCode the keyboard key that was pressed
     */
    override fun input(keyCode: Int)
    {
        println(keyCode)
    }

    override fun update()
    {
        // TODO :: add some keyboard controls here!
        super.update()
    }

    init
    {

    }
}