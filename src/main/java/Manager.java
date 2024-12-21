import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager {
    private HashMap<Integer,Task> taskHashMap;
    private HashMap<Integer,Subtask> subtaskHashMap;
    private HashMap<Integer,Epic> epicHashMap;

    public Manager() {
        taskHashMap = new HashMap<>();
        subtaskHashMap = new HashMap<>();
        epicHashMap = new HashMap<>();
    }

    public void addTask(Task task) {
        taskHashMap.put(task.getId(), task);
    }

    public void addEpic(Epic epic) {
        epicHashMap.put(epic.getId(), epic);
    }

    public void addSubtask(Subtask subtask) {
        subtaskHashMap.put(subtask.getId(), subtask);
        Epic epic = epicHashMap.get(subtask.getEpic().getId());
        if (epic != null) {
            epic.addSubtask(subtask);
            epic.updateEpicStatus();
        }
    }
    public List<Task> getAllTasks() {
        return new ArrayList<>(taskHashMap.values());
    }

    public List<Epic> getAllEpics() {
        return new ArrayList<>(epicHashMap.values());
    }

    public List<Subtask> getAllSubtasks() {
        return new ArrayList<>(subtaskHashMap.values());
    }

    public void removeTask(int id) {
        taskHashMap.remove(id);
    }

    public void removeSubtask(Subtask subtask) {
        subtaskHashMap.remove(subtask.getId());
        if (subtask != null) {
            Epic epic = subtask.getEpic();
            if (epic != null) {
                epic.deleteSubtask(subtask);
                epic.updateEpicStatus();
            }
        }
    }

    public void removeEpic(int id) {
        Epic epic = epicHashMap.remove(id);
        if (epic != null) {
            for (Subtask subtask : epic.getSubtasks()) {
                subtask.deleteEpic();
                subtaskHashMap.remove(subtask.getId());
                taskHashMap.put(subtask.getId(),subtask);
            }
        }
    }
    public void updateTask(Task task) {
        taskHashMap.put(task.getId(), task);
    }

    public void updateEpic(Epic epic) {
        epicHashMap.put(epic.getId(), epic);
        epic.updateEpicStatus();
    }

    public void updateSubtask(Subtask subtask) {
        subtaskHashMap.put(subtask.getId(), subtask);
        Epic epic = epicHashMap.get(subtask.getEpic().getId());
        if (epic != null) {
            epic.updateEpicStatus();
        }
    }

    public void printTasks() {
        System.out.println("Tasks:");
        taskHashMap.values().forEach(System.out::println);
    }

    public void printSubtasks() {
        System.out.println("Subtasks:");
        subtaskHashMap.values().forEach(System.out::println);
    }

    public void printEpics() {
        System.out.println("Epics:");
        epicHashMap.values().forEach(System.out::println);
    }


}
