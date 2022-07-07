import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Main2 {
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
// for loop
        for (int i = 1; i<= resultSetMetaData.getColumnCount();i++){
            System.out.print(resultSetMetaData.getColumnLabel(i)+" ");
        }
        // while loop goes thru data
        while (rs.next()) {
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                String nameOfColumn = resultSetMetaData.getColumnLabel(i);
                String columnValue = rs.getString(nameOfColumn);
                System.out.print(columnValue + " ");
            }
            System.out.println();
        }

    }
}
