import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetaData {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.157.140.148:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(url, username, password);

        java.sql.DatabaseMetaData databaseMetaData = connection.getMetaData();

        System.out.println("User: "+databaseMetaData.getUserName());
        System.out.println("Product name: "+databaseMetaData.getDatabaseProductName());
        System.out.println("Product version: "+databaseMetaData.getDatabaseProductVersion());
        System.out.println("Driver name: "+databaseMetaData.getDriverName());
        System.out.println("Driver version: "+databaseMetaData.getDriverVersion());


        connection.close();

    }
}
