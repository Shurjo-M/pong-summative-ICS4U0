package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Menu extends JPanel
{
    JLabel title = new JLabel("PONG");
    JButton start = new JButton("START");
    JButton main_menu = new JButton("MAIN MENU");
    JButton quit = new JButton("QUIT");
    Graphics g = this.getGraphics();
    JPanel bar1 = new BarPanel1();
    JPanel bar2 = new BarPanel2();
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
        buttons.setLayout(new GridLayout(2,1));

        start.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttons.add(this.start);

        quit.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttons.add(this.quit);

        // Bar Panels
        bar1.setLayout(new FlowLayout());
        bar1.setBackground(Color.black);
        bar1.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));

        bar2.setLayout(new GridBagLayout());
        bar2.setBackground(Color.black);
        bar2.setBorder(BorderFactory.createEmptyBorder(50,150,50,50));

        // Complete Layout
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);
        this.add(this.titleP, BorderLayout.NORTH);
        this.add(this.buttons, BorderLayout.CENTER);
        this.add(this.bar1, BorderLayout.EAST);
        this.add(this.bar2, BorderLayout.WEST);
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

    class BarPanel1 extends JPanel{
        BarPanel1(){
            setPreferredSize(new Dimension(300, 600));
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            g.setColor(Color.white);
            g.fillRect(30, 50, 70, 200);
        }
    }

    class BarPanel2 extends JPanel{
        BarPanel2(){
            setPreferredSize(new Dimension(300, 600));
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            g.setColor(Color.white);
            g.fillRect(130, 50, 70, 200);
        }
    }


    public static void main(String[] args){
        Menu menu = new Menu();

        JFrame main = new JFrame();
        main.setContentPane(menu);
        main.setTitle("Hangman");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(800, 600);
        main.setVisible(true);
    }
}
