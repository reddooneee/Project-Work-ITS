package it.its.pwd.cfinverso;

import java.sql.*;

public class Connessione {
    public static Connection connectDatabase() {
        String DB_URL = "jdbc:mysql://localhost:3306/dbcodicefiscale";
        String USER = "root";
        String PASS = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            return con;
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return null;

    }

}