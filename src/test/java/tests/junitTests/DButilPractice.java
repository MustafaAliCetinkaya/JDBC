package tests.junitTests;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DButilPractice {


    @Test
    public void test1(){

        //create connection
        DBUtils.createConnection();
        String query = "SELECT first_name,last_name,salary,job_id\n" +
                "from employees\n" +
                "where rownum <36";

        List<Map<String, Object>> queryData = DBUtils.getQueryResultMap(query);

        //print the result
        for (Map<String, Object> row : queryData) {
            System.out.println(row.toString());
        }
        //close the connection
        DBUtils.destroy();

    }


    @Test
    public void test2(){
        //create connection
        DBUtils.createConnection();
        String query = "SELECT first_name,last_name,salary,job_id\n" +
                "from employees\n" +
                "where rownum <2";

        Map<String, Object> rowMap = DBUtils.getRowMap(query)
                ;
/*If the query results in multiple rows and/or columns of data,
only first row will be returned. The rest of the data will be ignored*/

        System.out.println(rowMap.toString());

        //close the connection
        DBUtils.destroy();

    }

}