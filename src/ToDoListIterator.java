import java.util.Iterator;

public class ToDoListIterator implements Iterator<Task> {
    private ToDoList tasksList;
    private int index;

    public ToDoListIterator(ToDoList tasksList, int index) {
        this.tasksList = tasksList;
        this.index = index;
    }

    @Override
    public boolean hasNext() {
        return (this.index < tasksList.getSize() && this.tasksList.getTaskByIndex(index)!=null);
    }

    @Override
    public Task next() {
        Task task = this.tasksList.getTaskByIndex(index);
        index++;
        return task;
    }
}
