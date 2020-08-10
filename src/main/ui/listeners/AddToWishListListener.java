package ui.listeners;

import model.DogBreedSet;
import model.WishList;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Class represents the response upon clicking the add button in the dog breed results
//Code sourced from List Demo Tutorial:
// https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

public class AddToWishListListener implements ActionListener {
    private JList list;
    private JButton button;
    private DefaultListModel listModel;
    private WishList wishList;
    private DogBreedSet dogBreedSet;

    public AddToWishListListener(JList list, JButton button, DefaultListModel listModel,
                                 DogBreedSet dbs, WishList wishList) {
        this.list = list;
        this.button = button;
        this.listModel = listModel;
        this.dogBreedSet = dbs;
        this.wishList = wishList;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int index = list.getSelectedIndex();
        handleUserSelectToWishList((String) listModel.get(index), dogBreedSet);
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
    //EFFECTS: add the selected dog breed to the wish list
    public void handleUserSelectToWishList(String selected, DogBreedSet dbs) {
        for (int i = 0; i < dbs.size(); i++) {
            if (selected.equals(dbs.get(i).getName())) {
                wishList.add(dbs.get(i));

            }
        }
    }




}
