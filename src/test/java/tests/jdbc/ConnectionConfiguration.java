package tests.jdbc;

import utilities.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfiguration {
    public static void main(String[] args) {

        String url="jdbc:oracle:thin:@3.216.30.92:1521:XE";
        String username="hr";
        String password="hr";

        try {
            Connection connection= DriverManager.getConnection(url, username, password);
            System.out.println("Connection was successful");

            //close the connection
            DBUtils.destroy();

        } catch (SQLException e) {
            System.out.println("Connection has failed! "+ e.getMessage());
        }


    }
}
