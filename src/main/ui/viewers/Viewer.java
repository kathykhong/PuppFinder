package ui.viewers;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public abstract class Viewer extends JFrame {
    protected static final int WIDTH = 700;
    protected static final int HEIGHT = 600;

    protected void setUpWindowSizeAndPlacement() {
        this.setSize(WIDTH, HEIGHT);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2  - this.getWidth() / 2;
        int y = screenSize.height / 2 - this.getHeight() / 2;
        this.setLocation(x, y);
        this.setVisible(true);
        this.setAlwaysOnTop(true);

    }

    protected abstract void setUpViewingContent(String windowTitle);
}


