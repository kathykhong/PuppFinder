package ui.guis;

import model.WishList;
import javax.swing.*;
import java.awt.*;

//Class represents the GUI for the saved wish list that's
//loaded when the program starts

public class SavedWishList extends JFrame {

    public SavedWishList(WishList wishList) {
        new JFrame("Wish List");
        setSize(400, 400);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2 - this.getWidth() / 2;
        int y = screenSize.height / 2 - this.getHeight() / 2;
        setLocation(x, y);


        JPanel wishListPanel = new JPanel(new GridLayout(0, 1));
        JScrollPane pane = new JScrollPane(wishListPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(pane);
        this.setVisible(true);


        for (int i = 0; i < wishList.size(); i++) {
            JLabel dogLabel = new JLabel(wishList.get(i).getName());
            dogLabel.setPreferredSize(new Dimension(300, 50));
            wishListPanel.add(dogLabel);
            dogLabel.setHorizontalAlignment(JLabel.CENTER);
        }

        setVisible(true);
        toFront();
        setAlwaysOnTop(true);
    }
}
