import java.sql.*;

public class NavigatingResultSet {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.157.140.148:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select * from EMPLOYEES");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        //ResultSet Methods
        resultSet.first();
        System.out.println("First row item: "+resultSet.getString("FIRST_NAME") + "  " + resultSet.getString("LAST_NAME") + " : " + resultSet.getString("SALARY"));

        resultSet.last();
        System.out.println("Last row item: "+resultSet.getString("FIRST_NAME") + "  " + resultSet.getString("LAST_NAME") + " : " + resultSet.getString("SALARY"));

        resultSet.previous();
        System.out.println("Before last row item: "+resultSet.getString("FIRST_NAME") + "  " + resultSet.getString("LAST_NAME") + " : " + resultSet.getString("SALARY"));

        for (int i = 1; i < 10; i++) {
            resultSet.absolute(i);
            System.out.println(i+"- "+resultSet.getString("FIRST_NAME") + "  " + resultSet.getString("LAST_NAME") + " : " + resultSet.getString("SALARY"));
        }

        resultSet.beforeFirst();
        resultSet.next();
        System.out.println(resultSet.getString("FIRST_NAME") + "  " + resultSet.getString("LAST_NAME") + " : " + resultSet.getString("SALARY"));

        resultSet.afterLast();
        resultSet.previous();
        System.out.println(resultSet.getString("FIRST_NAME") + "  " + resultSet.getString("LAST_NAME") + " : " + resultSet.getString("SALARY"));


    }
}
