package com.nhnacademy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflectionMain {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName(User.class.getName());
            Object user = clazz.getDeclaredConstructor().newInstance();

            Field userNameField = clazz.getDeclaredField("userName");
            userNameField.setAccessible(true);
            userNameField.set(user, "Huni");

            Field userAgeField = clazz.getDeclaredField("userAge");
            userAgeField.setAccessible(true);
            userAgeField.set(user, 25);

            String userName = (String) userNameField.get(user);
            int userAge = (int) userAgeField.get(user);

            System.out.println("userName : " + userName);
            System.out.println("userAge : " + userAge);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
