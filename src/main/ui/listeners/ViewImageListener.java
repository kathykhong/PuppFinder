package ui.listeners;

import model.DogBreedSet;
import ui.viewers.PhotoViewer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Class represents the response upon clicking the view image button in the dog breed results

public class ViewImageListener implements ActionListener {
    private DogBreedSet dogBreedResult;
    private JList<String> list;
    private DefaultListModel<String> listModel;

    public ViewImageListener(JList list, DefaultListModel listModel, DogBreedSet dogBreedResult) {
        this.list = list;
        this.listModel = listModel;
        this.dogBreedResult = dogBreedResult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = list.getSelectedIndex();
        String selected = listModel.get(index);
        handleUserSelectToViewImage(selected, dogBreedResult);
    }

    //EFFECTS: initiates the PhotoViewer to view an image of selected dog breed
    private void handleUserSelectToViewImage(String selected, DogBreedSet dbs) {
        for (int i = 0; i < dbs.size(); i++) {
            if (selected.equals(dbs.get(i).getName())) {
                String dogName = dbs.get(i).getName();
                ImageIcon fileName = dbs.get(i).getImageFile();
                new PhotoViewer(dogName, fileName);
            }


        }
    }
}
