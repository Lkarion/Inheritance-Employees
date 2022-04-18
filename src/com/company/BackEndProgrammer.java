package com.company;

public class BackEndProgrammer extends Programmer{
    public BackEndProgrammer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void doWork() {
        System.out.println("I am programmer " + getName() + " I write code and improve backend");
    }


}
