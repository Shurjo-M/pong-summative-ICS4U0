package model;

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
