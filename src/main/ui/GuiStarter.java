package ui;

import model.DogBreedSet;
import model.WishList;
import ui.guis.PuppResultGUI;
import javax.swing.*;
import java.awt.*;

//Class represents the Gui initialization for the dog breed results
//after the questionaire

public class GuiStarter {

    public GuiStarter(DogBreedSet dogBreedResults, WishList wishList)  {
        JFrame frame = new JFrame("Your DogBreed Results");
        frame.setSize(400, 500);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2 - frame.getWidth() / 2;
        int y = screenSize.height / 2 - frame.getHeight() / 2;
        frame.setLocation(x, y);

        //Create and set up the content pane.
        JComponent newContentPane = new PuppResultGUI(dogBreedResults, wishList);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.setVisible(true);
        frame.toFront();
        frame.setAlwaysOnTop(true);

    }
}
