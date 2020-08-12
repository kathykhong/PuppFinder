package ui.viewers;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.io.*;

//Class represents a File Viewer that's used to read the text file containing the
//highlights of the dog breed

public class FileViewer extends Viewer {
    private File file;

    //Code for frame and text area construction source: ListDemo Tutorial
    // https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html
    //Code for scroll pane in text area :
    //https://stackoverflow.com/questions/20341885/how-to-display-a-text-file-
    // from-a-gui#:~:text=The%20easiest%20way%20to%20do,scrollPane%20%3D%20new%20JScrollPane(%20textArea%20)%3B
    public FileViewer(String dogName, File file) {
        this.file = file;
        setUpWindowSizeAndPlacement(700, 600);
        setUpViewingContent(dogName);
    }

    //EFFECTS:Wraps the lines of the JTextArea if it does not fit in the
    //Source:https://kodejava.org/how-do-i-wrap-the-text-lines-in-jtextarea/
    private void wrapText(JTextArea textArea) {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }

    //EFFECTS: loads the text file into the text area, throws an exception if file does not exist
    //Source: https://stackoverflow.com/questions/5880169/loading-a-text-file-into-a-textarea
    public static void readFile(String fn, JTextComponent pane) {
        try {
            FileReader reader = new FileReader(fn);
            BufferedReader br = new BufferedReader(reader);
            pane.read(br, null);
            br.close();
            pane.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void setUpViewingContent(String windowTitle) {
        this.setTitle(windowTitle);
        JTextArea textArea = new JTextArea();
        textArea.setColumns(50);
        textArea.setRows(60);
        textArea.setFont(new Font("Plain", Font.BOLD, 14));
        wrapText(textArea);
        JScrollPane sp = new JScrollPane(textArea);
        this.getContentPane().add(sp);
        readFile(this.file.toString(), textArea);
    }
}
