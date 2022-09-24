package DAO;

import java.sql.*;

public class SQLiteJDBC {
    public static Connection conn = null;
    /**
     * Connect to a sample database
     */
    public static void connect() {

        try {
            // db parameters
            //Build Path
            String url = "jdbc:sqlite:DB/praxisDB.db";

            //IDE Path
            //String url = "jdbc:sqlite:src/DAO/praxisDB.db";

            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } /*finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        */
    }


}
