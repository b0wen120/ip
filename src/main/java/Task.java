/**
 * Class for a task in the task list and its corresponding description.
 * Base class for Todo, Deadline and Event classes.
 */


public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a new Task with the given description.
     * Tasks are uncompleted by default.
     *
     * @param description The text description of the task.
     */

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the status icon of the task.
     * "X" means the task is done, a blank space means it is not.
     *
     * @return A string representing the completion status.
     */

    protected String getStatusIcon() {
        return isDone ? "X" : " "; // mark done task with X
    }

    /**
     * markAsDone represents command that "marks" task as done
     * unmarkAsNotDone represents command that "unmarks" the task as not done
     */

    public void markAsDone() {
        this.isDone = true;
    }

    public void unmarkAsNotDone() {
        this.isDone = false;
    }

    /**
     * returns status and task description
     */

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * A format for saving to the hard drive.
     *
     * @return returns a formatted string, varied based on task and description.
     */

    public String toFileFormat() { return " | " + (isDone ? "1" : "0") + " | " + description; }
}
