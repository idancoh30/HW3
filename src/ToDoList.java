import java.util.*;

public class ToDoList implements TaskIterable {
    private ArrayList<Task> tasksList;
    private Date maxDate;

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
        String output = "[";
        for(int i = 0; i < this.getSize(); i++){
            if (i != this.getSize()-1)
                output += "("+this.getTaskByIndex(i).toString()+"), ";
            else
                output += "("+this.getTaskByIndex(i).toString()+")";
        }
        output += "]";
        return output;
    }

    public Task getTaskByIndex(int index) {
        return tasksList.get(index);
    }

    @Override
    public void setScanningDueDate(Date dueDate) {
        if(dueDate == null)
            this.maxDate = null;
        else {
            this.maxDate = dueDate;
        }
    }

    public void sortList()
    {
        Comparator<Task> dueDateComparator = Comparator.comparing(Task::getDueDate);
        Comparator<Task> descriptionComprator = Comparator.comparing(Task::getDescription);
        Comparator<Task> comprator = dueDateComparator.thenComparing(descriptionComprator);
        Collections.sort(this.getTasksList(), comprator);
    }

    public ArrayList<Task> getTasksList() {
        return tasksList;
    }

    @Override
    public Iterator<Task> iterator() {
        return new ToDoListIterator(this, 0,maxDate);
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
        int hash = 0;
        for(Task t : this)
        {
            hash += t.hashCode();
        }
        return hash;
    }
}
