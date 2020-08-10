package ui.listeners;

import model.WishList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Class represents the response upon clicking the delete button in the wish list
public class DeleteListener implements ActionListener {
    private WishList wishList;
    private JButton button;
    private JList list;
    private DefaultListModel listModel;

    public DeleteListener(WishList wishList, JButton button, JList list, DefaultListModel listModel) {
        this.wishList = wishList;
        this.button = button;
        this.list = list;
        this. listModel = listModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = list.getSelectedIndex();
        handleUserSelectToDelete((String) listModel.get(index), wishList);
        listModel.remove(index);


        int size = listModel.getSize();
        if (size == 0) {
            button.setEnabled(false);
        } else {
            if (index == listModel.getSize()) {
                index--;
            }
        }
        list.setSelectedIndex(index);
        list.ensureIndexIsVisible(index);

    }

    //MODIFIES: wishList
    //EFFECTS: removes the selected dog breed from the wish list
    private void handleUserSelectToDelete(String selected, WishList wishList) {
        for (int i = 0; i < wishList.size(); i++) {
            if (selected.equals(wishList.get(i).getName())) {
                wishList.remove(wishList.get(i));

            }
        }
    }
}
