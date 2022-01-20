package gui;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel
{
    JLabel title = new JLabel("PONG");
    JButton start = new JButton("START");
    JButton main_menu = new JButton("MAIN MENU");
    JButton quit = new JButton("QUIT");
    JPanel buttons = new JPanel();
    JPanel titleP = new JPanel();

    public Menu( )
    {
        super();
        this.layoutView();
        this.registerControllers();
        this.update();
    }


    private void layoutView()
    {
        // Title Panel
        titleP.setLayout(new FlowLayout());
        titleP.add(this.title);

        // Buttons Panel
        buttons.setLayout(new GridLayout(3,1));

        start.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttons.add(this.start);

        quit.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttons.add(this.quit);

        // Complete Layout
        this.setLayout(new BorderLayout());
        this.add(this.titleP, BorderLayout.NORTH);
        this.add(this.buttons, BorderLayout.CENTER);
    }


    private void registerControllers()
    {
        ButtonsController controller = new ButtonsController();
        this.start.addActionListener(controller);
        this.quit.addActionListener(controller);
        this.main_menu.addActionListener(controller);
    }


    private void update()
    {

    }
}
