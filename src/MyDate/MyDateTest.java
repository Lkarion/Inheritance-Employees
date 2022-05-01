package MyDate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyDateTest {

    //TODO test NULL values. What should programm do with null parameters?

    @Test
    void getDaysBetween() {
        MyDate date1 =new MyDate(25,04,2022);
        MyDate date2 = new MyDate(24,04,2022);
        assertEquals(1, MyDate.getDaysBetween(date1, date2));
    }

    @Test
    void getDaysBetweenDifMonths() {
        MyDate date1 =new MyDate(1,04,2022);
        MyDate date2 = new MyDate(31,03,2022);
        assertEquals(1, MyDate.getDaysBetween(date1, date2));
    }
    @Test
    void getDaysBetweenDifMonthsMore() {
        MyDate date1 =new MyDate(31,12,2022);
        MyDate date2 = new MyDate(01,01,2022);
        assertEquals(364, MyDate.getDaysBetween(date1, date2));
    }
    @Test
    void getDaysBetweenDifYears() {
        MyDate date1 =new MyDate(31,12,2022);
        MyDate date2 = new MyDate(01,01,2023);
        assertEquals(1, MyDate.getDaysBetween(date1, date2));
    }
    @Test
    void getDaysBetweenDifYearsMore() {
        MyDate date1 =new MyDate(30,4,2020);
        MyDate date2 = new MyDate(01,11,2023);
        assertEquals(1280, MyDate.getDaysBetween(date1, date2));
    }
    @Test
    void getDaysBetweenDifYearsMoreVersa() {
        MyDate date1 = new MyDate(01,11,2023);
        MyDate date2 =new MyDate(30,4,2020);
        assertEquals(1280, MyDate.getDaysBetween(date1, date2));
    }



    // test sort MyDate array
    @Test
    void test_sortMyDate_EmptyArray(){
        MyDate[] dates = new MyDate[]{};
        MyDate[] datesExpected = new MyDate[]{};
        MyDate.sortMyDate(dates);
        assertEquals(Arrays.toString(datesExpected),Arrays.toString(dates));
    }
    @Test
    void test_sortMyDate_NormalArray(){
        MyDate[] dates = new MyDate[]{
                new MyDate(21,2,2021),
                new MyDate(12,2,2020),
                new MyDate(01,01,1988)};
        MyDate[] datesExpected = new MyDate[]{
                new MyDate(01,01,1988),
                new MyDate(12,2,2020),
                new MyDate(21,2,2021)};
        MyDate.sortMyDate(dates);
        assertEquals(Arrays.toString(datesExpected),Arrays.toString(dates));
    }
    @Test
    void test_sortMyDate_One_Date(){
        MyDate[] dates = new MyDate[]{new MyDate(01,01,1988)};
        MyDate[] datesExpected = new MyDate[]{new MyDate(01,01,1988)};
        MyDate.sortMyDate(dates);
        assertEquals(Arrays.toString(datesExpected),Arrays.toString(dates));
    }
    @Test
    void test_sortMyDate_Same_Dates(){
        MyDate[] dates = new MyDate[]{new MyDate(01,01,1988),new MyDate(01,01,1988)};
        MyDate[] datesExpected = new MyDate[]{new MyDate(01,01,1988),new MyDate(01,01,1988)};
        MyDate.sortMyDate(dates);
        assertEquals(Arrays.toString(datesExpected),Arrays.toString(dates));
    }

}