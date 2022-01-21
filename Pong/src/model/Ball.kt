package model

import util.math.AABB

class Ball : Entity(AABB(800f/2 - 16f, 600f/2 - 16f, 32f, 32f), "Ball")
{
    private val player = getEntity("Player")
    private val enemy = getEntity("Enemy")

    init
    {

    }

    override fun update() {
        super.update()
    }
}
