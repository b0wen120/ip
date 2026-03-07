import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages the user interface of Kopi, how the bot speaks to user when starting up, as well as reading user inputs and printing messages
 */

public class UI {
    private Scanner in;
    private String bar = "---------------------------------------------------------------------------\n";

    public UI() {
        this.in = new Scanner(System.in);
    }

    public void showWelcome() {
        String logo = " _  __  ___   ____   ___ \n"
                + "| |/ / / _ \\ |  _ \\ |_ _|\n"
                + "| ' / | | | || |_) | | | \n"
                + "| . \\ | |_| ||  __/  | | \n"
                + "|_|\\_\\ \\___/ |_|    |___|\n";

        System.out.println("Hello from\n" + logo);
        System.out.println(bar);
        System.out.println("Hello Handsome Boy! I'm KopiOKosongPeng");
        System.out.println("What you want?\n" + bar);
    }

    public void showLine() {
        System.out.println(bar);
    }

    public String readCommand() {
        return in.nextLine().trim();
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showFoundTasks(ArrayList<Task> matchingTasks) {
        if (matchingTasks.isEmpty()) {
            System.out.println("Eh don't have what you want leh...");
        } else {
            System.out.println("Oh yeah we have, here you go: \n");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println((i + 1) + " " + matchingTasks.get(i));
            }
        }
    }
}
