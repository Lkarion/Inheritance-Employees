package employee;

import employee.programmer.Programmer;
import employee.programmer.QAEngineer;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class EmployeeTeam {
    private Manager manager;
    private Employee[] team;
    private int capacity = 2;
    private int currentIndex = 0;

    public EmployeeTeam() {
    }

    public EmployeeTeam(Manager manager) {
        this.manager = manager;
    }

    public Employee[] getTeam() {
        return team;
    }

    public EmployeeTeam(Manager manager, Employee[] team) {
        this.manager = manager;
        this.team = team;
    }

    //1. The int size() method that returns how many Employees in the team
    public int size() {
        return currentIndex;
    }

    //2. The Employee get(int index) method that return the Employee with the given index
    public Employee get(int index) {
        if (index > currentIndex || index < 0) {
            throw new NoSuchElementException("there is no such index in TEAM");
        }
        return team[index];
    }

    //3. The remove (String name) method that remove Employees by the name
    public void removeEmployeeFromTeam(String name) {
        if (team != null && name.length() > 0)
            for (int i = 0; i < currentIndex; i++) {
                if (team[i].getName().equalsIgnoreCase(name)) {
                    removeEmployeeFromTeam(i);
                    return; // предполагается, что в массиве нет повторяющихся сотрудников
                }
            }
    }

    //4. Removal of several employees from the team at once (removeAll) It should be possible to use an array of
    // Employee or EmployeeTeam to set the list of removed workers
    public void removeAll(Employee[] arr) {
        if (arr != null)
            for (Employee e : arr) {
                if (e != null) {
                    int index = findEmployee(e);
                    if (index != -1) {
                        removeEmployeeFromTeam(index);
                    }
                }
            }
    }

    public boolean removeAll(EmployeeTeam arr) {
        if (arr != null) return false;
        int size = size();
        for (int i = 0; i < arr.size(); i++) {
            Employee e = get(i);
            if (e != null) {
                removeEmployeeFromTeam(e);
            }
        }
        return size != size();
    }

    //5. Adding several employees to a team at a time (addAll). As previous It should be possible to set the list
    // by array or by EmployeeTeam
    public boolean addAll(Employee[] arr) {
        int size = size();
        if (arr == null) return false;
        int newCapacity = currentIndex + arr.length + 10;
        if (newCapacity < capacity) {
            increaseToSize(newCapacity);
        }
        for (Employee e : arr) {
            if (findEmployee(e) == -1) // if there was no such employee in team yet
                addEmployeeToTeam(e);
        }
        return size != size();
    }

    private void increaseToSize(int newCapacity) {
        if (newCapacity < capacity) {
            team = Arrays.copyOf(team, newCapacity);
            capacity = newCapacity;
        }
    }

    public boolean addAll(EmployeeTeam arr) {
        if (arr == null) return false;
        return addAll(arr.getTeam());
    }


    //6. Since our EmployeeTeam allows null cells at the end of the array, it could takes up extra memory.
    // Implement the trimToSize() method that trims the capacity of the array to be the real current size.
    public void trimToSize() {
        if (capacity > currentIndex) {
            capacity = currentIndex;
            team = Arrays.copyOf(team, capacity);
        }
    }

    //7. The method that returns the new EmployeeTeam with all employees with the given name from this team
    public EmployeeTeam getSubTeam(String name) {
        EmployeeTeam subTeam = new EmployeeTeam();
        if (name == null) return subTeam;
        for (int i = 0; i < currentIndex; i++) {
            if (team[i].getName().equalsIgnoreCase(name)) {
                subTeam.addEmployeeToTeam(team[i]);
            }
        }
        return subTeam;
    }

    //8. Implement the method that returns the EmployeeTeam with all programmers or all QA Engineers from this team
    public Employee[] getSubTeamProgrammersQAs() {
        Employee[] subTeam = new Employee[1];
        int subTeamCurrentIndex = 0;
        for (Employee e : team) {
            if (e instanceof Programmer || e instanceof QAEngineer) {
                subTeam = Arrays.copyOf(subTeam, subTeamCurrentIndex + 1);
                subTeam[subTeamCurrentIndex++] = e;
            }
        }
        return subTeam;
    }

    public int findEmployee(Employee employee) {
        if (employee != null)
            for (int i = 0; i < currentIndex; i++) {
                if (team[i] != null &&
                        team[i].hashCode() == employee.hashCode() &&
                        team[i].equals(employee))
                    return i;
            }
        return -1;
    }


    public void addEmployeeToTeam(Employee employee) {
        if (team == null) {
            team = new Employee[capacity];
            currentIndex = 0;
        }
        if (currentIndex >= capacity) {
            capacity *= 2;
            team = Arrays.copyOf(team, capacity);
        }
        team[currentIndex++] = employee;
        System.out.println(Arrays.toString(team));
    }

    public void removeEmployeeFromTeam(int index) {
        if (index > currentIndex || index < 0) {
            System.out.println("there is no such index in TEAM");
            return;
        }
        // if element order in teamArray does not matter:
        // team[index] = null;
        // if element order in teamArray DOES matter:
        // team = ArrayUtils.remove(team,index);
        // System.arraycopy(team, index+1, team, index, team.length-index-1);
        Employee[] temp = Arrays.copyOfRange(team, index + 1, team.length);
        for (int i = 0; i < temp.length; i++) {
            team[index + i] = temp[i];
        }
        team[--currentIndex] = null;

        /* team = (Employee[]) Stream.concat(Arrays.stream(Arrays.copyOfRange(team, 0, index)),
                Arrays.stream(Arrays.copyOfRange(team,index+1, team.length)))
                .toArray();*/
        System.out.println(Arrays.toString(team));
    }

    public void removeEmployeeFromTeam(Employee employee) {
        int index = findEmployee(employee);
        if (index != -1) {
            removeEmployeeFromTeam(index);
        }
    }


    @Override
    public String toString() {
        return "EmployeeTeam{" +
                "team=" + Arrays.toString(team) +
                '}';
    }
}
