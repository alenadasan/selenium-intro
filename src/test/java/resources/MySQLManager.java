package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLManager {

    private static String userName = "root";
    private static String password = "root";
    private static String host = "localhost";
    private static String port = "8889";
    private static String dbName = "testdb";
    private static String query = "select * from trainings;";

    public static void runQuery(String query) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":" + port + "/" + dbName, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)); //add if more columns
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        runQuery(query);
    }

}
