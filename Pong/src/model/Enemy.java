package model;

import util.AABB;
import util.Vector2;
import java.util.*;

public class Enemy extends Entity
{
    Vector2 direction = new Vector2(0f, 0f);

    private Entity ball;
    private Entity window;

    public Enemy()
    {
        super(new AABB(800-64f, 600f/2 - 64, 16f, 128f), "Enemy");
    }

    public void ready()
    {
        ball = getEntity("Ball");
        window = getEntity("Window");

        rect.x = window.rect.w - 64;
    }

    public void update()
    {
        direction.y = -1f;

        if (rect.y <= 0)
        {
            rect.y = 0f;
        }
        if (rect.y + rect.h >= window.rect.h)
        {
            rect.y = window.rect.h - rect.h;
        }

        float speed = 7f;
        velocity = direction.scale(speed);

        super.update();
    }
}
