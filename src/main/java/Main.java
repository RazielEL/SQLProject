import java.sql.*;

public class Main {
    public static void main (String[] args) throws SQLException {


        // connection string usually provided by DBA.
        String dbURL = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql"; // driver of data base (jdbc)
        // java api that contains all the interface and classes
        // my sql is the name of the database that will be working with
        // 3.237.189.167 it is IP of the server where we have the database
        // 3306 it is a port on which the database is active.
        // ONE CONNECTION FOR ONE DATABASE
        // but we can connect to multiple databases in one program.
        // syntaxhrm_mysql - database name.
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";
        Connection connection = DriverManager.getConnection(dbURL, userName, password);

        Statement statement = connection.createStatement();
        String query = "select * from employee"; // skopiowane z workbench
        ResultSet resultSet = statement.executeQuery(query);

        while ((resultSet.next())){
            String empId = resultSet.getString("empId");
            String salary = resultSet.getString("salary");
            String grade = resultSet.getString("grade");
            String department = resultSet.getString("department");
            System.out.println(empId + " " + salary + " " + grade + " " + department);


        }




    }
}
