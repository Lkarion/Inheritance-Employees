package employee.programmer;

import employee.programmer.Programmer;

public class FullStack extends Programmer {
    public FullStack(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void doWork() {
        System.out.println("I am programmer " + getName());
    }
}
