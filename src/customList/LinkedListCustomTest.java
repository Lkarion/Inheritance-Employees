package customList;

import employee.Employee;
import employee.programmer.Programmer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListCustomTest {
    Employee p1=new Programmer("Ivan",1000);
    Employee p2=new Programmer("Peter",1000);
    LinkedListCustom list;

    @BeforeEach
    void init(){
        list = new LinkedListCustom();
    }


    @Test
    void test_add(){
        list.add(p1);

        //assertEquals(null, list.head.prev);
        assertEquals(p1, list.head.info);
        //assertEquals(null, list.head.next);
        //assertEquals(null, list.tail.prev);
        //assertEquals(p1, list.tail.info);
        //assertEquals(null, list.tail.next);
    }
    @Test
    void test_add_TwoElements(){
        list.add(p1);
        list.add(p2);
        //assertEquals(null, list.head.prev);
        //assertEquals(p1, list.head.info);
        assertEquals(p2, list.head.next.info);
        //assertEquals(p1, list.tail.prev.info);
        //assertEquals(p2, list.tail.info);
        //assertEquals(null, list.tail.next);
    }
    @Test
    void test_add_checkSize(){
        list.add(p1);
        assertEquals(1, list.size());
    }
    @Test
    void test_add_TwoElements_checkSize(){
        list.add(p1);
        list.add(p2);
        assertEquals(2, list.size());
    }


    @Test
    void test_addAll_Normal_Boolean(){
        list.add(p1);
        Programmer p3 = new Programmer("Karl", 2500);
        Employee[] arr = {p2,p3};

        assertTrue(list.addAll(arr));
    }
    @Test
    void test_addAll_Normal_checkSize(){
        list.add(p1);
        Programmer p3 = new Programmer("Karl", 2500);
        Employee[] arr = {p2,p3};
        list.addAll(arr);
        assertEquals(3,list.size());
    }






    @Test
    void test_remove_ByEmployee_checkSize(){
        list.add(p1);
        list.remove(p1);
        assertEquals(0, list.size());
    }
    @Test
    void test_remove_ByEmployee_checkGet(){
        list.add(p1);
        list.add(p2);
        list.remove(p1);
        assertEquals(p2, list.get(0));
    }


    @Test
    void test_removeAll_Normal_checkGet(){
        list.add(p1);
        list.add(p2);
        Programmer p3 = new Programmer("Karl", 2500);
        list.add(p3);
        Employee[] arr = {p1,p2};
        list.removeAll(arr);
        assertEquals(p3, list.get(0));
    }
    @Test
    void test_removeAll_Normal_Boolean(){
        list.add(p1);
        list.add(p2);
        Programmer p3 = new Programmer("Karl", 2500);
        list.add(p3);
        Employee[] arr = {p1,p2};

        assertTrue(list.removeAll(arr));
    }




    @Test
    void test_remove_ByIndex_checkSize(){
        list.add(p1);
        list.remove(0);
        assertEquals(0, list.size());
    }
    @Test
    void test_remove_ByIndex_checkGet(){
        list.add(p1);
        list.add(p2);
        list.remove(0);
        assertEquals(p2, list.get(0));
    }
    @Test
    void test_remove_ByIndex_OutOfBound_checkGet(){
        list.remove(1);
        assertEquals(null, list.get(0));
    }




    @Test
    void test_remove_ByName_checkSize(){
        list.add(p1);
        list.remove("Ivan");
        assertEquals(0, list.size());
    }
    @Test
    void test_remove_ByName_checkGet(){
        list.add(p1);
        list.add(p2);
        list.remove("Ivan");
        assertEquals(p2, list.get(0));
    }


    @Test
    void test_get_NormalCase(){
        list.add(p1);
        assertEquals(p1, list.get(0));
    }

    @Test
    void test_get_OutOfBound(){
        list.add(p1);
        assertEquals(null, list.get(1));
    }



   @Test
    void test_find_OneElement_Normal(){
        list.add(p1);
        assertEquals(0, list.find(p1));
    }
    @Test
    void test_find_TwoElements_Normal(){
        list.add(p1);
        list.add(p2);
        assertEquals(1, list.find(p2));
    }
    @Test
    void test_find_NormalAfterRemove(){
        list.add(p1);
        list.add(p2);
        list.remove(p1);
        assertEquals(0, list.find(p2));
    }
    @Test
    void test_find_NotExistingEmployee(){
        list.add(p1);
        assertEquals(-1, list.find(p2));
    }
    @Test
    void test_find_NotExistingEmployeeAfterRemove(){
        list.add(p1);
        list.add(p2);
        list.remove(p2);
        assertEquals(-1, list.find(p2));
    }

}