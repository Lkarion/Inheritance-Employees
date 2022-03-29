package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Manager extends Employee{
    private double bonus;
    private Employee[] team;

    // private List<Employee> team1 = new LinkedList<>();

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public void addEmployeeToTeam(Employee employee){
        Employee[] arr = new Employee[team==null ? 1 : team.length+1];

        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = team[i];
        }
        arr[arr.length - 1] = employee;
        team = arr;
        System.out.println(Arrays.toString(team));
    }

    /*public void addEmployeeToTeam1(Employee employee){
        team1.add(employee);
        System.out.println(team1);
    }
*/
    @Override
    public void getPaid(){
        System.out.println("I got the paid " + (getSalary()+getBonus()));
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
