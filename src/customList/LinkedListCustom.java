package customList;

import employee.Employee;
import employee.programmer.Programmer;


public class LinkedListCustom implements EmployeeTeamListInterface{
    static int size;

    class Node{
        Node prev;
        Employee info;
        Node next;

        public Node(Node prev, Employee info, Node next) {
            this.prev = prev;
            this.info = info;
            this.next = next;
        }

        public Node(Employee info) {
            this.info = info;
        }
    }

    Node head;
    Node tail;

    public LinkedListCustom() {
        head = null;
        tail = head;
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public Employee get(int index) {
        if (index < 0 || index >= size){
            System.out.println("Index is out of bound");
            return null;
        }
        int i = 0;
        Node tmp = head;
        while (i < index){
            tmp = tmp.next;
            i++;
        }
        return tmp.info;
    }

    @Override
    public void remove(String name) {
        for (Node tmp = head; tmp != null ; tmp = tmp.next) {
            if (tmp.info.getName().equals(name))
                remove(tmp.info);
        }
    }

    @Override
    public int find(Employee employee) {
        int index = 0;
        for (Node tmp = head; tmp != null ; tmp = tmp.next) {
            if (tmp.info.equals(employee)) return index;
            index++;
        }
        return -1;
    }

   @Override
    public boolean removeAll(Employee[] arr) {
        if (arr == null) return false;
        for (Employee e: arr) {
            if (e == null) return false;
            remove(e);
        }
        return true;
    }

    @Override
    public boolean addAll(Employee[] arr) {
        if (arr == null) return false;
        for (Employee e: arr) {
            if (e == null) return false;
            add(e);
        }
        return true;
    }

    public void addToHead(Employee employee){
        Node tmp = head;
        Node newHead = new Node(null, employee, tmp);
        head = newHead;
        if (tmp == null){
            tail = newHead;
            head = tail;
        }
        else{
            tmp.prev = newHead;
            head = newHead;
        }
        size++;
    }

    public void addToTail(Employee employee){
        Node tmp = tail;
        Node newTail = new Node(tmp, employee, null);
        if (tmp == null){
            head = newTail;
            tail = head;
        }
        else{
            tmp.next = newTail;
            tail = newTail;
        }
        size++;
    }


    @Override
    public boolean add(Employee employee) {
        if (employee == null) return false;
        addToTail(employee);
        return true;
    }

    @Override
    public void remove(int index) {
        remove(get(index));
    }

    @Override
    public void remove(Employee employee) {
        for (Node tmp = head; tmp != null; tmp = tmp.next) {
            if (employee.equals(tmp.info)) {
                if (tmp.prev == null) {
                    head = tmp.next;
                }else {
                    tmp.prev.next = tmp.next;
                }
                if (tmp.next == null){
                    tail = tmp.prev;
                }else{
                    tmp.next.prev = tmp.prev;
                }
                size--;
            }
        }
    }

    @Override
    public void sort() {

    }


    public static void main(String[] args) {
        Employee p1=new Programmer("Ivan",1000);
        Employee p2=new Programmer("Peter",1000);
        LinkedListCustom list = new LinkedListCustom();
        list.add(p1);
        list.add(p2);
        System.out.println(list.head.prev);
        System.out.println(list.head.info);
        System.out.println(list.head.next.info);
        System.out.println(list.tail.prev.info);
        System.out.println(list.tail.info);
        System.out.println(list.tail.next);

        list.remove(p1);
        System.out.println(list.head.prev);
        System.out.println(list.head.info);
        System.out.println(list.head.next);
        System.out.println(list.tail.prev);
        System.out.println(list.tail.info);
        System.out.println(list.tail.next);
    }
}
