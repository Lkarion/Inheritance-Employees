package customList;

import employee.Employee;
import employee.EmployeeTeam;
import employee.Manager;
import employee.programmer.Programmer;
import employee.programmer.QAEngineer;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayListCustom implements EmployeeTeamListInterface {


    private Manager manager;
    private Employee[] team;
    private int capacity = 2;
    private int currentIndex = 0;

    public ArrayListCustom() {
    }

    public ArrayListCustom(Manager manager) {
        this.manager = manager;
    }

    public Employee[] getTeam() {
        return team;
    }

    public ArrayListCustom(Manager manager, Employee[] team) {
        this.manager = manager;
        this.team = team;
        currentIndex = team.length;
    }


    @Override
    public int size() {
        return currentIndex;
    }

    @Override
    public Employee get(int index) {
        if (index > currentIndex || index < 0) {
            throw new NoSuchElementException("there is no such index in TEAM");
        }
        return team[index];
    }

    @Override
    public void remove(String name) {
        if (team != null && name.length() > 0)
            for (int i = 0; i < currentIndex; i++) {
                if (team[i].getName().equalsIgnoreCase(name)) {
                    remove(i);
                    return; // предполагается, что в массиве нет повторяющихся сотрудников
                }
            }
    }

    @Override
    public boolean removeAll(Employee[] arr) {
        if (arr == null) return false;
        int size = size();
        for (Employee e : arr) {
            if (e != null) {
                int index = find(e);
                if (index != -1) {
                    remove(index);
                }
            }
        }
        return size != size();
    }

    @Override
    public boolean addAll(Employee[] arr) {
        if (arr == null) return false;
        int size = size();
        int newCapacity = currentIndex + arr.length + 10;
        if (newCapacity < capacity) {
            increaseToSize(newCapacity);
        }
        for (Employee e : arr) {
            if (find(e) == -1) // if there was no such employee in team yet
                add(e);
        }
        return size != size();
    }

    /*@Override
    public ArrayListCustom getSubTeam(String name) {
        EmployeeTeam subTeam = new EmployeeTeam();
        if (name == null) return subTeam;
        for (int i = 0; i < currentIndex; i++) {
            if (team[i].getName().equalsIgnoreCase(name)) {
                subTeam.addEmployeeToTeam(team[i]);
            }
        }
        return subTeam;
    }*/

    @Override
    public int find(Employee employee) {
        if (employee != null)
            for (int i = 0; i < currentIndex; i++) {
                if (team[i] != null &&
                        team[i].hashCode() == employee.hashCode() &&
                        team[i].equals(employee))
                    return i;
            }
        return -1;
    }

    @Override
    public boolean add(Employee employee) {
        if (employee == null) return false;
        if (team == null) {
            team = new Employee[capacity];
            currentIndex = 0;
        }
        if (currentIndex >= capacity) {
            capacity *= 2;
            team = Arrays.copyOf(team, capacity);
        }
        team[currentIndex++] = employee;
        return true;
        //System.out.println(Arrays.toString(team));
    }

    @Override
    public void remove(int index) {
        if (index > currentIndex || index < 0) {
            System.out.println("there is no such index in TEAM");
            return;
        }
        Employee[] temp = Arrays.copyOfRange(team, index + 1, team.length);
        for (int i = 0; i < temp.length; i++) {
            team[index + i] = temp[i];
        }
        team[--currentIndex] = null;

        System.out.println(Arrays.toString(team));
    }

    @Override
    public void remove(Employee employee) {
        int index = find(employee);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public void sort() {
        trimToSize();
        Arrays.sort(team);
    }

    public void trimToSize() {
        if (capacity > currentIndex) {
            capacity = currentIndex;
            team = Arrays.copyOf(team, capacity);
        }
    }



    /*public boolean removeAll(EmployeeTeam arr) {
        if (arr != null) return false;
        int size = size();
        for (int i = 0; i < arr.size(); i++) {
            Employee e = get(i);
            if (e != null) {
                remove(e);
            }
        }
        return size != size();
    }
*/

    private void increaseToSize(int newCapacity) {
        if (newCapacity < capacity) {
            team = Arrays.copyOf(team, newCapacity);
            capacity = newCapacity;
        }
    }
/*

    public boolean addAll(EmployeeTeam arr) {
        if (arr == null) return false;
        return addAll(arr.getTeam());
    }
*/



    /*//8. Implement the method that returns the EmployeeTeam with all programmers or all QA Engineers from this team
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
    }*/


    @Override
    public String toString() {
        return "ArrayListCustom{" +
                "team=" + Arrays.toString(team) +
                '}';
    }


}
