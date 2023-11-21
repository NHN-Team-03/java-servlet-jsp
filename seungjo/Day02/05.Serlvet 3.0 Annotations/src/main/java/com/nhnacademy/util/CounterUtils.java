package com.nhnacademy.util;

import java.util.Optional;
import javax.servlet.ServletContext;

public final class CounterUtils {

    private CounterUtils() {
        throw new IllegalArgumentException("Utility class");
    }

    public static void increaseCounter(ServletContext servletContext) {
        long counter = Optional.ofNullable((Long)servletContext.getAttribute("counter")).orElse(0L);

        counter = Math.addExact(counter, 1);
        servletContext.setAttribute("counter", counter);
    }
}
