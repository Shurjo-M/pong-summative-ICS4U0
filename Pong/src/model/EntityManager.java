package model;

import input.EventManager;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager extends ArrayList<Entity>
{
    public void ready()
    {
        for (Entity e : this)
        {
            e.ready();
        }
    }

    public void input(EventManager manager)
    {
        for (Entity e : this)
        {
            e.input(manager);
        }
    }

    public void update()
    {
        for (Entity e : this)
        {
            e.update();
        }
    }

    public void render(Graphics g)
    {
        for (Entity e : this)
        {
            g.fillRect((int) e.rect.x, (int) e.rect.y, (int) e.rect.w, (int) e.rect.h);
        }
    }
}
