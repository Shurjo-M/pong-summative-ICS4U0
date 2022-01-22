import model.Entity;
import util.AABB;

import javax.swing.*;
import java.awt.*;

public class Window extends Entity
{
    /**
     * An entity that represents the game window
     * @param width width of the window
     * @param height height of the window
     * @param title window title
     * @param game Game instance
     * @param scoreboard ScoreBoard object for keeping score
     */
    public Window(int width, int height, String title, Game game, Scoreboard scoreboard)
    {
        super(new AABB(0, 0, width, height), "Window");
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setLayout(new BorderLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game, BorderLayout.CENTER);
        frame.add(scoreboard, BorderLayout.NORTH);
        frame.setVisible(true);

        // The dimensions of the scoreboard panel
        Dimension scoreDimension = scoreboard.getSize();
        // The dimensions of the game panel
        Dimension gameDimension = game.getSize();

        // assign to the window's rect
        // no horizontal shifting of the game screen
        rect.x = 0;
        // the game screen starts below the scoreboard
        rect.y = scoreDimension.height;
        // the width and height of the game canvas
        rect.w = gameDimension.width;
        rect.h = gameDimension.height;
    }
}
