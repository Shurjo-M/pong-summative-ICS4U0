package gui;

import util.LoadFonts;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel
{
    // Variable Declaration
    Font blippo = LoadFonts.loadBlippo();                        // Font

    final JLabel title = new JLabel("PONG");                // Initial Pong Layout
    final JButton newGame = new JButton("NEW GAME");
    final JButton quitGame = new JButton("QUIT GAME");
    final JPanel buttons = new JPanel();
    final JPanel titleP = new JPanel();

    Window window;                                              // In game menu
    final JPanel inGamePanel = new JPanel();
    final JButton mainMenu = new JButton("MAIN MENU");

    public Menu()
    {
        super();
        this.layoutView();
        this.registerControllers();
//        this.update();
    }

    private void layoutView()
    {
        // Title Panel
        titleP.setLayout(new FlowLayout());
        titleP.setBackground(Color.black);

        titleP.add(Box.createRigidArea(new Dimension(0, 100)));

        Font blippoTitle = blippo.deriveFont(Font.PLAIN, 64);
        title.setFont(blippoTitle);
        title.setForeground(Color.white);
        titleP.add(this.title);


        // Buttons Panel
        buttons.setLayout(new BoxLayout(this.buttons, BoxLayout.Y_AXIS));
        buttons.setBackground(Color.black);
        buttons.setAlignmentX(CENTER_ALIGNMENT);

        buttons.add(Box.createRigidArea(new Dimension(50, 450/4)));

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

    private void registerControllers()
    {
        ButtonsController controller = new ButtonsController();
        this.newGame.addActionListener(controller);
        this.quitGame.addActionListener(controller);
        this.mainMenu.addActionListener(controller);
    }

    private void update()
    {
        // Drawing in game menu
        inGamePanel.setLayout(new BoxLayout(this.inGamePanel, BoxLayout.Y_AXIS));
        inGamePanel.setBackground(Color.black);
        inGamePanel.setAlignmentX(CENTER_ALIGNMENT);

        inGamePanel.add(Box.createRigidArea(new Dimension(50, 600/3)));

        mainMenu.setAlignmentX(CENTER_ALIGNMENT);
        mainMenu.setBackground(Color.black);
        mainMenu.setForeground(Color.white);
        mainMenu.setFont(this.blippo);
        inGamePanel.add(this.newGame);

        buttons.add(Box.createRigidArea(new Dimension(50, 50)));

        quitGame.setAlignmentX(CENTER_ALIGNMENT);
        quitGame.setBackground(Color.black);
        quitGame.setForeground(Color.white);
        quitGame.setFont(this.blippo);
        inGamePanel.add(this.quitGame);

        inGamePanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        // If esc is hit, open menu

        // Other button inputs if needed
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        Menu menu = new Menu();

        frame.setSize(new Dimension(800, 600));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(menu);
        frame.setVisible(true);
    }
}
