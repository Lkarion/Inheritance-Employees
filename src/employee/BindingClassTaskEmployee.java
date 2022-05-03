package employee;

import java.util.Collections;
import java.util.List;

public class BindingClassTaskEmployee {
    // Implement the ability to add a task to an Employee (2022-04-20 #14 №6) in the way we discussed in class.
    private Task task;
    private Employee employee;
    private static List<BindingClassTaskEmployee> table;

    public BindingClassTaskEmployee(Task task, Employee employee) {
        this.task = task;
        this.employee = employee;
        table.add(this);
    }

    public Task getTask() {
        return task;
    }


    public Employee getEmployee() {
        return employee;
    }

    public static List<BindingClassTaskEmployee> getTable() {
        return Collections.unmodifiableList(table);
    }
}
