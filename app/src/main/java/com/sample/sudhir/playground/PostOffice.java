package com.sample.sudhir.playground;

import com.sample.sudhir.playground.dao.Person;

import java.util.Observer;

/**
 * Created by sudhir on 5/19/17.
 */
// AKA Subject
public interface PostOffice {

    void register(Person person);
    void unregister(Person person);
    void notifyObservingPeople();

}
