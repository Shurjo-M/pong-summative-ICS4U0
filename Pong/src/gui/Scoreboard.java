package gui;

import util.FontLoader;

import java.awt.*;
import javax.swing.*;

public class Scoreboard extends JPanel
{
    // Variable Declaration
    JLabel score;                                               // The score
    Font blippo = FontLoader.loadBlippo();                      // The custom font for score

    public Scoreboard()
    {
        super();
        this.layoutView();
        this.update(0, 0);
    }

    private void layoutView()
    {
        // Default Score
        // Drawing scoreboard
        score = new JLabel();
        score.setBackground(Color.black);
        score.setForeground(Color.white);

        score.setFont(blippo.deriveFont(Font.BOLD, 32));

        this.add(score);
        this.setBackground(Color.black);
        this.setForeground(Color.white);
    }

    public void update(int playerScore, int enemyScore)
    {
        // Drawing scoreboard
        this.remove(score);

        score = new JLabel(playerScore + ":" + enemyScore);
        score.setBackground(Color.black);
        score.setForeground(Color.white);
        score.setFont(blippo.deriveFont(Font.BOLD, 32));

        this.add(score);
        this.setBackground(Color.black);
        this.setForeground(Color.white);

        revalidate();
        repaint();
    }
}
