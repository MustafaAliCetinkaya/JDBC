package tests.jdbc;

import java.sql.*;

public class NavigatingQueryResult {
    public static void main(String[] args) {

        String url="jdbc:oracle:thin:@54.157.140.148:1521:XE";
        String username="hr";
        String password="hr";

        try {
            Connection connection= DriverManager.getConnection(url, username, password);
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from EMPLOYEES");

            resultSet.next();
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getString(5));
            System.out.println(resultSet.getString(6));
            System.out.println(resultSet.getString(7));

            resultSet.next();
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getString(5));
            System.out.println(resultSet.getString(6));
            System.out.println(resultSet.getString(7));

            System.out.println("--------------All Employees--------------");

            while (resultSet.next()){
                System.out.println("Is there any available row :"+resultSet.next()+" \\ Current row is: "+resultSet.getRow());
                for (int i = 1; i <=10; i++) {
                    System.out.print(resultSet.getString(i)+"\t");
                }
                System.out.println();
            }

            connection.close();
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("UNEXPECTED ERROR HAS OCCURRED! "+ e.getMessage());
        }

    }
}
