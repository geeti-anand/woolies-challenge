package com.woolies_challenge.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DayOfWeekUtil {

    public static boolean dayOfWeek(String inputDate) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
            LocalDate localDate = LocalDate.parse(inputDate, formatter);

            DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            int dayOfWeekValue = dayOfWeek.getValue();
            if (dayOfWeekValue == 4) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("date exception while parsing");

        }
        return false;
    }
        public static void main (String[]args){
            System.out.println(dayOfWeek("2020-10-01 02:03:30"));
        }
    }