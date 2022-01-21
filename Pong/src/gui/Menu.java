package gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Menu extends JPanel
{
    final JLabel title = new JLabel("PONG");
    final JButton newGame = new JButton("NEW GAME");
    final JButton mainMenu = new JButton("MAIN MENU");
    final JButton quitGame = new JButton("QUIT GAME");
    final JPanel buttons = new JPanel();
    final JPanel titleP = new JPanel();
    Font blippo;

    public Menu()
    {
        super();
        this.layoutView();
        this.registerControllers();
        this.update();
    }

    private void layoutView()
    {
        try
        {
            blippo = Font.createFont(Font.TRUETYPE_FONT,
                    new File("assets/Blippo.ttf"));

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,
                    new File("assets/Blippo.ttf")));

            blippo = blippo.deriveFont(Font.PLAIN, 24);
        } catch (IOException | FontFormatException e)
        {
            e.printStackTrace();
        }

        // Title Panel
        titleP.setLayout(new FlowLayout());
        titleP.setBackground(Color.black);

        Font blippoBold = blippo.deriveFont(Font.BOLD, 32);
        title.setFont(blippoBold);
        title.setForeground(Color.white);
        titleP.add(this.title);


        // Buttons Panel
        buttons.setLayout(new BoxLayout(this.buttons, BoxLayout.Y_AXIS));
        buttons.setBackground(Color.black);
        buttons.setAlignmentX(CENTER_ALIGNMENT);

        buttons.add(Box.createRigidArea(new Dimension(50, 600/3)));

        newGame.setAlignmentX(CENTER_ALIGNMENT);
        newGame.setBackground(Color.black);
        newGame.setForeground(Color.white);
        newGame.setBorder(BorderFactory.createLineBorder(Color.white));
        newGame.setFont(this.blippo);
        buttons.add(this.newGame);

        buttons.add(Box.createRigidArea(new Dimension(50, 50)));

        quitGame.setAlignmentX(CENTER_ALIGNMENT);
        quitGame.setBackground(Color.black);
        quitGame.setForeground(Color.white);
        quitGame.setBorder(BorderFactory.createLineBorder(Color.white));
        quitGame.setFont(this.blippo);
        buttons.add(this.quitGame);

        buttons.setBorder(BorderFactory.createLineBorder(Color.white, 2));

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

    }

    public static void main(String[] args){
        Menu menu = new Menu();

        JFrame main = new JFrame();
        main.setContentPane(menu);
        main.setTitle("Pong");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(800, 600);
        main.setVisible(true);
    }
}
