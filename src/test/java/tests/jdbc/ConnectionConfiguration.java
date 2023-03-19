package tests.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfiguration {
    public static void main(String[] args) {

        String url="jdbc:oracle:thin:@100.25.202.239:1521:XE";
        String username="hr";
        String password="hr";

        try {
            Connection connection= DriverManager.getConnection(url, username, password);
            System.out.println("Connection was successful");

            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection has failed! "+ e.getMessage());
        }
    }
}
