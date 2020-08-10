package ui.listeners;

import model.WishList;
import ui.viewers.FileViewer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//Class represents the response upon clicking the more info button in the wish list

public class MoreInfoListener implements ActionListener {
    private JList list;
    private DefaultListModel listModel;
    private WishList wishList;

    public MoreInfoListener(JList list, DefaultListModel<String> listModel, WishList wishList) {
        this.list = list;
        this.listModel = listModel;
        this.wishList = wishList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = list.getSelectedIndex();
        String selected = (String) listModel.get(index);
        handleUserSelectToMoreInfo(selected, wishList);
    }

    //EFFECTS: initiates the FileViewer to view more information about the selected dog breed
    private void handleUserSelectToMoreInfo(String selected, WishList wishList) {
        for (int i = 0; i < wishList.size(); i++) {
            if (selected.equals(wishList.get(i).getName())) {
                String dogName = wishList.get(i).getName();
                File fileName = wishList.get(i).getTextInfo();
                new FileViewer(dogName, fileName);
            }
        }
    }
}
