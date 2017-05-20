package com.sample.sudhir.playground.dao;

import java.util.Observer;

/**
 * Created by sudhir on 5/19/17.
 */

public interface Person extends Observer {

    String name = "";

    String getName();

    void setName(String name);


}
