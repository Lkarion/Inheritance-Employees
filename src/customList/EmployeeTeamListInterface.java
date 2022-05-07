package customList;

import employee.Employee;

public interface EmployeeTeamListInterface {
    int size();

    Employee get(int index);

    void remove(String name);

    boolean removeAll(Employee[] arr);

    boolean addAll(Employee[] arr);

    int find(Employee employee);

    boolean add(Employee employee);

    void remove(int index);

    void remove(Employee employee);

    void sort();

}
