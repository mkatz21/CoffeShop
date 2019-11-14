package com.example.coffeshop;

import java.util.Date;

public class Calendar {

    public Date CalendarYear;
    public Date CalendarMonth;
    public Date CalendarDate;
    public  Date CalendarDays;
    public Boolean CalendarWeekend;
    public Boolean CalendarWeekday;

    public Calendar() {
    }

    public Calendar(Date calendarYear, Date calendarMonth, Date calendarDate, Date calendarDays, Boolean calendarWeekend, Boolean calendarWeekday) {
        CalendarYear = calendarYear;
        CalendarMonth = calendarMonth;
        CalendarDate = calendarDate;
        CalendarDays = calendarDays;
        CalendarWeekend = calendarWeekend;
        CalendarWeekday = calendarWeekday;
    }
}
