package ui.listeners;

import model.WishList;
import persistence.Writer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

//Class represents the response upon clicking the save button in the wish list
//Code source: List Demo Tutorial
// https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html
public class SaveListener implements ActionListener {
    private WishList wishList;
    private static final String WISH_LIST_FILE = "./data/wishList.txt";

    public SaveListener(WishList wishList) {
        this.wishList = wishList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        saveWishList();
    }

    //EFFECTS: saves the state of the wish list to the WISH_LIST_FILE
    //Source code from TellerApp
    ////https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
    private void saveWishList() {
        try {
            Writer writer = new Writer(new File(WISH_LIST_FILE));
            for (int i = 0; i < wishList.size(); i++) {
                writer.write(wishList.get(i));
            }
            writer.close();
            System.out.println("Wish List is saved to file:  " + WISH_LIST_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save Wish List to " + WISH_LIST_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            //due to programming error
        }
    }
}