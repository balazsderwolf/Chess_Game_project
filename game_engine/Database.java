package com.company.game_engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    //PLAYER NAMES
    String[] playerNames;
    //PLAYER 1
    Connection conn1;
    Statement statement1;
    //PLAYER 2
    Connection conn2;
    Statement statement2;

    public Database(String[] databaseNames) throws SQLException, ClassNotFoundException {
        playerNames = databaseNames;
        Class.forName("org.sqlite.JDBC");
        conn1 = DriverManager.getConnection("jdbc:sqlite:/Users/balazsfarkas/IdeaProjects/sakk_tabla/" + databaseNames[0] + ".db");
        statement1 = conn1.createStatement();

        conn2 = DriverManager.getConnection("jdbc:sqlite:/Users/balazsfarkas/IdeaProjects/sakk_tabla/" + databaseNames[1] + ".db");
        statement2 = conn2.createStatement();
    }

    public void connect() {
        try {
            statement1.execute("CREATE TABLE IF NOT EXISTS moves(x INTEGER, y INTEGER)");
            statement2.execute("CREATE TABLE IF NOT EXISTS moves(x INTEGER, y INTEGER)");

        } catch (SQLException e) {
            System.out.println("Something went worng with SQL database " + e.getMessage());
        }
    }

    public void saveMoveToDB(String currentPlayer, int X, int Y) throws SQLException {
        connect();
        if (currentPlayer == playerNames[0]) {
            statement1.execute("INSERT INTO moves(x,y) VALUES (" + X + "," + Y + ")");
        } else if (currentPlayer == playerNames[1]) {
            statement2.execute("INSERT INTO moves(x,y) VALUES (" + X + "," + Y + ")");
        }


    }

    public void closeDataBase() throws SQLException {
        statement1.close();
        statement2.close();
        conn1.close();
        conn2.close();
        System.out.println("\n Databases saved successfully");
    }
}
