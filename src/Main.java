import java.util.Calendar;
import java.util.Date;

class MyCloneable implements Cloneable {
    private int num;

    public MyCloneable(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "A: " + num;
    }

    @Override
    public MyCloneable clone() {
        try {
            return (MyCloneable) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        //testPartA();
        //testPartB();
        ToDoList l1 = new ToDoList();
        Task t1 = new Task("Software Engineering HW0", new Date(2022 - 1900, Calendar.APRIL, 13));
        Task t2 = new Task("Software Engineering HW1", new Date(2022 - 1900, Calendar.MAY, 10));
        Task t3 = new Task("Software Engineering HW2", new Date(2022 - 1900, Calendar.MAY, 25));
        Task t4 = new Task("Software Engineering HW3", new Date(2022 - 1900, Calendar.JUNE, 16));

        l1.addTask(t1);
        l1.addTask(t4);
        l1.addTask(t3);
        l1.addTask(t2);

        for(Task t : l1){
            System.out.println(t);
        }

        Task cloned = t1.clone();
        System.out.println(cloned);
        ToDoList copiedtdl = l1.clone();
        System.out.println(copiedtdl);




    }


    /**
     * Tests for part B.
     *
    private static void testPartB() {
        ToDoList l1 = new ToDoList();
        for (Task t : l1) {
            System.out.println("You should not reach here!");
        }

        Task t1 = new Task("Software Engineering HW0", new Date(2022 - 1900, Calendar.APRIL, 13));
        Task t2 = new Task("Software Engineering HW1", new Date(2022 - 1900, Calendar.MAY, 10));
        Task t3 = new Task("Software Engineering HW2", new Date(2022 - 1900, Calendar.MAY, 25));
        Task t4 = new Task("Software Engineering HW3", new Date(2022 - 1900, Calendar.JUNE, 16));

        l1.addTask(t1);
        l1.addTask(t4);
        l1.addTask(t3);
        l1.addTask(t2);

        System.out.println("l1: " + l1);

        ToDoList l2 = l1.clone();
        System.out.println("l1: " + l1);
        System.out.println("l2: " + l2);

        System.out.println("Is l1 == l2? " + (l1 == l2));
        System.out.println("Are lists l1 and l2 equal? " + l1.equals(l2));
        System.out.println("Are lists l2 and l1 equal? " + l2.equals(l1));
        System.out.println("Is l1.equals(null)? " + l1.equals(null));

        t1.setDueDate(new Date(2022 - 1900, Calendar.APRIL, 15));

        System.out.println("l1: " + l1);
        System.out.println("l2: " + l2);

        System.out.println();
        System.out.println("Are lists l1 and l2 equal? " + l1.equals(l2));
        System.out.println("Are lists l2 and l1 equal? " + l2.equals(l1));


        try {
            l1.addTask(new Task("Software Engineering HW0", new Date(2021 - 1900, Calendar.NOVEMBER, 24)));
        } catch (TaskAlreadyExistsException e) {
            System.out.println("Cannot add the task!");
        }
        try {
            l1.addTask(new Task("Software Engineering HW0", new Date(2018 - 1900, Calendar.MARCH, 21)));
        } catch (TaskAlreadyExistsException e) {
            System.out.println("Cannot add the task!");
        }
        Task clonedT1 = t1.clone();
        try {
            l1.addTask(clonedT1);
        } catch (TaskAlreadyExistsException e) {
            System.out.println("Cannot add the task!");
        }

        System.out.println("t1: " + t1);
        System.out.println("clonedT1: " + clonedT1);
        System.out.println("Are lists 11 and clonedT1 equal? " + t1.equals(clonedT1));
        System.out.println("Are lists clonedT1 and t1 equal? " + clonedT1.equals(t1));
        System.out.println("Is t1 == clonedT1? " + (t1 == clonedT1));
        System.out.println("Is t1.equals(null)? " + t1.equals(null));
        System.out.println();


        Date[] dates = {null, new Date(2022 - 1900, Calendar.MAY, 25), t2.getDueDate(), new Date(2017 - 1900, Calendar.MAY, 25), new Date(2023 - 1900, Calendar.MAY, 25)};

        checkScans(l1, dates);

        ToDoList l3 = new ToDoList();

        System.out.println("Are lists l1 and l3 equal? " + l1.equals(l3));
        l3.addTask(t2);
        System.out.println("l3: " + l3);
        System.out.println("Are lists l1 and l3 equal? " + l1.equals(l3));

        l3.addTask(t4);
        System.out.println("l3: " + l3);
        System.out.println("Are lists l1 and l3 equal? " + l1.equals(l3));

        l3.addTask(t1);
        System.out.println("l3: " + l3);
        System.out.println("Are lists l1 and l3 equal? " + l1.equals(l3));

        l3.addTask(t3);
        System.out.println("l3: " + l3);
        System.out.println("Are lists l1 and l3 equal? " + l1.equals(l3));

        checkScans(l3, dates);

        Task t5 = new Task("Calculus 2 HW4", new Date(2022 - 1900, Calendar.MAY, 25));
        l3.addTask(t5);

        System.out.println("l3: " + l3);
        checkScans(l3, dates);

        System.out.println("\nTesting of part B is over!");
    }*/

    /**
     * Checks all of the scan types for a given ToDoList using different dates.
     *
    private static void checkScans(ToDoList tdl, Date[] dates) {
        System.out.println("Starts scanning...");
        for (Task t : tdl) {
            System.out.println(t);
            System.out.println("-----------------------------------");
        }

        System.out.println("After initial scanning\n");

        int i = 1;
        for (Date date : dates) {
            System.out.println("Starting scan number " + i);
            tdl.setScanningDueDate(date);
            for (Task t : tdl) {
                System.out.println(t);
                System.out.println("-----------------------------------");
            }
            System.out.println("After scan number " + i++ + "\n");
        }

        System.out.println("Done scanning");
    }*/
}
