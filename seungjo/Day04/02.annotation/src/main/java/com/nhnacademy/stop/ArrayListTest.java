package com.nhnacademy.stop;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest implements PerformanceTestable {

    @StopWatch
    @Override
    public void test() {
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100_000_000; i++) {
            arrayList.add(i);
        }
    }
}
