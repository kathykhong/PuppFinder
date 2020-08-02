package persistence;

import java.io.PrintWriter;

// Represents data that can be saved to file
//**Code for interface taken from TellerApp:
//https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
public interface Saveable {
    // MODIFIES: printWriter
    // EFFECTS: writes the saveable to printWriter
    void save(PrintWriter printWriter);
}
