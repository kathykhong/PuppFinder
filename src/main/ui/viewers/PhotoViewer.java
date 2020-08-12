package ui.viewers;

import javax.swing.*;
import java.awt.*;

//Class represents a photo viewer that displays an image of the selected dog breed
//Source: PhotoViewer https://github.students.cs.ubc.ca/CPSC210/Lab1-Photoviewer.git
public class PhotoViewer extends Viewer {
    private ImageIcon imageFile;


    public PhotoViewer(String dogBreedName, ImageIcon imageFile) {
        this.imageFile = imageFile;
        setUpWindowSizeAndPlacement();
        setUpViewingContent(dogBreedName);

    }

    @Override
    protected void setUpViewingContent(String windowTitle) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        this.setTitle(windowTitle);
        ImageIcon myImage = formatImageSize(this.imageFile);
        JLabel label = new JLabel(myImage, JLabel.CENTER);
        panel.add(label, BorderLayout.CENTER);
        this.add(panel);
        panel.add(Box.createVerticalStrut(200));
    }

    private ImageIcon formatImageSize(ImageIcon imageIcon) {
        Image image;
        image = imageIcon.getImage();
        Image newImg = image.getScaledInstance(600, 500,  Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}

