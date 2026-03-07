/**
 * Represents a basic task without any specific date or time attached to it.
 */

public class Todo extends Task {

    /**
     * Creates a new Todo task.
     *
     * @param description The description of the todo task.
     */

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Formats the Todo for saving.
     *
     * @return returns a formatted string.
     */

    @Override
    public String toFileFormat() {
        return "T" + super.toFileFormat();
    }
}
