package gui;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel
{
    // Variable Declaration
    Font blippo = FontLoader.loadBlippo();                        // Font

    final JLabel title = new JLabel("PONG");                // Initial Pong Layout
    final JButton newGame = new JButton("NEW GAME");
    final JButton quitGame = new JButton("QUIT GAME");
    final JPanel buttons = new JPanel();
    final JPanel titleP = new JPanel();

    final JPanel inGamePanel = new JPanel();
    final JButton mainMenu = new JButton("MAIN MENU");

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

        Font blippoTitle = blippo.deriveFont(Font.PLAIN, 64);
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

        // Complete Layout
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);

        this.add(this.titleP, BorderLayout.NORTH);
        this.add(this.buttons, BorderLayout.CENTER);
    }

    public void registerControllers(ActionListener controller)
    {
        this.newGame.addActionListener(controller);
        this.quitGame.addActionListener(controller);
        this.mainMenu.addActionListener(controller);
    }
}
