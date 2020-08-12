package ui.viewers;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public abstract class Viewer extends JFrame {


    protected void setUpWindowSizeAndPlacement(int width, int height) {
        this.setSize(width, height);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2  - this.getWidth() / 2;
        int y = screenSize.height / 2 - this.getHeight() / 2;
        this.setLocation(x, y);
        this.setVisible(true);
        this.setAlwaysOnTop(true);

    }

    protected abstract void setUpViewingContent(String windowTitle);
}


