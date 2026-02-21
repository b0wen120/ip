import java.net.UnknownServiceException;
import java.util.Scanner;
import java.util.ArrayList;

public class Kopi {
    public static void main(String[] args) throws KopiException {

        Scanner in = new Scanner(System.in);
        ArrayList<Task> allTasks = new ArrayList<>();

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

            try {
                if (userInput.equals("bye")) {
                    System.out.println("Bye bye, come next order!\n" + bar);
                    break;
                }

                if (userInput.equals("list")) {
                    System.out.println("Here are the tasks in your list:\n");

                    for (int i = 0; i < allTasks.size(); i++) System.out.println((i + 1) + ". " + allTasks.get(i));
                    System.out.println(bar);
                    continue;
                }

                if (userInput.startsWith("mark ")) {
                    int taskIndex = Integer.parseInt(userInput.split(" ")[1]) -1;

                    allTasks.get(taskIndex).markAsDone();
                    System.out.println("Nice lah this one finish liao:");
                    System.out.println(" " + allTasks.get(taskIndex));
                    System.out.println(bar);

                    continue;
                }

                if (userInput.startsWith("unmark ")) {
                    int taskIndex = Integer.parseInt(userInput.split(" ")[1]) -1;

                    allTasks.get(taskIndex).unmarkAsNotDone();
                    System.out.println("Orh okay, so this one haven't finish:");
                    System.out.println(" " + allTasks.get(taskIndex));
                    System.out.println(bar);

                    continue;
                }

                if (userInput.startsWith("delete ")) {
                    int taskIndex = Integer.parseInt(userInput.split(" ")[1]) -1;

                    Task deletedTask = allTasks.remove(taskIndex);
                    System.out.println("This one don't want? Okay I remove:");
                    System.out.println(" " + deletedTask);
                    System.out.println("Now got " + allTasks.size() + " tasks only");
                    System.out.println(bar);

                    continue;
                }

                if (userInput.length() < 5 && userInput.startsWith("todo")) {
                    throw new KopiException("WOI what you want, faster leh!!");
                }

                if (userInput.startsWith("todo ")) {

                    String description = userInput.substring(5);
                    allTasks.add(new Todo(description));

                    System.out.println("Okay, I add your task liao:");
                    System.out.println(" " + allTasks.get(allTasks.size() - 1));
                    System.out.println("Now you have " + allTasks.size() + " tasks in here ah");
                    System.out.println(bar);
                    continue;
                }

                if (userInput.startsWith("deadline ")) {
                    String[] sections = userInput.substring(9).split(" /by", 2);
                    String description = sections[0];
                    String by = sections[1];

                    allTasks.add(new Deadline(description, by));

                    System.out.println("Okay, I add your task liao:");
                    System.out.println(" " + allTasks.get(allTasks.size() - 1));
                    System.out.println("Now you have " + allTasks.size() + " tasks in here ah");
                    System.out.println(bar);
                    continue;
                }

                if (userInput.startsWith("event ")) {
                    String[] sections = userInput.substring(6).split(" /from | /to");
                    String description = sections[0];
                    String from = sections[1];
                    String to = sections[2];

                    allTasks.add(new Event(description, from, to));

                    System.out.println("Okay, I add your task liao:");
                    System.out.println(" " + allTasks.get(allTasks.size() - 1));
                    System.out.println("Now you have " + allTasks.size() + " tasks in here ah");
                    System.out.println(bar);
                    continue;
                }

                System.out.println(bar);
                throw new KopiException("Brotha what does that mean sia?!\n" + bar);

            } catch (KopiException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
