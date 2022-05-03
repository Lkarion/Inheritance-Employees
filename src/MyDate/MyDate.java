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
        return (this.year - myDate.year)* 365 + (this.month - myDate.month)*30 + (this.day - myDate.day);
    }

    //3. In MyDate class Implement method int dayBetween(MyDate) that returns how many days between given MyDate
    // and this MyDate
    public int dayBetween(MyDate myDate){
        return (int) ChronoUnit.DAYS.between(LocalDate.parse(this.toString()),LocalDate.parse(myDate.toString()));
    }
    //4. In MyDate class Implement method int dayBetween(MyDate,MyDate) that returns how many days between
    // the two given MyDates

    public static int dayBetween(MyDate myDate1, MyDate myDate2){
        return (int) ChronoUnit.DAYS.between(LocalDate.parse(myDate1.toString()),LocalDate.parse(myDate2.toString()));
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    //5. Read about Integer.parseInt(String) method and implement the constructor MyDate(String s)
    // which allows to create MyDate from string like “2022-10-21”

    public MyDate(String s) {
        //TODO делать проверку на корректность строки. есть ли вообще 3 элемента в массиве потом? месяц <=12?
        String[] strings = s.split("-");
        this.day = Integer.parseInt(strings[0]);
        this.month = Integer.parseInt(strings[1]);
        this.year = Integer.parseInt(strings[2]);

    }






    // days between ручками
    public static int getDaysBetween(MyDate date1, MyDate date2){
        if (date1.year == date2.year)
            if (date1.month == date2.month)
                return Math.abs(date1.day - date2.day);
            else return Math.abs(countDaysInCurrentYear(date1) - countDaysInCurrentYear(date2));


        int maxYear, minYear, daysRestInYear,
                daysInLaterDate, sumDays = 0;

        if (date1.year > date2.year){
            daysInLaterDate = countDaysInCurrentYear(date1);
            maxYear = date1.year;
            minYear = date2.year;
            daysRestInYear = getDaysBetween(date2,new MyDate(31,12, minYear));//TODO убрать использование обектов, чтобы они тут не плодились
       //TODO возможно, оверлодить метод countDaysInCurrentYear, чтобы обойтись без использования объектов
        }else{
            daysInLaterDate = countDaysInCurrentYear(date2);
            maxYear = date2.year;
            minYear = date1.year;
            daysRestInYear = getDaysBetween(date1,new MyDate(31,12, minYear));
        }


        for (int i = minYear+1; i < maxYear; i++) {
            sumDays += countDaysInCurrentYear(new MyDate(31,12, i));
        }
        return daysRestInYear + sumDays + daysInLaterDate;
    }

    public static int countDaysInCurrentYear(MyDate myDate){
        if (myDate.month == 12 && myDate.day == 31)
            return checkVisokosniyGod(myDate.year) ? 366 : 365;

        int sumDays = 0;
        for (int i = 1; i < myDate.month; i++) {
            sumDays += getDaysInMonth(i, myDate.year);
        }
        sumDays += myDate.day;
        return sumDays;
    }

    public static int getDaysInMonth(int mon, int year){
        if ((mon >= 1 && mon <= 12)) {
            switch (mon) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;
                case 2: return checkVisokosniyGod(year) ? 29 : 28;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
            }
        }
        return -1;
    }

    public static boolean checkVisokosniyGod(int god){
        return ((god%4==0)&&(god%100 != 0)) || (god % 400 == 0);
    }

    //Using any algorithm of sorting you know and the method compareTo you wrote in class MyDate implement method
    // of sorting an array of MyDates
    public static void sortMyDate(MyDate[] array){
        for (int i = 0; i < array.length-1; i++) {
            MyDate temp = array[findMinIndex(array,i)];
            array[findMinIndex(array,i)] = array[i];
            array[i] = temp;
        }
    }
    public static int findMinIndex(MyDate[] array, int indexNotSorted){
        int minIndex = indexNotSorted;
        MyDate min = array[indexNotSorted];
        for (int i = indexNotSorted; i < array.length; i++) {
            if (min.compareTo(array[i]) > 0){
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
