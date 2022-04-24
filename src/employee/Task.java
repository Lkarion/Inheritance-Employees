package employee;

public class Task {
    int id;
    TaskStatus status;
    String description;

    public Task(int id, TaskStatus status, String description) {
        this.id = id;
        this.status = status;
        this.description = description;
    }
}