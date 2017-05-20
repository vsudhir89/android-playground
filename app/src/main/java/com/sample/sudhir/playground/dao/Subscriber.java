package com.sample.sudhir.playground.dao;

import android.util.Log;

import java.util.Observable;

/**
 * Created by sudhir on 5/19/17.
 */

public class Subscriber extends PersonImpl {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Log.d("Subscriber", "Updated name after receiving message in update method!");
    }

    @Override
    public String toString() {
        return getName();
    }
}
