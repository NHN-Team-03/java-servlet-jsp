package com.nhnacademy.di;

import com.nhnacademy.reflection.User;

public class DiTest {

    public static void main(String[] args) {

        UserService userService = InjectUtil.getObject(UserService.class);

        User user = new User("seungjo", 25);
        userService.addUser(user);

        System.out.println(userService.getUser("seungjo"));
    }
}
