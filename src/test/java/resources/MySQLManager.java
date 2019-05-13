package resources;

import java.sql.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class MySQLManager {

    private final static String dbHost = "localhost";
    private final static int port = 8889;
    private final static String dbName = "testdb";
    private final static String userName = "root";
    private final static String password = "root";


    private Connection conn = null;

    public static void main(String[] args) {
        MySQLManager manager = new MySQLManager();
        String selectQuery = "select * from trainings;";
        String insertQuery = "insert into trainings(name, description) values ('UX', 'A brand new course');";
        String updateQuery = "update trainings set description='Updated description' where id=2;";
        String deleteQuery = "delete from trainings where id=4;";

        manager.connectAndRunQuery(selectQuery);
        manager.connectAndRunQuery(insertQuery);
        manager.connectAndRunQuery(updateQuery);
        manager.connectAndRunQuery(deleteQuery);
        manager.connectAndRunQuery(selectQuery);
    }

    public void connectAndRunQuery(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + port + "/" + dbName +
                    "?useTimezone=true&serverTimezone=UTC", userName, password);

            runQueryAndPrintResults(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void runQueryAndPrintResults(String query) throws SQLException {
        Statement statement = conn.createStatement();
        QueryType type = getQueryType(query);

        log.print("\nRunning query: " + query + "\n");

        switch (type) {
            case SELECT:
                ResultSet rs = statement.executeQuery(query);
                while (rs.next())
                    System.out.println(
                            rs.getInt(1) + "  "
                                    + rs.getString(2) + "  "
                                    + rs.getString(3));
                break;
            default:
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                int numberOfUpdatedRows = preparedStatement.executeUpdate();
                log.print(numberOfUpdatedRows + " rows " + type.toString().toLowerCase() + "d.");
                break;
        }
    }

    private QueryType getQueryType(String query) {
        return QueryType.valueOf(query.substring(0, query.indexOf(" ")).toUpperCase());
    }
}

