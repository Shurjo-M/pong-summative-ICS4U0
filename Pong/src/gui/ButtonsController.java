package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsController implements ActionListener {
    public ButtonsController() // Link it to the required classes
    {
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (((JButton) e.getSource()).getText()) {
            case "NEW GAME":
                // Start field and make main menu screen disappear

                break;
            case "MAIN MENU":
                // Reset Field and run initial layout again

                break;
            case "QUIT GAME":
                // Quit Game

                break;
            default:
                // how??
                // panic 2 electric boogaloo!
                break;
        }
    }
}
