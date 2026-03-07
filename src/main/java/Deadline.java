/**
 * Represents a task with a deadline.
 */

public class Deadline extends Task {

    protected String by;

    /**
     * Creates a new Deadline task.
     *
     * @param description The description of the deadline.
     * @param by The date and time the task needs to be completed by.
     */

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    /**
     * Formats the Deadline for saving to the hard drive.
     *
     * @return returns a formatted string with date and time.
     */

    @Override
    public String toFileFormat() {
        return "D" + super.toFileFormat() + " | " + by;
    }
}
