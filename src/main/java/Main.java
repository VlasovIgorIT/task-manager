
public class Main {
    public static void main(String[] args) {
        Manager Manager = new Manager();
        Task task1 = new Task("Задача 1", "Описание задачи 1");
        Task task2 = new Task("Задача 2", "Описание задачи 2");
        Epic epic1 = new Epic("Эпик 1", "Описание эпика 1");
        Subtask subtask1 = new Subtask("Подзадача 1", "Описание подзадачи 1", epic1);
        Subtask subtask2 = new Subtask("Подзадача 2", "Описание подзадачи 2", epic1);
        Epic epic2 = new Epic("Эпик 2", "Описание эпика 2");
        Subtask subtask3 = new Subtask("Подзадача 3", "Описание подзадачи 3", epic2);
        task1.setStatus(Task.Status.IN_PROGRESS);
        subtask1.setStatus(Task.Status.DONE);
        subtask2.setStatus(Task.Status.NEW);
        epic1.updateEpicStatus();
        Manager.addTask(task1);
        Manager.addTask(task2);
        Manager.addEpic(epic1);
        Manager.addSubtask(subtask1);
        Manager.addSubtask(subtask2);
        Manager.addEpic(epic2);
        Manager.addSubtask(subtask3);
        System.out.println("Выводим списки задач");
        Manager.printTasks();
        Manager.printSubtasks();
        Manager.printEpics();
        Manager.removeTask(task1.getId());
        Manager.removeEpic(epic2.getId());
        System.out.println("После удаления:");
        Manager.printTasks();
        Manager.printSubtasks();
        Manager.printEpics();
    }
}
