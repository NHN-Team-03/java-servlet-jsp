package com.nhnacademy.jsp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LocalDateTimeFunction {
    public static String formatDate(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }
}
