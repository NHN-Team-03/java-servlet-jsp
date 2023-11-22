package com.nhnacademy.util;

import javax.servlet.ServletContext;

public class CounterUtils {

    private CounterUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void increaseCounter(ServletContext servletContext) {
        long count = (long) servletContext.getAttribute("counter") + 1;

        servletContext.setAttribute("counter", count);
    }
}
