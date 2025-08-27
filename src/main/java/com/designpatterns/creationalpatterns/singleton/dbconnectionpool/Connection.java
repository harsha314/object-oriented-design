package com.designpatterns.creationalpatterns.singleton.dbconnectionpool;

import java.util.ArrayList;

public class Connection {
    private static Connection connection ;

    private Connection() {
        // make asynchronous requests to the Database
    }

    public static synchronized Connection getInstance() {
        if(Connection.connection == null) {
            Connection.connection = new Connection() ;
        }
        return Connection.connection ;
    }

    public Object execute(String query) {
        return new ArrayList<Integer>();
    }
}
