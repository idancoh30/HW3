import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ToDoList implements TaskIterable {
    private ArrayList<Task> tasksList;

    public ToDoList() {
        tasksList = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (tasksList.contains(task)) {
            throw new TaskAlreadyExists();
        } else {
            tasksList.add(task);
        }
    }

    public int getSize() {
        return tasksList.size();
    }

    @Override
    public String toString() {
        return tasksList.toString();
    }

    public Task getTaskByIndex(int index) {
        return tasksList.get(index);
    }

    @Override
    public void setScanningDueDate(Date dueDate) {

    }

    @Override
    public Iterator<Task> iterator() {
        return new ToDoListIterator(this, 0);
    }


    @Override
    public ToDoList clone() {
        try {
            ToDoList copiedTasks = new ToDoList();
            for (Task t : this) {
                copiedTasks.addTask(t.clone());
            }
            return copiedTasks;
        } catch (Exception e) {
            return null;
        }

    }
}
