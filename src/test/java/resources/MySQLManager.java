package resources;

import java.sql.*;

public class MySQLManager {

    private static String userName = "root";
    private static String password = "root";
    private static String host = "localhost";
    private static String port = "8889";
    private static String dbName = "testdb";
    private static String query = "select * from trainings;";

    public static void main(String[] args) {
        runInsertIntoTrainings();
        runQuery(query);
    }

    public static void runQuery(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName, userName, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            printResults(rs);

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void runInsertIntoTrainings() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName, userName, password);

            PreparedStatement stmt = con.prepareStatement("insert into trainings values(?,?,?)");
            stmt.setInt(1, 2);//1 specifies the first parameter in the query
            stmt.setString(2, "Manual testing");
            stmt.setString(3, "Intro course");

            int numberOfUpdatedRows = stmt.executeUpdate();
            System.out.println(numberOfUpdatedRows + " rows inserted.");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void printResults(ResultSet rs) throws SQLException {
        while (rs.next())
            System.out.println(rs.getInt(1) + "  " + rs.getString(2)); //add if more columns
    }

}
