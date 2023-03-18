import java.sql.*;

public class ResultSetMetaDataColumnInfo {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.157.140.148:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from EMPLOYEES");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();


        //Dynamic, the last column index is assigned automatically
        System.out.println("--------------Dynamic--------------");
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.println(i + ". column name: " + resultSetMetaData.getColumnName(i));
        }

        System.out.println("--------------All Employees--------------");

        while (resultSet.next()){
            System.out.println("Current row is :"+resultSet.getRow());
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.print(resultSet.getString(i)+" - ");
            }
            System.out.println();
        }

    }
}
