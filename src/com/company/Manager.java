package com.company;

import java.util.Objects;

public class Manager extends Employee{
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public void getPaid(){
        System.out.println("I got the paid " + (getSalary()+getBonus()));
    }

    @Override
    public void doWork() {
        System.out.println("I am manager " + getName());
    }

    @Override
    public String toString() {
        return "Manager " +getName()+" salary " + getSalary()+
                " bonus=" + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
}
