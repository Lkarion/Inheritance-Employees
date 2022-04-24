package MyDate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate {
    public static void main(String[] args) {
        System.out.println(ChronoUnit.DAYS.between(LocalDate.now(),LocalDate.parse("2022-04-20")));
    }
    // 1. Implement MyDate class (int day, int month, int year). Implement two constructors
    // (day,month,year), (day,month) in this case year is 2022.
    int day;
    int month;
    int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate(int day, int month) {
        this.day = day;
        this.month = month;
        this.year = 2022;
    }

    //2. In MyDate class Implement method compareTo(MyDate) that compare the given MyDate with this MyDate
    public int compareTo(MyDate myDate){
        return this.year != myDate.year ?
                this.year - myDate.year
                : this.month != myDate.month ?
                    this.month - myDate.month
                    : this.day - myDate.day;
    }

    //3. In MyDate class Implement method int dayBetween(MyDate) that returns how many days between given MyDate
    // and this MyDate
    public int dayBetween(MyDate myDate){
        return (int) ChronoUnit.DAYS.between(LocalDate.parse(this.toString()),LocalDate.parse(myDate.toString()));
    }
    //4. In MyDate class Implement method int dayBetween(MyDate,MyDate) that returns how many days between
    // the two given MyDates

    public int dayBetween(MyDate myDate1, MyDate myDate2){
        return (int) ChronoUnit.DAYS.between(LocalDate.parse(myDate1.toString()),LocalDate.parse(myDate2.toString()));
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day + "-";
    }

    //5. Read about Integer.parseInt(String) method and implement the constructor MyDate(String s)
    // which allows to create MyDate from string like “2022-10-21”

    public MyDate(String s) {
        String[] strings = s.split("-");
        this.year = Integer.parseInt(strings[0]);
        this.month = Integer.parseInt(strings[1]);
        this.day = Integer.parseInt(strings[2]);

    }
}
