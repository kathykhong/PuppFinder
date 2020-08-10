package ui.viewers;

import javax.swing.*;
import java.awt.*;

//Class represents a photo viewer that displays an image of the selected dog breed

public class PhotoViewer extends JFrame {
    private static final int WIDTH = 700;
    private static final int HEIGHT = 600;

    public PhotoViewer(String dogBreedName, ImageIcon fileName) {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(dogBreedName);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        Image image; // transform it
        image = fileName.getImage();
        Image newImg = image.getScaledInstance(600, 500,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon myImage = new ImageIcon(newImg);

        JLabel label = new JLabel(myImage, JLabel.CENTER);
        panel.add(label, BorderLayout.CENTER);
        this.add(panel);
        panel.add(Box.createVerticalStrut(200));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2  - this.getWidth() / 2;
        int y = screenSize.height / 2 - this.getHeight() / 2;
        this.setLocation(x, y);

        this.setVisible(true);
        this.setAlwaysOnTop(true);
    }
}

