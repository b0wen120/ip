import java.util.Scanner;

public class Kopi {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] allTasks = new String[100];
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
            String input = in.nextLine();

            System.out.println(bar);

            if (input.equals("bye")) {
                System.out.println("Bye bye, come next order!\n" + bar);
                break;
            }

            if (input.equals("list")) {
                for (int i = 0; i < allTasksCount; i++) {
                    System.out.println((i + 1) + ". " + allTasks[i]);
                }
                System.out.println(bar);
                continue;
            }

            allTasks[allTasksCount] = input;
            allTasksCount++;

            System.out.println("added: " + input);
            System.out.println(bar);
        }
    }
}
