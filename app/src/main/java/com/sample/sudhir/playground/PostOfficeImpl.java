package com.sample.sudhir.playground;

import android.util.Log;

import com.sample.sudhir.playground.dao.Person;
import com.sample.sudhir.playground.dao.PersonImpl;
import com.sample.sudhir.playground.dao.Post;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by sudhir on 5/19/17.
 */

public class PostOfficeImpl extends Observable implements PostOffice {

    private static ArrayList<Post> envelopes = new ArrayList<>();
    public String LOG_TAG = PostOfficeImpl.class.getSimpleName();
    public CopyOnWriteArrayList<Person> peopleToNotify = new CopyOnWriteArrayList<>();

    public PostOfficeImpl(CopyOnWriteArrayList<Person> peopleToNotify) {
        this.peopleToNotify = peopleToNotify;
    }

    public PostOfficeImpl() {

    }

    @Override
    public void register(Person person) {

        if (!isNotifyListEmpty()) {
            if(peopleToNotify.size() == 0){
                peopleToNotify.add(person);
                Log.d(LOG_TAG, person.toString() + " added!");
            }
            else {
                for (Person p : peopleToNotify) {
                    if (!p.getName().equalsIgnoreCase(person.getName())) {
                        peopleToNotify.add(person);
                        Log.d(LOG_TAG, person.toString() + " added!");
                    } else {
                        Log.d(LOG_TAG, "Notify list already contains the person...!");
                    }
                }
            }
        } else {
            Log.d(LOG_TAG, "Notify list is null..");
        }
    }

    @Override
    public void unregister(Person person) {

        if (!isNotifyListEmpty()) {
            if (peopleToNotify.contains(person)) {
                peopleToNotify.remove(person);
                Log.d(LOG_TAG, person.toString() + "removed!!");
            } else {
                Log.d(LOG_TAG, "Notify list doesn't contain the person.. Cannot remove..");
            }
        } else {
            Log.d(LOG_TAG, "Notify list is null .. Nobody to remove");
        }

    }

    @Override
    public void notifyObservingPeople() {

        for (Person person : peopleToNotify) {
            person.update(this, "Observable Changed");
        }

    }

    public void addNewPost(Post post) {

        envelopes.add(post);
        Log.d(LOG_TAG, "A new Post was added!");
        for (Post p: envelopes) {
            Log.d(LOG_TAG, p.getContents() + "added!");
        }

        notifyObservingPeople();
    }

    public boolean isNotifyListEmpty() {
        return (peopleToNotify == null);
    }

    public int getObserverCount() {
        return peopleToNotify.size();
    }
}
