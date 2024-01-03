package com.example.droidplaygroundjava.util;

import android.util.Log;

import com.example.droidplaygroundjava.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {
    public static ArrayList<User> getUsers(int start, int end) {
        ArrayList<User> userList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            String name = "User" + i;
            int age = i; // Just an example for age, you can set it as per your requirement
            User user = new User(name, age);
            userList.add(user);
        }
        return userList;
    }
}

