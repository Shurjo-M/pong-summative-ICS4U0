package gui;

import model.Ball;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;

public class WinPanel extends JPanel {
    // Variable Declaration
    Font blippo = FontLoader.loadBlippo();                                  // Blippo font

    JLabel victory;                                                         // Victory Label
    JLabel enemyGoals;                                                      // Number of enemy goals label
    final JButton mainMenu = new JButton("RETURN TO MAIN MENU");        // Main Menu Button
    final JButton quit = new JButton("QUIT GAME");                      // Quit Game Button

    final JPanel buttons = new JPanel();                                     // Buttons Panel

    public WinPanel()
    {
        super();
        layoutView();
        registerControllers();
    }

    private void layoutView()
    {
        // Victory Message
    }


    private void registerControllers()
    {
    }
}
