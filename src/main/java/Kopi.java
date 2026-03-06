import java.net.UnknownServiceException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Kopi {

    /*private static void saveTasksToFile(ArrayList<Task> allTasks) {
        try {
            FileWriter writer = new FileWriter("./data/kopi.txt");
            for (int i = 0; i < allTasks.size(); i++) {
                writer.write(allTasks.get(i).toFileFormat() + System.lineSeparator());
            }
            writer.close();
        } catch (java.io.IOException e) {
            System.out.println("Eh cannot save sia: " + e.getMessage());
        }
    }

    private static void loadTasksFromFile(ArrayList<Task> allTasks) {
        try {
            File f = new File("./data/kopi.txt");
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
            System.out.println("Error loading file: " + e.getMessage());
        }
    }*/

    public static void main(String[] args) throws KopiException {

        //Scanner in = new Scanner(System.in);

        UI ui = new UI();
        ui.showWelcome();

        //ArrayList<Task> allTasks = new ArrayList<>();

        Storage storage = new Storage("./data/kopi.txt");
        ArrayList<Task>loadedTasks = new ArrayList<>();
        storage.loadTasksFromFile(loadedTasks);

        TaskList taskList = new TaskList(loadedTasks);

        //loadTasksFromFile(allTasks);

        /*String logo = " _  __  ___   ____   ___ \n"
                + "| |/ / / _ \\ |  _ \\ |_ _|\n"
                + "| ' / | | | || |_) | | | \n"
                + "| . \\ | |_| ||  __/  | | \n"
                + "|_|\\_\\ \\___/ |_|    |___|\n";

        String bar = "------------------------------------------------------\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(bar);
        System.out.println("Hello Handsome Boy! I'm KopiOKosongPeng");
        System.out.println("What you want?\n" + bar);*/

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
                /*if (userInput.equals("bye")) {
                    System.out.println("Bye bye, come next order!\n");
                    ui.showLine();
                    break;
                }

                if (userInput.equals("list")) {
                    System.out.println("Here are the tasks in your list:\n");

                    for (int i = 0; i < taskList.getSize(); i++) System.out.println((i + 1) + ". " + taskList.getTask(i));
                    ui.showLine();
                    continue;
                }

                if (userInput.startsWith("mark ")) {
                    int taskIndex = Integer.parseInt(userInput.split(" ")[1]) - 1;

                    taskList.getTask(taskIndex).markAsDone();
                    System.out.println("Nice lah this one finish liao:");
                    System.out.println(" " + taskList.getTask(taskIndex));
                    ui.showLine();

                    storage.saveTasksToFile(loadedTasks);
                    continue;
                }

                if (userInput.startsWith("unmark ")) {
                    int taskIndex = Integer.parseInt(userInput.split(" ")[1]) - 1;

                    taskList.getTask(taskIndex).unmarkAsNotDone();
                    System.out.println("Orh okay, so this one haven't finish:");
                    System.out.println(" " + taskList.getTask(taskIndex));
                    ui.showLine();

                    storage.saveTasksToFile(loadedTasks);
                    continue;
                }

                if (userInput.startsWith("delete ")) {
                    int taskIndex = Integer.parseInt(userInput.split(" ")[1]) - 1;

                    Task deletedTask = taskList.removeTask(taskIndex);
                    System.out.println("This one don't want? Okay I remove:");
                    System.out.println(" " + deletedTask);
                    System.out.println("Now got " + taskList.getSize() + " tasks only");
                    ui.showLine();

                    storage.saveTasksToFile(loadedTasks);
                    continue;
                }

                if (userInput.length() < 5 && userInput.startsWith("todo")) {
                    throw new KopiException("WOI what you want, faster leh!!");
                }

                if (userInput.startsWith("todo ")) {

                    String description = userInput.substring(5);
                    taskList.addTask(new Todo(description));

                    System.out.println("Okay, I add your task liao:");
                    System.out.println(" " + taskList.getTask(taskList.getSize() - 1));
                    System.out.println("Now you have " + taskList.getSize() + " tasks in here ah");
                    ui.showLine();

                    storage.saveTasksToFile(loadedTasks);
                    continue;
                }

                if (userInput.startsWith("deadline ")) {
                    String[] sections = userInput.substring(9).split(" by", 2);
                    String description = sections[0];
                    String by = sections[1];

                    taskList.addTask(new Deadline(description, by));

                    System.out.println("Okay, I add your task liao:");
                    System.out.println(" " + taskList.getTask(taskList.getSize() - 1));
                    System.out.println("Now you have " + taskList.getSize() + " tasks in here ah");
                    ui.showLine();

                    storage.saveTasksToFile(loadedTasks);
                    continue;
                }

                if (userInput.startsWith("event ")) {
                    String[] sections = userInput.substring(6).split(" from | to");
                    String description = sections[0];
                    String from = sections[1];
                    String to = sections[2];

                    taskList.addTask(new Event(description, from, to));

                    System.out.println("Okay, I add your task liao:");
                    System.out.println(" " + taskList.getTask(taskList.getSize() - 1));
                    System.out.println("Now you have " + taskList.getSize() + " tasks in here ah");
                    ui.showLine();

                    storage.saveTasksToFile(loadedTasks);
                    continue;
                }

                //ui.showLine();
                throw new KopiException("Brotha what does that mean sia?!\n");*/

            } catch (KopiException e) {
                System.out.println(e.getMessage());
                ui.showLine();
            }
        }
    }
}
