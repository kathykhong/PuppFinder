package ui;

import javax.swing.*;
import java.awt.*;

public abstract class ContentFrame extends JFrame {

    protected void setUpWindowSizeAndPlacement(int width, int height) {
        this.setSize(width, height);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2 - this.getWidth() / 2;
        int y = screenSize.height / 2 - this.getHeight() / 2;
        this.setLocation(x, y);
    }

    protected void displayWindowOnTop() {
        this.setVisible(true);
        this.setAlwaysOnTop(true);
    }

    protected abstract void setUpViewingContent(String windowTitle);
}


