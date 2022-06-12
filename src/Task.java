import java.util.Date;

public class Task {
    private String description;
    private Date dueDate;

    public Task(String description, Date dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }

    @Override
    public String toString()
    {
        String output = "";
        output += "("+description+",";
        if(dueDate.getDay() < 10)
        {
            output += "0"+dueDate.getDay()+".";
        }
        else{
            output += dueDate.getDay()+".";
        }
        if (dueDate.getMonth() < 10){
            output+= "0"+dueDate.getMonth()+".";
        }
        return output;
    }



}
