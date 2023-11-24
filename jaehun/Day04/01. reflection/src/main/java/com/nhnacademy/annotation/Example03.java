package com.nhnacademy.annotation;

import java.util.LinkedList;
import java.util.List;

public class Example03 {
    public static void main(String[] args) {
        @SuppressWarnings({"unused"})
        String name = "Huni";

        System.out.println("hello Huni");

        @SuppressWarnings({"unused", "deprecation"})
        Integer a = new Integer(1);

        @SuppressWarnings({"rawtypes"})
        List list = new LinkedList<>();
        Box<String> box = new Box<>("Huni");
        list.add(box);
    }

    public static class Box<T> {
        private final T t;

        public Box(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }
    }
}
