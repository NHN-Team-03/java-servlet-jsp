package com.nhnacademy.student.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFunction {
    public LocalDateTimeFunction() {
    }

    public static String formatDate(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }
}
