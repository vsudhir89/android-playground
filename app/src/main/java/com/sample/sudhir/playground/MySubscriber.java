package com.sample.sudhir.playground;

import android.util.Log;

import com.sample.sudhir.playground.dao.PersonImpl;

import java.util.Observable;

/**
 * Created by sudhir on 5/19/17.
 */

public class MySubscriber extends PersonImpl {

    private String name;
    private int age;

    public MySubscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void update(Observable o, Object arg) {
        Log.d("MySubscriber", "Update called --> updating age!");
    }

    @Override
    public String toString() {
        return getName();
    }
}
