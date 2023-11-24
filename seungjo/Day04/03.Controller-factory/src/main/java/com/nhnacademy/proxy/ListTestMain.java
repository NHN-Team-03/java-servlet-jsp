package com.nhnacademy.proxy;

public class ListTestMain {
    public static void main(String[] args) {
        ListTestProxy arrayListTestProxy = new ListTestProxy(new ArrayListTest());
        arrayListTestProxy.test();

        ListTestProxy linkedListTestProxy = new ListTestProxy(new LinkedListTest());
        linkedListTestProxy.test();
    }
}
