import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages the loading and save data of tasks in Kopi onto the hard disk
 * Save tasks will be saveTasksToFile
 * Loading tasks will be loadTasksFromFile
 */

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void saveTasksToFile(ArrayList<Task> allTasks) {
        try {
            FileWriter writer = new FileWriter(this.filePath);
            for (int i = 0; i < allTasks.size(); i++) {
                writer.write(allTasks.get(i).toFileFormat() + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Eh cannot save sia: " + e.getMessage());
        }
    }

    public void loadTasksFromFile(ArrayList<Task> allTasks) {
        try {
            File f = new File(this.filePath);
            if (!f.exists()) return;
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String line = s.nextLine();
                String[] parts = line.split(" \\| ");
                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                String desc = parts[2];
                Task t = null;
                if (type.equals("T")) t = new Todo(desc);
                else if (type.equals("D")) t = new Deadline(desc, parts[3]);
                else if (type.equals("E")) t = new Event(desc, parts[3], parts[4]);
                if (t != null) {
                    if (isDone) t.markAsDone();
                    allTasks.add(t);
                }
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Got error loading file leh: " + e.getMessage());
        }
    }
}
