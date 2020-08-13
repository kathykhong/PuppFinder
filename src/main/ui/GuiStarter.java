package ui;

import model.DogBreedSet;
import model.WishList;
import ui.guis.PuppResultGUI;
import javax.swing.*;

//Class represents the Gui initialization for the dog breed results
//after the questionaire
//Code source: List Demo Tutorial
// https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html
public class GuiStarter extends ContentFrame {
    private DogBreedSet dogBreedResults;
    private WishList wishList;

    public GuiStarter(DogBreedSet dogBreedResults, WishList wishList)  {
        this. dogBreedResults = dogBreedResults;
        this.wishList = wishList;
        setUpWindowSizeAndPlacement(400, 500);
        setUpViewingContent("Your Dog Breed Results");
        displayWindowOnTop();
    }


    @Override
    protected void setUpViewingContent(String windowTitle) {
        this.setTitle("Your DogBreed Results");
        JComponent newContentPane = new PuppResultGUI(dogBreedResults, wishList);
        newContentPane.setOpaque(true);
        this.setContentPane(newContentPane);
    }
}
