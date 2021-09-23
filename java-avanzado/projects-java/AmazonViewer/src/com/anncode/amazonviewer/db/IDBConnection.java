package com.anncode.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.anncode.amazonviewer.db.DataBase.*;

public interface IDBConnection {
    default Connection connectToDB() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL + DB,USER, PASSWORD);

            System.out.println("ACA " + connection);
            if (connection != null) {
                System.out.println("Se estableció la connexion ");
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error: " + e);
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}
