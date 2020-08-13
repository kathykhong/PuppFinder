package ui.guis;

import model.DogBreedSet;
import model.WishList;
import ui.listeners.AddToWishListListener;
import ui.listeners.ViewImageListener;
import ui.listeners.WishListListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;



//Class represents the GUI for the dog breed results following the questionaire
//users are able to view the results and have the option to view the image of the
//selected dog, add them to a wish list, and view the wish list

//Code source: List Demo Tutorial
// https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html
public class PuppResultGUI extends JPanel implements ListSelectionListener {
    private JList list;
    private static final String ADD_TO_WISH_LIST_STRING = "Add to Wish List";
    private static final String WISH_LIST_STRING = "Wish List";
    private static final String VIEW_IMAGE_STRING = "View Image";
    private JButton viewImageButton;
    private JButton addButton;
    private JButton wishListButton;
    private DefaultListModel<String> listModel;

    public PuppResultGUI(DogBreedSet dogBreedResult, WishList wishList) {
        super(new BorderLayout());
        this.listModel = new DefaultListModel<>();
        for (int i = 0; i < dogBreedResult.size(); i++) {
            listModel.addElement(dogBreedResult.get(i).getName());
            setUpListLayout();
            setUpAddButton(dogBreedResult, wishList);
            setUpWishListButton(wishList);
            setUpViewImageButton(dogBreedResult);
            createButtonPanelAndScrollPane();
        }
    }

    //MODIFIES: this
    //EFFECTS: creates and formats button panel along with the scroll bar
    private void createButtonPanelAndScrollPane() {
        JScrollPane listScrollPane = new JScrollPane(list);
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
        buttonPane.add(addButton);
        buttonPane.add(wishListButton);
        buttonPane.add(viewImageButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }

    //MODIFIES: this
    //EFFECTS: creates button to view image of the selected dog breed
    private void setUpViewImageButton(DogBreedSet dogBreedResult) {
        viewImageButton = new JButton(VIEW_IMAGE_STRING);
        viewImageButton.setActionCommand(VIEW_IMAGE_STRING);
        viewImageButton.addActionListener(new ViewImageListener(list, listModel, dogBreedResult));
    }

    //MODIFIES: this
    //EFFECTS: creates a button to view the wish list
    private void setUpWishListButton(WishList wishList) {
        wishListButton = new JButton(WISH_LIST_STRING);
        wishListButton.setActionCommand(WISH_LIST_STRING);
        wishListButton.addActionListener(new WishListListener(wishList));
    }

    //MODIFIES: this
    //EFFECTS: creates a button to add the selected dog breed to a wish list
    private void setUpAddButton(DogBreedSet dogBreedResult, WishList wishList) {
        addButton = new JButton(ADD_TO_WISH_LIST_STRING);
        addButton.setActionCommand(ADD_TO_WISH_LIST_STRING);
        addButton.addActionListener(new AddToWishListListener(list, addButton, listModel, dogBreedResult, wishList));
    }

    //MODIFIES: this
    //EFFECTS: layout and formats the dog breed results
    public void setUpListLayout() {
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
        if (!e.getValueIsAdjusting()) {
            if (list.getSelectedIndex() == -1) {
                //no selection, disable add button, disable view Image button
                setStatusOfButtons(false);
            } else {
                //Selection, enable the add button, view button
                setStatusOfButtons(true);
            }
        }
    }

    private void setStatusOfButtons(boolean b) {
        addButton.setEnabled(b);
        viewImageButton.setEnabled(b);
    }
}


