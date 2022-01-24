package gui;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class PauseMenu extends JPanel
{
    // Variable Declaration
    Font blippo = FontLoader.loadBlippo();                        // Font

    final JLabel title = new JLabel("PONG");                // Initial Pong Layout
    final JButton newGame = new JButton("NEW GAME");
    final JButton continueGame = new JButton("CONTINUE GAME");
    final JButton quitGame = new JButton("QUIT GAME");
    final JPanel buttons = new JPanel();
    final JPanel titleP = new JPanel();

    final JButton mainMenu = new JButton("MAIN MENU");

    public PauseMenu()
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

        Font blippoTitle = blippo.deriveFont(Font.PLAIN, 64);
        title.setFont(blippoTitle);
        title.setForeground(Color.white);
        titleP.add(this.title);

        // Buttons Panel
        buttons.setLayout(new BoxLayout(this.buttons, BoxLayout.Y_AXIS));
        buttons.setBackground(Color.black);
        buttons.setAlignmentX(CENTER_ALIGNMENT);

        buttons.add(Box.createRigidArea(new Dimension(50, 600/5)));

        continueGame.setAlignmentX(CENTER_ALIGNMENT);
        continueGame.setBackground(Color.black);
        continueGame.setForeground(Color.white);
        continueGame.setFont(this.blippo);
        buttons.add(this.continueGame);

        buttons.add(Box.createRigidArea(new Dimension(50, 50)));

        mainMenu.setAlignmentX(CENTER_ALIGNMENT);
        mainMenu.setBackground(Color.black);
        mainMenu.setForeground(Color.white);
        mainMenu.setFont(this.blippo);
        buttons.add(this.mainMenu);

        buttons.add(Box.createRigidArea(new Dimension(50, 50)));

        quitGame.setAlignmentX(CENTER_ALIGNMENT);
        quitGame.setBackground(Color.black);
        quitGame.setForeground(Color.white);
        quitGame.setFont(this.blippo);
        buttons.add(this.quitGame);

        // Complete Layout
        this.setBackground(Color.black);
        this.add(this.buttons);
    }

    public void registerControllers(ActionListener controller)
    {
        this.newGame.addActionListener(controller);
        this.quitGame.addActionListener(controller);
        this.mainMenu.addActionListener(controller);
        this.continueGame.addActionListener(controller);
    }

    private void update()
    {
        // Drawing in game menu when escape is hit when isRunning = true
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.black);
        this.setAlignmentX(CENTER_ALIGNMENT);

        this.add(Box.createRigidArea(new Dimension(50, Window.HEIGHT/3)));

        mainMenu.setAlignmentX(CENTER_ALIGNMENT);
        mainMenu.setBackground(Color.black);
        mainMenu.setForeground(Color.white);
        mainMenu.setFont(this.blippo);
        this.add(this.newGame);

        buttons.add(Box.createRigidArea(new Dimension(50, 50)));

        quitGame.setAlignmentX(CENTER_ALIGNMENT);
        quitGame.setBackground(Color.black);
        quitGame.setForeground(Color.white);
        quitGame.setFont(this.blippo);
        this.add(this.quitGame);

        this.setBorder(BorderFactory.createLineBorder(Color.white, 2));
    }
}
