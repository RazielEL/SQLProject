import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main3 {
    public static void main (String[] args) throws SQLException {
        //DBUrl Database string

        String dbUrl = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";
        // zawsze chronione czyms, zeby nie bylo latwego dostepu

        Connection connection = DriverManager.getConnection(dbUrl,userName,password);
        Statement statement = connection.createStatement();
        String query = "select * from person;";
        ResultSet rs = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = rs.getMetaData();

        List<Map<String,String>> tableData = new ArrayList<>();

        while (rs.next()) {
            Map<String, String> row = new LinkedHashMap<>();

            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                String nameOfColumn = resultSetMetaData.getColumnLabel(i);
                String columnValue = rs.getString(nameOfColumn);
                row.put(nameOfColumn,columnValue);
            }
            tableData.add(row);
        }

    System.out.println(tableData);
    }

}
