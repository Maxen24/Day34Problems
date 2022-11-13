package com.bridgelabz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DBSample {

    //UC-1 Ability to create a payroll service
    //database and have java program
    //connect to database
    //- Use the payroll_service database created in MySQL
    //- Download and register the jdbc driver jar to your Build
    //Path in Eclipse
    //- Alternatively use Maven or Gradle to add jdbc driver to
    //your project
    //- Check if the Driver Class is available for the java
    //program
    //- Check all the drivers registered with the jdbc driver
    //- Check if the database connection to payroll_service
    //mysql DB is established

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/employee_payroll?useSSL-false";
        String username = "root";
        String password = "Cool@2197";
        Connection connect;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Driver does not exist");
        }
        try {
            System.out.println("Connecting to database" + jdbcUrl);
            connect = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connection Successfully"+connect);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        private static void ListDrivers(){
            Enumeration<Driver>listDriver= DriverManager.getDrivers();
            while(listDriver.hasMoreElements()){
                Driver driverclass=(Driver) listDriver.nextElement();
                System.out.println(" "+driverclass.getClass());
            }
        }
    }

