package employee;

import employee.programmer.Programmer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTeamTest {
    EmployeeTeam team;

    @BeforeEach
    public void init(){
        this.team= new EmployeeTeam();
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

}