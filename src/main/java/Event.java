/**
 * Represents a task that starts at a specific time and ends at a specific time.
 */

public class Event extends Task {

    protected String from;
    protected String to;

    /**
     * Creates a new Event task.
     *
     * @param description The description of the event.
     * @param from The starting date and time.
     * @param to The ending date and time.
     */

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    /**
     * A format for saving to the hard drive.
     *
     * @return returns a formatted string with time and date.
     */

    @Override
    public String toFileFormat() {
        return "E" + super.toFileFormat() + " | " + from + " | " + to;
    }
}
