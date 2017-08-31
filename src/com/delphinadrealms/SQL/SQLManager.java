package com.delphinadrealms.SQL;

import java.sql.*;

/**
 * Created by henry27 on 8/28/2017.
 */
public class SQLManager {

    public SQLManager() {
        this.connect();
    }

    private Connection connect = null;

    private void connect() {
        try {
            String url = "jdbc:SQLite:ctf.db";
            connect = DriverManager.getConnection(url);
            String createTable = "CREATE TABLE IF NOT EXISTS users (userUUID long(36) unique, playername text, enableCTF boolean);";
            Statement createIfDoesntExist = connect.createStatement();
            ResultSet tableExists = createIfDoesntExist.executeQuery(createTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(long userUUID,String playername, boolean enableCTF) {
        try {
            String addUser = "INSERT INTO users VALUES (" + userUUID + ", " + playername  + ", " + enableCTF + ");";
            Statement addUserStatement = connect.createStatement();
            ResultSet rs = addUserStatement.executeQuery(addUser);
            System.out.println("User has been added with the UUID of: " + rs.getLong("userUUID") + " and the name of: " + rs.getString("playername"));
        } catch (SQLException e) {

        }
    }
}
