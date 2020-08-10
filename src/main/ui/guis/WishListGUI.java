package ui.guis;

import model.WishList;
import ui.listeners.DeleteListener;
import ui.listeners.MoreInfoListener;
import ui.listeners.SaveListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

//Class represents the GUI for the wish list
//users are able to view the dog breeds they have added and have the
//options to delete or view more information about the selected dog breed

public class WishListGUI extends JPanel implements ListSelectionListener {
    private JList list;
    private static final String MORE_INFO_STRING = "More Info";
    private static final String DELETE_STRING = "Delete";
    private static final String SAVE_STRING = "Save";
    private JButton moreInfoButton;
    private JButton deleteButton;
    private JButton saveButton;


    public WishListGUI(WishList wishList) {
        super(new BorderLayout());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i = 0; i < wishList.size(); i++) {
            listModel.addElement(wishList.get(i).getName());
        }

        setUpWishListLayout(listModel);
        createDeleteButton(wishList, listModel);
        createMoreInfoButton(wishList, listModel);
        createSaveButton(wishList);
        setUpButtonPaneAndScrollPane();
    }

    //MODIFIES: this
    //EFFECTS: creates and layout the button panel along with the scroll bar
    private void setUpButtonPaneAndScrollPane() {
        JScrollPane listScrollPane = new JScrollPane(list);
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
        buttonPane.add(deleteButton);
        buttonPane.add(moreInfoButton);
        buttonPane.add(saveButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }

    //MODIFIES: this
    //EFFECTS: creates a button to save the wish list
    private void createSaveButton(WishList wishList) {
        saveButton = new JButton(SAVE_STRING);
        saveButton.setActionCommand(SAVE_STRING);
        saveButton.addActionListener(new SaveListener(wishList));
    }

    //MODIFIES: this
    //EFFECTS: creates a button to view more information about the selected dog breed
    private void createMoreInfoButton(WishList wishList, DefaultListModel<String> listModel) {
        moreInfoButton = new JButton(MORE_INFO_STRING);
        moreInfoButton.setActionCommand(MORE_INFO_STRING);
        moreInfoButton.addActionListener(new MoreInfoListener(list, listModel, wishList));
    }

    //MODIFIES: this
    //EFFECTS: creates a button to delete the selected dog breed from a wish list
    private void createDeleteButton(WishList wishList, DefaultListModel<String> listModel) {
        deleteButton = new JButton(DELETE_STRING);
        deleteButton.setActionCommand(DELETE_STRING);
        deleteButton.addActionListener(new DeleteListener(wishList, deleteButton, list, listModel));
    }

    //MODIFIES: this
    //EFFECTS: sets up and formats the layout of the wish list
    private void setUpWishListLayout(DefaultListModel<String> listModel) {
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setFont(new Font("Plain", Font.PLAIN, 14));
        list.setSelectionBackground(Color.pink);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(10);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (list.getSelectedIndex() == -1) {
            //no selection, disable delete button, disable moreInfo button
            deleteButton.setEnabled(false);
            moreInfoButton.setEnabled(false);

        } else {
            //Selection, enable the delete button, more info button
            deleteButton.setEnabled(true);
            moreInfoButton.setEnabled(true);
        }
    }
}
