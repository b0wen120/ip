import java.util.ArrayList;

public class Parser {
    public static boolean parse(String userInput, TaskList taskList, UI ui, Storage storage) throws KopiException {
        if (userInput.equals("bye")) {
            System.out.println("Bye bye, come next order!\n");
            ui.showLine();
            return true;
        }

        if (userInput.equals("list")) {
            System.out.println("Here are the tasks in your list:\n");

            for (int i = 0; i < taskList.getSize(); i++) System.out.println((i + 1) + ". " + taskList.getTask(i));
            ui.showLine();
            return false;
        }

        if (userInput.startsWith("mark ")) {
            int taskIndex = Integer.parseInt(userInput.split(" ")[1]) - 1;

            taskList.getTask(taskIndex).markAsDone();
            System.out.println("Nice lah this one finish liao:");
            System.out.println(" " + taskList.getTask(taskIndex));
            ui.showLine();

            storage.saveTasksToFile(taskList.getArrayList());
            return false;
        }

        if (userInput.startsWith("unmark ")) {
            int taskIndex = Integer.parseInt(userInput.split(" ")[1]) - 1;

            taskList.getTask(taskIndex).unmarkAsNotDone();
            System.out.println("Orh okay, so this one haven't finish:");
            System.out.println(" " + taskList.getTask(taskIndex));
            ui.showLine();

            storage.saveTasksToFile(taskList.getArrayList());
            return false;
        }

        if (userInput.startsWith("delete ")) {
            int taskIndex = Integer.parseInt(userInput.split(" ")[1]) - 1;

            Task deletedTask = taskList.removeTask(taskIndex);
            System.out.println("This one don't want? Okay I remove:");
            System.out.println(" " + deletedTask);
            System.out.println("Now got " + taskList.getSize() + " tasks only");
            ui.showLine();

            storage.saveTasksToFile(taskList.getArrayList());
            return false;
        }

        if (userInput.startsWith("find ")) {
            String keyword = userInput.substring(5).trim();

            ArrayList<Task> matchingTasks = taskList.findTasks(keyword);

            ui.showFoundTasks(matchingTasks);
            ui.showLine();

            return false;
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

            storage.saveTasksToFile(taskList.getArrayList());
            return false;
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

            storage.saveTasksToFile(taskList.getArrayList());
            return false;
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

            storage.saveTasksToFile(taskList.getArrayList());
            return false;
        }

        //ui.showLine();
        throw new KopiException("Brotha what does that mean sia?!\n");
    }
}
