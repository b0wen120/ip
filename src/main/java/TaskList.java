import java.util.ArrayList;

/**
 * Manages the task list and operations such as finding tasks, getting a task index and list, as well as adding and deleting
 */

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the current Kopi List.
     * @param task The user input of a new task and its description to be added.
     */

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Removes a task to the current Kopi List.
     * @param index The user input of a task index in the list that is to be deleted.
     */

    public Task removeTask(int index) {
        return this.tasks.remove(index);
    }

    /**
     * Returns and outputs the task based on the index of the current Kopi List.
     */

    public Task getTask(int index) {
        return this.tasks.get(index);
    }

    /**
     * Finds the size of the current Kopi List.
     * Returns the array size of the list.
     */

    public int getSize() {
        return this.tasks.size();
    }

    /**
     * Returns the array stored for operations such as saving changes made to the list.
     */

    public ArrayList<Task> getArrayList() {
        return this.tasks;
    }

    /**
     * Searches for tasks that contain the specified keyword in their description.
     *
     * @param keyword The word to search for in the task descriptions.
     * @return An ArrayList containing all matching tasks.
     */

    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (int i = 0; i < this.tasks.size(); i++) {
            Task t = this.tasks.get(i);
            if (t.description.contains(keyword)) {
                matchingTasks.add(t);
            }
        }
        return matchingTasks;
    }
}
