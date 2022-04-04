package com.company;

public class Main {

    public static void main(String[] args) {
        Programmer p1=new Programmer("Ivan",1000);
        Programmer p2=new Programmer("Mike",1500);
        QAEngineer q1=new QAEngineer("Lena",1200);
        QAEngineer q2=new QAEngineer("Max",1100);

        Employee[] employee = {p1,p2,q1,q2, new Intern("Jack",200)};
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i]);
            employee[i].doWork();
        }

        EmployeeTeam team1 = new EmployeeTeam(new Manager("Karl", 4253,1000));
        team1.addEmployeeToTeam(p1);
        team1.addEmployeeToTeam(p2);
        team1.addEmployeeToTeam(p2);
      //  m1.addEmployeeToTeam1(p1);
      //  m1.addEmployeeToTeam1(p2);
        team1.removeEmployeeFromTeam(1);

        System.out.println(team1.findEmployee(p1));


    }
}
