import java.awt.*;
import javax.swing.*;

import util.FontLoader;

public class Scoreboard extends JPanel
{
    // Variable Declaration
    public static int playerScore;          // Score of Player
    public static int enemyScore;           // Score of Enemy CPU
    JLabel score;                           // The score
    Font blippo = FontLoader.loadBlippo();  // The custom font for score

    public Scoreboard()
    {
        super();
        this.initialLayout();
        this.update();
    }

    private void initialLayout()
    {
        // Default Score
        playerScore = 0;
        enemyScore = 0;

        // Drawing scoreboard
        score = new JLabel(playerScore + ":" + enemyScore);
        score.setBackground(Color.black);
        score.setForeground(Color.white);

        Font blippoBold = blippo.deriveFont(Font.BOLD, 32);
        score.setFont(blippoBold);

        this.add(score);
        this.setBackground(Color.black);
        this.setForeground(Color.white);
    }

    private void update()
    {
        // Update scores and shit, dk if we need this tbh but i'll add it in case
    }
}
