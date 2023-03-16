import java.sql.*;

public class NavigatingQueryResult {
    public static void main(String[] args) {

        String url="jdbc:oracle:thin:@100.25.202.239:1521:XE";
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

            while (resultSet.next()){
                System.out.println("Is there any available row :"+resultSet.next());
                for (int i = 1; i < 9; i++) {
                    System.out.print(resultSet.getString(i)+" - ");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("UNEXPECTED ERROR HAS OCCURRED! "+ e.getMessage());
        }

    }
}
