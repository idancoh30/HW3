import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;

public class ToDoList implements TaskIterable {
    private ArrayList<Task> tasksList;

    public ToDoList() {
        tasksList = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (tasksList.contains(task)) {
            throw new TaskAlreadyExistsException();
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

    public ArrayList<Task> getTasksList() {
        return tasksList;
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

    /*
    @Override
    public boolean equals(Object o) {
        ToDoList otherTasks = (ToDoList) o;
        int thisCounter = 0;
        int otherCounter = 0;
        for (Task t : this) {
            if (otherTasks.getTasksList().contains(t)) {
                thisCounter++;
            }

        }
        for (Task t : ((ToDoList) o).getTasksList()) {
            if (this.getTasksList().contains(t)) {
                otherCounter++;

            }
        }
        if (thisCounter + otherCounter == this.getSize() + ((ToDoList) o).getSize()) {
            return true;
        } else {
            return false;
        }
    }
*/

    @Override
    public boolean equals(Object o)
    {
        if(o == null || this.getSize() != ((ToDoList) o).getSize())
            return false;
        for(Task t : this)
        {
            if(((ToDoList) o).getTasksList().contains(t))
                continue;
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        return Objects.hash(tasksList);
    }
}
