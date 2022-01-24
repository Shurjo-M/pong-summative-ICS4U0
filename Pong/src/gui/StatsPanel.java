package gui;

import model.Ball;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StatsPanel extends JPanel {
    // Variable Declaration
    Font blippo = FontLoader.loadBlippo();                             // Blippo font
    int enemyScore = Ball.enemyScore;                                  // Number of enemy goals
    int playerScore = Ball.playerScore;                                // Number of player scores
    JLabel result;                                                     // Results Label
    JLabel playerStats;                                                // Player score stats
    JLabel enemyStats;                                                 // Enemy score stats
    final JButton mainMenu = new JButton("RETURN TO MAIN MENU");  // Main Menu Button

    final JPanel stats = new JPanel();

    public StatsPanel()
    {
        super();
        layoutView();
    }

    private void layoutView()
    {
        // Stats Panel
        if (playerScore < 3)
        {
            result = new JLabel("You failed to win! Too bad...");
            result.setFont(blippo.deriveFont(Font.PLAIN, 40));
            result.setBackground(Color.black);
            result.setForeground(Color.white);
            result.setAlignmentX(CENTER_ALIGNMENT);

            stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));
            stats.setBackground(Color.black);
            stats.setForeground(Color.white);
            stats.setAlignmentX(CENTER_ALIGNMENT);

            stats.add(Box.createRigidArea(new Dimension(0, 50)));

            playerStats = new JLabel("You somehow only scored " + playerScore);
            playerStats.setFont(blippo.deriveFont(Font.PLAIN, 18));
            playerStats.setBackground(Color.black);
            playerStats.setForeground(Color.white);
            playerStats.setAlignmentX(CENTER_ALIGNMENT);
            stats.add(playerStats);

            stats.add(Box.createRigidArea(new Dimension(0, 15)));

            enemyStats = new JLabel("Though your opponent scored " + enemyScore);
            enemyStats.setFont((blippo.deriveFont(Font.PLAIN, 18)));
            enemyStats.setBackground(Color.black);
            enemyStats.setForeground(Color.white);
            enemyStats.setAlignmentX(CENTER_ALIGNMENT);
            stats.add(enemyStats);

            stats.add(Box.createRigidArea(new Dimension(0, 50)));
        } else
        {
            if (enemyScore < 5){
                result = new JLabel("Nice Work! You completely beat the AI.");
                result.setFont(blippo.deriveFont(Font.PLAIN, 40));
                result.setBackground(Color.black);
                result.setForeground(Color.white);
                result.setAlignmentX(CENTER_ALIGNMENT);

                stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));
                stats.setBackground(Color.black);
                stats.setForeground(Color.white);
                stats.setAlignmentX(CENTER_ALIGNMENT);

                stats.add(Box.createRigidArea(new Dimension(0, 50)));

                playerStats = new JLabel("You obviously scored " + playerScore);
                playerStats.setFont(blippo.deriveFont(Font.PLAIN, 18));
                playerStats.setBackground(Color.black);
                playerStats.setForeground(Color.white);
                playerStats.setAlignmentX(CENTER_ALIGNMENT);
                stats.add(playerStats);

                stats.add(Box.createRigidArea(new Dimension(0, 15)));

                enemyStats = new JLabel("While your opponent scored " + enemyScore);
                enemyStats.setFont((blippo.deriveFont(Font.PLAIN, 18)));
                enemyStats.setBackground(Color.black);
                enemyStats.setForeground(Color.white);
                enemyStats.setAlignmentX(CENTER_ALIGNMENT);
                stats.add(enemyStats);

                stats.add(Box.createRigidArea(new Dimension(0, 50)));
            } else if(enemyScore > 5 && enemyScore < 10)
            {
                result = new JLabel("Good Job! You beat the AI but it got quite a few points.");
                result.setFont(blippo.deriveFont(Font.PLAIN, 40));
                result.setBackground(Color.black);
                result.setForeground(Color.white);
                result.setAlignmentX(CENTER_ALIGNMENT);

                stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));
                stats.setBackground(Color.black);
                stats.setForeground(Color.white);
                stats.setAlignmentX(CENTER_ALIGNMENT);

                stats.add(Box.createRigidArea(new Dimension(0, 50)));

                playerStats = new JLabel("You obviously scored " + playerScore);
                playerStats.setFont(blippo.deriveFont(Font.PLAIN, 18));
                playerStats.setBackground(Color.black);
                playerStats.setForeground(Color.white);
                playerStats.setAlignmentX(CENTER_ALIGNMENT);
                stats.add(playerStats);

                stats.add(Box.createRigidArea(new Dimension(0, 15)));

                enemyStats = new JLabel("While your opponent scored " + enemyScore);
                enemyStats.setFont((blippo.deriveFont(Font.PLAIN, 18)));
                enemyStats.setBackground(Color.black);
                enemyStats.setForeground(Color.white);
                enemyStats.setAlignmentX(CENTER_ALIGNMENT);
                stats.add(enemyStats);

                stats.add(Box.createRigidArea(new Dimension(0, 50)));
            }else
            {
                result = new JLabel("You've beaten the AI. Finally...");
                result.setFont(blippo.deriveFont(Font.PLAIN, 40));
                result.setBackground(Color.black);
                result.setForeground(Color.white);
                result.setAlignmentX(CENTER_ALIGNMENT);

                stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));
                stats.setBackground(Color.black);
                stats.setForeground(Color.white);
                stats.setAlignmentX(CENTER_ALIGNMENT);

                stats.add(Box.createRigidArea(new Dimension(0, 50)));

                playerStats = new JLabel("You obviously scored " + playerScore);
                playerStats.setFont(blippo.deriveFont(Font.PLAIN, 18));
                playerStats.setBackground(Color.black);
                playerStats.setForeground(Color.white);
                playerStats.setAlignmentX(CENTER_ALIGNMENT);
                stats.add(playerStats);

                stats.add(Box.createRigidArea(new Dimension(0, 15)));

                enemyStats = new JLabel("While your opponent scored more than double your points at " + enemyScore);
                enemyStats.setFont((blippo.deriveFont(Font.PLAIN, 18)));
                enemyStats.setBackground(Color.black);
                enemyStats.setForeground(Color.white);
                enemyStats.setAlignmentX(CENTER_ALIGNMENT);
                stats.add(enemyStats);

                stats.add(Box.createRigidArea(new Dimension(0, 50)));
            }
        }

        // Complete layout
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);
        this.setForeground(Color.white);

        mainMenu.setFont(blippo);
        mainMenu.setBackground(Color.black);
        mainMenu.setForeground(Color.white);
        mainMenu.setAlignmentX(CENTER_ALIGNMENT);

        this.add(result, BorderLayout.NORTH);
        this.add(stats, BorderLayout.CENTER);
        this.add(mainMenu, BorderLayout.SOUTH);
    }

    public void registerControllers(ActionListener controller)
    {
        this.mainMenu.addActionListener(controller);
    }
}
