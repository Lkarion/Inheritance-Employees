package com.company;

public class QAEngineer extends Employee{


    public QAEngineer(String name, double salary) {
        super(name,salary);
    }

    public  void doWork(){
        System.out.println("I am QA Engineer " + getName()+ " I check the program");
    }

    @Override
    public String toString() {
        return "QAEngineer "+getName()+" salary " + getSalary();
    }
}
