package ui.listeners;

import model.WishList;
import ui.ContentFrame;
import ui.guis.WishListGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Class represents the response upon clicking the wish list button in the dog breed results
//Code source: List Demo Tutorial
// https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html
public class WishListListener extends ContentFrame implements ActionListener {
    private WishList wishList;

    public WishListListener(WishList wishList) {
        this.wishList = wishList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setUpWindowSizeAndPlacement(600, 500);
        setUpViewingContent("Wish List");
        displayWindowOnTop();
    }

    @Override
    protected void setUpViewingContent(String windowTitle) {
        this.setTitle(windowTitle);
        JComponent newContentPane = new WishListGUI(wishList);
        newContentPane.setOpaque(true); //content panes must be opaque
        this.setContentPane(newContentPane);
    }
}


