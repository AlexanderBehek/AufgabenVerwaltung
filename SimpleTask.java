public class SimpleTask implements Task {
    private static int counter = 0;
    private final int id;
    private String description;
    private String priority;
    private String status;

    public SimpleTask(String description, String priority) {
        this.id = ++counter;
        this.description = description;
        this.priority = priority;
        this.status = "OPEN";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getPriority() {
        return priority;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + description + " (Priority: " + priority + ", Status: " + status + ")";
    }
}