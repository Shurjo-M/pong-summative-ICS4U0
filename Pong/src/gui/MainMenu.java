package gui;
import util.FontLoader;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel
{
    // Variable Declaration
    Font blippo = FontLoader.loadBlippo();                                      // Font

    final JLabel title = new JLabel("PONG BUT IT'S REALLY HARD");           // Initial Pong Layout
    final JButton newGame = new JButton("NEW GAME");                        // New game button
    final JButton quitGame = new JButton("QUIT GAME");                      // Quit game button
    final JLabel winCondition = new JLabel("Get 5 points to win!");         // Win Condition label
    final JLabel controls = new JLabel("Use W and S to move.");             // Movement controls label
    final JLabel pause = new JLabel("Press ESC to end the game.");          // Pause controls label

    final JPanel titleP = new JPanel();                                         // Title panel
    final JPanel buttons = new JPanel();                                        // Buttons panel
    final JPanel rules = new JPanel();                                          // Rules Panel


    public MainMenu()
    {
        super();
        this.layoutView();
    }

    private void layoutView()
    {
        // Title Panel
        titleP.setLayout(new FlowLayout());
        titleP.setBackground(Color.black);

        titleP.add(Box.createRigidArea(new Dimension(0, Window.HEIGHT)));

        Font blippoTitle = blippo.deriveFont(Font.PLAIN, 48);
        title.setFont(blippoTitle);
        title.setForeground(Color.white);
        titleP.add(this.title);

        // Buttons Panel
        buttons.setLayout(new BoxLayout(this.buttons, BoxLayout.Y_AXIS));
        buttons.setBackground(Color.black);
        buttons.setAlignmentX(CENTER_ALIGNMENT);

        buttons.add(Box.createRigidArea(new Dimension(50, 600/4)));

        newGame.setAlignmentX(CENTER_ALIGNMENT);
        newGame.setBackground(Color.black);
        newGame.setForeground(Color.white);
        newGame.setFont(this.blippo);
        buttons.add(this.newGame);

        buttons.add(Box.createRigidArea(new Dimension(50, 50)));

        quitGame.setAlignmentX(CENTER_ALIGNMENT);
        quitGame.setBackground(Color.black);
        quitGame.setForeground(Color.white);
        quitGame.setFont(this.blippo);
        buttons.add(this.quitGame);

        // Message panel

        TitledBorder titledBorder = new TitledBorder(BorderFactory.createLineBorder(Color.white), "Rules");
        titledBorder.setTitleColor(Color.WHITE);
        titledBorder.setTitleFont(blippo.deriveFont(Font.PLAIN, 18));

        rules.setLayout(new BoxLayout(this.rules, BoxLayout.Y_AXIS));
        rules.setBackground(Color.black);
        rules.setBorder(titledBorder);
        rules.setForeground(Color.white);
        rules.setAlignmentX(CENTER_ALIGNMENT);

        rules.add(Box.createRigidArea(new Dimension(0, 15)));

        winCondition.setBackground(Color.black);
        winCondition.setForeground(Color.white);
        winCondition.setFont(this.blippo.deriveFont(Font.PLAIN, 28));
        winCondition.setAlignmentX(CENTER_ALIGNMENT);
        rules.add(this.winCondition);

        rules.add(Box.createRigidArea(new Dimension(0, 15)));

        controls.setBackground(Color.black);
        controls.setForeground(Color.white);
        controls.setFont(this.blippo.deriveFont(Font.PLAIN, 18));
        controls.setAlignmentX(CENTER_ALIGNMENT);
        rules.add(this.controls);

        pause.setBackground(Color.black);
        pause.setForeground(Color.white);
        pause.setFont(this.blippo.deriveFont(Font.PLAIN, 18));
        pause.setAlignmentX(CENTER_ALIGNMENT);
        rules.add(this.pause);

        rules.add(Box.createRigidArea(new Dimension(0, 15)));

        // Complete Layout
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);

        this.add(this.titleP, BorderLayout.NORTH);
        this.add(this.buttons, BorderLayout.CENTER);
        this.add(this.rules, BorderLayout.SOUTH);
    }

    public void registerControllers(ActionListener controller)
    {
        this.newGame.addActionListener(controller);
        this.quitGame.addActionListener(controller);
    }
}
