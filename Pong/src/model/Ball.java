package model;

import gui.Scoreboard;
import util.AABB;
import util.Vector2;
import java.util.*;

public class Ball extends Entity
{
    private Entity player;
    private Entity enemy;
    float speed = 5f;
    Vector2 direction = new Vector2(0f, 0f);
    Random rand = new Random();
    private Entity window;

    public int getPlayerScore()
    {
        return playerScore;
    }

    public int getEnemyScore()
    {
        return enemyScore;
    }

    private int playerScore = 0;
    private int enemyScore = 0;
    Scoreboard scoreboard;

    public Ball(Scoreboard scoreboard)
    {
        super(new AABB(800f/2 - 16f, 600f/2 - 16f, 32f, 32f), "Ball");
        direction.x = rand.nextBoolean() ? 1f : -1;
        direction.y = rand.nextBoolean() ? 1f : -1;
        direction = direction.normalize();
        this.scoreboard = scoreboard;
    }

    public void ready()
    {
        player = getEntity("Player");
        enemy = getEntity("Enemy");
        window = getEntity("Window");
    }

    public void update()
    {

        if (rect.intersects(player.rect) || rect.intersects(enemy.rect))
        {
            direction.x = -direction.x;
            speed += 0.2f;
        }

        if ((rect.y <= 0) || (rect.y + rect.h) >= window.rect.h)
        {
            direction.y = -direction.y;
        }

        if (rect.x <= 0 || rect.x >= window.rect.w)
        {
            enemyScore += rect.x <= 0 ? 1 : 0;
            playerScore += rect.x >= window.rect.w ? 1 : 0;
            this.reset();

            scoreboard.update(playerScore, enemyScore);
        }

        velocity = direction.scale(speed);

        super.update();
    }

    private void reset()
    {
        rect.x = 800f/2 - 16f;
        rect.y = 800f/2 - 16f;
        speed = 5f;
        direction.x = rand.nextBoolean() ? 1f : -1;
        direction.y = rand.nextBoolean() ? 1f : -1;
        direction = direction.normalize();
    }
}
