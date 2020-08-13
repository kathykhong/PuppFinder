package ui.viewers;

import ui.ContentFrame;

import javax.swing.*;
import java.awt.*;

//Class represents a photo viewer that displays an image of the selected dog breed
//Source: PhotoViewer https://github.students.cs.ubc.ca/CPSC210/Lab1-Photoviewer.git
public class PhotoViewer extends ContentFrame {
    private ImageIcon imageFile;

    public PhotoViewer(String dogBreedName, ImageIcon imageFile) {
        this.imageFile = imageFile;
        setUpWindowSizeAndPlacement(700, 600);
        displayWindowOnTop();
        setUpViewingContent(dogBreedName);

    }

    @Override
    protected void setUpViewingContent(String windowTitle) {
        this.setTitle(windowTitle);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        createAndCenterImageLabel(panel);
    }

    private void createAndCenterImageLabel(JPanel panel) {
        ImageIcon myImage = formatImageSize(this.imageFile);
        JLabel label = new JLabel(myImage, JLabel.CENTER);
        panel.add(label, BorderLayout.CENTER);
        this.add(panel);
    }

    private ImageIcon formatImageSize(ImageIcon imageIcon) {
        Image image;
        image = imageIcon.getImage();
        Image newImg = image.getScaledInstance(600, 500,  Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}

