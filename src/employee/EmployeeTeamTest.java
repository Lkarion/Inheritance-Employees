package employee;

import employee.programmer.Programmer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class EmployeeTeamTest {
    EmployeeTeam team;

    @BeforeEach
    public void init(){
    }

    @Test
    void removeEmployeeFromTeamName() {
            int size = team.size();
            team.addEmployeeToTeam(new Programmer("Luke",1500));
            team.removeEmployeeFromTeam("Luke");
            Assertions.assertEquals(size,team.size());
    }

    @Test
    void removeEmployeeFromTeamIndex() {
        team.addEmployeeToTeam(new Programmer("Luke",1500));
        team.removeEmployeeFromTeam("Luke");
        int index = team.findEmployee(new Programmer("Luke",1500));
        Assertions.assertEquals(-1 ,index);
    }

    @Test
    void testAddEmployeeToTeam() {
        int size = team.size();
        team.addEmployeeToTeam(new Programmer("Luke",1500));
        Assertions.assertEquals(size+1,team.size());
    }
    @Test
    void testAddAll_Null_False() {
        Assertions.assertFalse(team.addAll((Employee[]) null));
    }
    @Test
    void testAddAll_True() {
        Employee[] arr = {new Programmer("Luke",1500), new Programmer("Mike",1000)};
        Assertions.assertTrue(team.addAll(arr));
    }
    @Test
    void test_sortTeam_Normal() {
        this.team = new EmployeeTeam(new Manager("Karl", 4253,1000),
                new Employee[]{new Programmer("Mike",1000), new Programmer("Luke",1500)});
        team.sortTeam();
        Employee[] arrExpected = {new Programmer("Luke",1500), new Programmer("Mike",1000)};
        Assertions.assertEquals(Arrays.toString(arrExpected), Arrays.toString(team.getTeam()));
    }
    @Test
    void test_sortTeam_Empty() {
        this.team = new EmployeeTeam(new Manager("Karl", 4253,1000),
                new Employee[]{});
        team.sortTeam();
        Employee[] arrExpected = {};
        Assertions.assertEquals(Arrays.toString(arrExpected), Arrays.toString(team.getTeam()));
    }
    @Test
    void test_sortTeam_Same() {
        this.team = new EmployeeTeam(new Manager("Karl", 4253,1000),
                new Employee[]{new Programmer("Mike",1000), new Programmer("Mike",1000)});
        team.sortTeam();
        Employee[] arrExpected = {new Programmer("Mike",1000), new Programmer("Mike",1000)};
        Assertions.assertEquals(Arrays.toString(arrExpected), Arrays.toString(team.getTeam()));
    }

}