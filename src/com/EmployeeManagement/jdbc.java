package com.EmployeeManagement;

import java.sql.Connection; //This interface represents a connection to a database.
import java.sql.DriverManager; //This class manages a list of database drivers and is used to establish a connection to the database
import java.sql.SQLException; //This class manages a list of database drivers and is used to establish a connection to the database

public class jdbc {

    static final String url="jdbc:mysql://localhost:3306/EMPLOYEEDB"; /*jdbc:mysql: The protocol for connecting to a MySQL database using JDBC.
localhost: The server where the database is hosted (in this case, your local machine).
3306: The default port number for MySQL.
EMPLOYEEDB: The name of the specific database you're connecting to.*/
    static final String user = "root";
    static final String password= "Swathy@20";


    public  Connection connect(){

        Connection con =null;

        try{
            con= DriverManager.getConnection(url,user,password);
            System.out.println("Connected to Database.");
        }catch (SQLException e){
            System.out.println("Connection failed: "+e.getMessage());
        }return con;  // Return the Connection object (or null if the connection failed).
    }
}
/*  Connection: This is the return type of the method, specifically a
java.sql.Connection object. The Connection interface in Java represents
an active connection to a database, which allows you to send SQL commands,
execute queries, and retrieve results. A Connection object gives you
 access to the database, and through it, you can perform various
 database operations like inserting, updating, deleting, and fetching data.
 */
//Connection is an interface that belongs to the java.sql package.
