package com.nhnacademy.stopwatch;

public class ArrayListTestMain {
    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();
        LinkedListTest linkedListTest = new LinkedListTest();
        ListTestProxy proxy = new ListTestProxy(linkedListTest);
        proxy.test();
    }
}
