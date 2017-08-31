package com.delphinadrealms.SQL;

import java.sql.*;
import java.util.UUID;

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
            String createTable = "CREATE TABLE IF NOT EXISTS users (userUUID text unique, playername text, chosenClass text, level integer);";
            Statement createIfDoesntExist = connect.createStatement();
            createIfDoesntExist.executeUpdate(createTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(UUID userUUID, String playername) {
        try {
            String addUser = "INSERT INTO users VALUES (\"" + userUUID + "\" , \"" + playername  + "\" , \"knight\" , 1);";
            System.out.println("INSERT INTO users VALUES (\"" + userUUID + "\" , \"" + playername  + "\" , \"knight\" , 1);");
            Statement addUserStatement = connect.createStatement();
            addUserStatement.executeUpdate(addUser);
            System.out.println("User has been added with the UUID of: " + userUUID + " and the name of: " + playername);
        } catch (SQLException e) {

        }
    }

    public void changeClass(UUID userUUID,String classToChangeTo) {
        try {
            String changeClass = "UPDATE USERS SET chosenClass=\"" + classToChangeTo +"\" WHERE userUUID=\"" + userUUID + "\";";
            System.out.println("UPDATE USERS SET chosenClass=\"" + classToChangeTo +"\" WHERE userUUID=\"" + userUUID + "\";");
            Statement changeClassStatement = connect.createStatement();
            changeClassStatement.executeUpdate(changeClass);

        } catch (SQLException e) {

        }

    }
}
