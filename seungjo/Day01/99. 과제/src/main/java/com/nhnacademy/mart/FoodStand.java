package com.nhnacademy.mart;

import java.util.ArrayList;

public class FoodStand {
    private final ArrayList<Food> foods = new ArrayList<>();

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void add(Food food) {
        foods.add(food);
    }

    public Food remove(String name) {
        int index = 0;
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                return foods.remove(index);
            }
            index++;
        }

        throw new IllegalStateException("해당 음식이 없습니다.");
    }
}
