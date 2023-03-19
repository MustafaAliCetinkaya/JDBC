package tests.junitTests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listOfMapExample {
    String dbUrl = "jdbc:oracle:thin:@54.157.140.148:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();


    public listOfMapExample() throws SQLException {
    }

    @Test
    public void test1() throws SQLException {

        //creating list for keeping all the rows maps
        List<Map<String, Object>> queryData = new ArrayList<>();

        Map<String, Object> row1 = new HashMap<>();

        row1.put("first_name", "Steven");
        row1.put("last_name", "King");
        row1.put("salary", 24000);
        row1.put("job_id", "AD_PRES");

        System.out.println(row1.toString());

        Map<String, Object> row2 = new HashMap<>();

        row2.put("first_name", "Neena");
        row2.put("last_name", "Kochhar");
        row2.put("salary", 17000);
        row2.put("job_id", "AD_VP");

        System.out.println(row2.toString());

        //adding rows one by one to my list
        queryData.add(row1);
        queryData.add(row2);

        //get the steven lastname directly from the list
        System.out.println(queryData.get(0).get("last_name"));

        System.out.println("----------------Dynamic-----------------");

        List<Map<String, Object>> queryData2 = new ArrayList<>();

        while (resultSet.next()) {

            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                Map<String, Object> currentRow = new HashMap<>();

                String currentEmployee = resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME");
                Object salaryOfCurrentEmployee = resultSet.getString("SALARY");

                currentRow.put(currentEmployee, salaryOfCurrentEmployee);
                if (!queryData2.contains(currentRow)) {
                    queryData2.add(currentRow);
                }
            }
        }

        for (Map<String, Object> eachMap : queryData2) {
            System.out.println(eachMap.toString());
        }

    }

    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT first_name,last_name,salary,job_id\n" +
                "from employees\n" +
                "where rownum <6");

        //in order to get column names we need resultsetmetadata
        ResultSetMetaData rsmd = resultSet.getMetaData();

        //move to first row
        resultSet.next();

        //creating list for keeping all the rows maps
        List<Map<String, Object>> queryData = new ArrayList<>();

        Map<String, Object> row1 = new HashMap<>();

        row1.put(rsmd.getColumnName(1), resultSet.getString(1));
        row1.put(rsmd.getColumnName(2), resultSet.getString(2));
        row1.put(rsmd.getColumnName(3), resultSet.getString(3));
        row1.put(rsmd.getColumnName(4), resultSet.getString(4));

        System.out.println(row1.toString());

        //move to second row
        resultSet.next();

        Map<String, Object> row2 = new HashMap<>();

        row2.put(rsmd.getColumnName(1), resultSet.getString(1));
        row2.put(rsmd.getColumnName(2), resultSet.getString(2));
        row2.put(rsmd.getColumnName(3), resultSet.getString(3));
        row2.put(rsmd.getColumnName(4), resultSet.getString(4));

        System.out.println(row2.toString());
        //BREAK UNTIL 2:20

        //adding rows one by one to my list
        queryData.add(row1);
        queryData.add(row2);

        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}