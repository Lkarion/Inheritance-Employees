package employee.programmer;

import employee.Employee;

public class QAEngineer extends Employee {


    public QAEngineer(String name, double salary) {
        super(name,salary);
    }

    @Override
    public  void doWork(){
        System.out.println("I am QA Engineer " + getName()+ " I check the program");
    }

    @Override
    public String toString() {
        return "QAEngineer "+getName()+" salary " + getSalary();
    }
}
