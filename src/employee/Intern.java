package employee;

import employee.Employee;

public class Intern extends Employee {
    public Intern(String name, double salary) {
        super(name, salary);
    }

    @Override
    public String toString() {
        return "Intern "+getName()+" salary " + getSalary();
    }

    @Override
    public void doWork() {

    }
}
