
public class Task {
    private static int counter = 0;
    private String title;
    private String description;

    private Status status;

    private int id;

    public enum Status {
        NEW,
        IN_PROGRESS,
        DONE
    }

    public Task(String title, String description) {
        id = counter++;
        this.title = title;
        this.description = description;
        this.status = Status.NEW;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
