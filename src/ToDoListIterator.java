import java.util.Date;
import java.util.Iterator;

public class ToDoListIterator implements Iterator<Task> {
    private ToDoList tasksList;
    private int index;
    private Date maxDate;

    public ToDoListIterator(ToDoList tL, int index, Date maxDueDate) {
        this.tasksList = tL;
        tasksList.sortList();
        this.index = index;
        this.maxDate = maxDueDate;
    }

    @Override
    public boolean hasNext() {
        if (this.maxDate == null) {
            return (this.index < tasksList.getSize() && this.tasksList.getTaskByIndex(index) != null);
        } else {
            return (this.index < tasksList.getSize() && this.tasksList.getTaskByIndex(index).getDueDate().compareTo(maxDate) <= 0);
        }
    }

    @Override
    public Task next() {
        Task task = this.tasksList.getTaskByIndex(index);
        index++;
        return task;
    }
}
