public interface Task {
    int getId();
    String getDescription();
    String getPriority();
    String getStatus();

    void setDescription(String description);
    void setPriority(String priority);
    void setStatus(String status);
}