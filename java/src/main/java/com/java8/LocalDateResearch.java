package com.java8;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class LocalDateResearch {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2018,10,1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
        String s = formatter.format(LocalDate.now());
        System.out.println(s);
    }
}
