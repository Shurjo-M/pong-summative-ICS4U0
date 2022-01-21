import javax.swing.*;
import java.awt.*;

public class Window
{
    private final Dimension scoreDimension;   // The dimensions of the scoreboard panel
    private final Dimension gameDimension;    // The dimensions of the game panel

    public Window(int width, int height, String title, Game game, Scoreboard scoreboard)
    {
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

        scoreDimension = scoreboard.getSize();
        gameDimension = game.getSize();
    }

    public Dimension getGameDimension() {
        return gameDimension;
    }

    public Dimension getScoreDimension() {
        return scoreDimension;
    }
}
