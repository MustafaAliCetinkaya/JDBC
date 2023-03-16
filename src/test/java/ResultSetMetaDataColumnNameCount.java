import java.sql.*;

public class ResultSetMetaDataColumnNameCount {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@100.25.202.239:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from EMPLOYEES");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        //Get total number of columns
        System.out.println("Total number of columns: "+resultSetMetaData.getColumnCount());

        //Get column titles
        System.out.println("Name of the column: "+resultSetMetaData.getColumnName(1));


    }
}
