package ui.viewers;

import model.WishList;
import ui.ContentFrame;

import javax.swing.*;
import java.awt.*;


//Class represents the GUI for the saved wish list that's
//loaded when the program starts

public class SavedWishListViewer extends ContentFrame {
    private WishList wishList;
    private JPanel wishListPanel;


    public SavedWishListViewer(WishList wishList) {
        this.wishList = wishList;
        setUpWindowSizeAndPlacement(400, 400);
        displayWindowOnTop();
        setUpViewingContent("Wish List");
    }

    @Override
    protected void setUpViewingContent(String windowTitle) {
        this.setTitle(windowTitle);
        layoutPanelAndScrollPane();
        formatLabelForAllDogs();
    }

    private void formatLabelForAllDogs() {
        for (int i = 0; i < wishList.size(); i++) {
            JLabel dogLabel = new JLabel(wishList.get(i).getName());
            dogLabel.setPreferredSize(new Dimension(300, 50));
            wishListPanel.add(dogLabel);
            dogLabel.setHorizontalAlignment(JLabel.CENTER);
        }
    }

    private void layoutPanelAndScrollPane() {
        this.wishListPanel = new JPanel(new GridLayout(0, 1));
        JScrollPane pane = new JScrollPane(wishListPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(pane);
        this.setVisible(true);
    }
}
