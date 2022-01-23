import gui.Menu;
import model.Entity;
import util.AABB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends Entity
{
    /**
     * An entity that represents the game window
     * @param width      width of the window
     * @param height     height of the window
     * @param title      window title
     * @param game       Game instance
     * @param scoreboard ScoreBoard object for keeping score
     * @param menu       Main menu
     */
    public Window(int width, int height, String title, Game game, Scoreboard scoreboard, Menu menu)
    {
        super(new AABB(0, 0, width, height), "Window");
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setLayout(new BorderLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        var controller = new ButtonsController(
                frame,
                game,
                menu,
                scoreboard,
                this
        );
        menu.registerControllers(controller);
        frame.add(menu, BorderLayout.CENTER);
        frame.setVisible(true);


    }

    public record ButtonsController(JFrame frame, Game game, Menu menu, Scoreboard scoreboard, Window window)
            implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            switch (((JButton) e.getSource()).getText())
            {
                case "NEW GAME":
                    // Start field and make main menu screen disappear
                    frame.remove(menu);
                    frame.add(game, BorderLayout.CENTER);
                    frame.add(scoreboard, BorderLayout.NORTH);
                    frame.revalidate();

                    // The dimensions of the scoreboard panel
                    Dimension scoreDimension = scoreboard.getSize();
                    // The dimensions of the game panel
                    Dimension gameDimension = game.getSize();

                    // assign to the window's rect
                    // no horizontal shifting of the game screen
                    window.rect.x = 0;
                    // the game screen starts below the scoreboard
                    window.rect.y = scoreDimension.height;
                    // the width and height of the game canvas
                    window.rect.w = gameDimension.width;
                    window.rect.h = gameDimension.height;

                    System.out.println(window.rect.x);
                    System.out.println(window.rect.y);
                    System.out.println(window.rect.w);
                    System.out.println(window.rect.h);

                    game.start();
                    break;
                case "MAIN MENU":
                    // Reset Field and run initial layout again

                    break;
                case "QUIT GAME":
                    // Quit Game
                    System.exit(0);
                    break;
                default:
                    // how??
                    // panic 2 electric boogaloo!
                    break;
            }
        }
    }
}
