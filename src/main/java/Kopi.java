import java.net.UnknownServiceException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Kopi {

    public static void main(String[] args) throws KopiException {

        UI ui = new UI();
        ui.showWelcome();

        Storage storage = new Storage("./data/kopi.txt");
        ArrayList<Task>loadedTasks = new ArrayList<>();
        storage.loadTasksFromFile(loadedTasks);

        TaskList taskList = new TaskList(loadedTasks);

        File directory = new File("./data");
        if (!directory.exists()) {
            System.out.println("Brah you don't have any data folder leh, neh mind I make one for you...");
            directory.mkdir();
        }

        File f = new File("./data/kopi.txt");
        if (!f.exists()) {
            System.out.println("Brah you got like zero saved tasks, I make a new file lah...");
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Brah they don't let me create file sia, neh mind lor...");
            }
        }

        while (true) {
            String userInput = ui.readCommand();

            ui.showLine();

            try {
                boolean isExit = Parser.parse(userInput, taskList, ui, storage);
                if (isExit) {
                    break;
                }

            } catch (KopiException e) {
                System.out.println(e.getMessage());
                ui.showLine();
            }
        }
    }
}
