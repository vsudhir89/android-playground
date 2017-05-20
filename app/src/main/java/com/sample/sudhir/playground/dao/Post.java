package com.sample.sudhir.playground.dao;

import android.location.Address;

/**
 * Created by sudhir on 5/19/17.
 */

public class Post {

    private int nameTo;
    private int nameFrom;
    private Address toAddress;
    private Address fromAddress;
    private int contents;

    public Post(int nameTo, int nameFrom, Address toAddress, Address fromAddress, int contents) {
        this.nameTo = nameTo;
        this.nameFrom = nameFrom;
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.contents = contents;
    }

    public Post() {

    }

    public int getNameTo() {
        return nameTo;
    }

    public void setNameTo(int nameTo) {
        this.nameTo = nameTo;
    }

    public int getNameFrom() {
        return nameFrom;
    }

    public void setNameFrom(int nameFrom) {
        this.nameFrom = nameFrom;
    }

    public int getContents() {
        return contents;
    }

    public void setContents(int contents) {
        this.contents = contents;
    }

    public Address getToAddress() {
        return toAddress;
    }

    public void setToAddress(Address toAddress) {
        this.toAddress = toAddress;
    }

    public Address getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(Address fromAddress) {
        this.fromAddress = fromAddress;
    }

    @Override
    public String toString() {
        return "Post : \n " +
                "From : " + getNameFrom() +
                "To : " + getNameTo() +
                "Contents : " + getContents();
    }
}
