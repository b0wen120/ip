import java.net.UnknownServiceException;
import java.util.Scanner;

public class Kopi {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Task[] allTasks = new Task[100];
        int allTasksCount = 0;

        String logo = " _  __  ___   ____   ___ \n"
                + "| |/ / / _ \\ |  _ \\ |_ _|\n"
                + "| ' / | | | || |_) | | | \n"
                + "| . \\ | |_| ||  __/  | | \n"
                + "|_|\\_\\ \\___/ |_|    |___|\n";

        String bar = "------------------------------------------------------\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(bar);
        System.out.println("Hello Handsome Boy! I'm KopiOKosongPeng");
        System.out.println("What you want?\n" + bar);

        while (true) {
            String userInput = in.nextLine().trim();

            System.out.println(bar);

            if (userInput.equals("bye")) {
                System.out.println("Bye bye, come next order!\n" + bar);
                break;
            }

            if (userInput.equals("list")) {
                System.out.println("Here are the tasks in your list:\n");

                for (int i = 0; i < allTasksCount; i++) {
                    System.out.println((i + 1) + ". " + allTasks[i]);
                }
                System.out.println(bar);
                continue;
            }

            if (userInput.startsWith("mark ")) {
                int taskIndex = Integer.parseInt(userInput.split(" ")[1]) -1;

                allTasks[taskIndex].markAsDone();
                System.out.println("Nice lah this one finish liao:");
                System.out.println(" " + allTasks[taskIndex]);
                System.out.println(bar);

                continue;
            }

            if (userInput.startsWith("unmark ")) {
                int taskIndex = Integer.parseInt(userInput.split(" ")[1]) -1;

                allTasks[taskIndex].unmarkAsNotDone();
                System.out.println("Orh okay, so this one haven't finish:");
                System.out.println(" " + allTasks[taskIndex]);
                System.out.println(bar);

                continue;
            }

            if (userInput.startsWith("todo ")) {
                String description = userInput.substring(5);
                allTasks[allTasksCount++] = new Todo(description);

                System.out.println("Okay, I add your task liao:");
                System.out.println(" " + allTasks[allTasksCount - 1]);
                System.out.println("Now you have " + allTasksCount + " tasks in here ah");
                System.out.println(bar);
                continue;
            }

            if (userInput.startsWith("deadline ")) {
                String[] sections = userInput.substring(9).split(" /by", 2);
                String description = sections[0];
                String by = sections[1];

                allTasks[allTasksCount++] = new Deadline(description, by);

                System.out.println("Okay, I add your task liao:");
                System.out.println(" " + allTasks[allTasksCount - 1]);
                System.out.println("Now you have " + allTasksCount + " tasks in here ah");
                System.out.println(bar);
                continue;
            }

            if (userInput.startsWith("event ")) {
                String[] sections = userInput.substring(6).split(" /from | /to");
                String description = sections[0];
                String from = sections[1];
                String to = sections[2];

                allTasks[allTasksCount++] = new Event(description, from, to);

                System.out.println("Okay, I add your task liao:");
                System.out.println(" " + allTasks[allTasksCount - 1]);
                System.out.println("Now you have " + allTasksCount + " tasks in here ah");
                System.out.println(bar);
                continue;
            }

            allTasks[allTasksCount] = new Task(userInput);
            allTasksCount++;

            System.out.println("added: " + userInput);
            System.out.println(bar);
        }
    }
}
