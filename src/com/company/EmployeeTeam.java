package com.company;

import java.util.Arrays;

public class EmployeeTeam {
    private Manager manager;
    private Employee[] team;
    private int capacity = 2;
    private int currentIndex = 0;

    public EmployeeTeam(Manager manager) {
        this.manager = manager;
    }


    public EmployeeTeam(Manager manager, Employee[] team) {
        this.manager = manager;
        this.team = team;
    }

    //TODO реализовать метод find(Employee employee), который возвращает индекс этого сотрудника в массиве
    public int findEmployee(Employee employee){
        for (int i = 0; i < team.length; i++) {
            if (team[i].hashCode() == employee.hashCode())
                if (team[i].equals(employee))
                    return i;
        }
        return -1;
    }


    public void addEmployeeToTeam(Employee employee){
        if (team == null){
            team = new Employee[capacity];
            currentIndex = 0;
        }
        if (currentIndex >= capacity){
            capacity *= 2;
            team = Arrays.copyOf(team, capacity);
        }
        team[currentIndex++] = employee;
        System.out.println(Arrays.toString(team));
    }

    public void removeEmployeeFromTeam(int index){
        if (index > currentIndex || index < 0) {
            System.out.println("there is no such index in TEAM");
            return;
        }
        // if element order in teamArray does not matter:
        // team[index] = null;
        // if element order in teamArray DOES matter:
        Employee[] temp = Arrays.copyOfRange(team, index+1, team.length);
        for (int i = 0; i < temp.length; i++) {
            team[index+i] = temp[i];
        }
        team[--currentIndex] = null;

        /* team = (Employee[]) Stream.concat(Arrays.stream(Arrays.copyOfRange(team, 0, index)),
                Arrays.stream(Arrays.copyOfRange(team,index+1, team.length)))
                .toArray();*/

        System.out.println(Arrays.toString(team));
    }

    @Override
    public String toString() {
        return "EmployeeTeam{" +
                "team=" + Arrays.toString(team) +
                '}';
    }
}
