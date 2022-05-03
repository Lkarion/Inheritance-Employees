package employee;

import java.util.List;
import java.util.Objects;

public abstract class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, double salary, List<Task> tasks) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, double salary, Task task) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void getPaid(){
        System.out.println("I got the paid " + salary);
    }

    public abstract void doWork();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }


    @Override
    public int compareTo(Employee employee) {
        return this.getName().compareTo(employee.getName());
    }

    //6. In the Employee you need to implement new feature assign a Task(id, status, description) to each Employee.
    // Think how you can implement it. NOTE each employee can solve more than one task, and each task can be solved
    // by more than one employee.

    void assignTask(Task task){
        new BindingClassTaskEmployee(task,this);
    }
}
