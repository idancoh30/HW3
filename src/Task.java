import java.util.Date;
import java.util.Objects;

public class Task implements Cloneable {
    private String description;
    private Date dueDate;

    public Task(String description, Date dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        String output = "";
        output += "(" + description + ",";
        if (dueDate.getDay() < 10) {
            output += "0" + dueDate.getDay() + ".";
        } else {
            output += dueDate.getDay() + ".";
        }
        if (dueDate.getMonth() < 10) {
            output += "0" + dueDate.getMonth() + ".";
        } else {
            output += dueDate.getMonth() + ".";
        }
        output += (dueDate.getYear() + 1900) + ")";
        return output;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    @Override
    public boolean equals(Object task) {
        return this.toString().equals(task.toString());

    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public Task clone() {
        try {
            Task copiedTask = (Task) super.clone();
            copiedTask.dueDate = (Date) dueDate.clone();
            return copiedTask;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
