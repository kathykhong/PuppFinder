package ui.viewers;

import model.WishList;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

//Class represents the GUI for the saved wish list that's
//loaded when the program starts

public class SavedWishListViewer extends Viewer {

    public SavedWishListViewer(WishList wishList) {
        new JFrame("Wish List");
        setSize(400, 400);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2 - this.getWidth() / 2;
        int y = screenSize.height / 2 - this.getHeight() / 2;
        setLocation(x, y);
        setVisible(true);
        toFront();
        setAlwaysOnTop(true);


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

    }

    @Override
    protected void setUpViewingContent(String windowTitle) {

    }
}
