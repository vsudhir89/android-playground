package com.sample.sudhir.playground;

import android.location.Address;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sample.sudhir.playground.dao.Person;
import com.sample.sudhir.playground.dao.Post;
import com.sample.sudhir.playground.dao.Subscriber;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Observer;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button inauguratePostalService;
    Button stopPostalService;

    PostOfficeImpl postOffice;
    private Random random;
    private Post post;

    MySubscriber mySubscriber;
    Subscriber sub;

    // At a random time of every 3 seconds generate a post message to be delivered.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inauguratePostalService = (Button) findViewById(R.id.btnPostOfficeStart);
        stopPostalService = (Button) findViewById(R.id.btnEndPostalService);

        //Init PO
        initializePostOffice();

        addClickListeners();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public PostOffice initializePostOffice() {
        postOffice = new PostOfficeImpl();
        return postOffice;
    }


    public void addObservers() {
        mySubscriber = new MySubscriber("Alex");
        sub = new Subscriber("Vicky");

        postOffice.register(mySubscriber);
        postOffice.register(sub);
    }

    public void removeObservers() {

    }

    public void removeObserver(Person person) {
        postOffice.unregister(person);
    }

    public void addPost() {
        post = new Post(
                R.string.Alex,
                R.string.Vicky,
                new Address(Locale.US),
                new Address(Locale.ITALIAN),
                R.string.post_message_content);

        postOffice.addNewPost(post);

    }

    public void addClickListeners() {

        inauguratePostalService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addObservers();
                addPost();
            }
        });

        stopPostalService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeObserver(mySubscriber);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
