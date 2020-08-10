package ui.listeners;

import model.WishList;
import ui.guis.WishListGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Class represents the response upon clicking the wish list button in the dog breed results

public class WishListListener extends JFrame implements ActionListener {
    private WishList wishList;

    public WishListListener(WishList wishList) {
        this.wishList = wishList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("WishList");
        frame.setSize(600, 500);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2 - frame.getWidth() / 2;
        int y = screenSize.height / 2 - frame.getHeight() / 2;
        frame.setLocation(x, y);

        JComponent newContentPane = new WishListGUI(wishList);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        frame.setVisible(true);
        frame.toFront();
        frame.setAlwaysOnTop(true);

    }
}


