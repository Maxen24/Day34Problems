package com.bridgelabz;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {
    private Connection getConnection() throws SQLException{
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/employee_payroll?useSSL-false";
        String username = "root";
        String password = "Cool@2197";
        Connection connect;

        System.out.println("Connecting to database" + jdbcUrl);
        connect = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("Connection Successfully"+connect);
        return connect;
    }

    public List<EmployeePayrollData>readData(){
        String sqlStatement= "SELECT employeeID, employeeName, employeeSalary, starDate from employee_payroll; ";
        List<EmployeePayrollData>employeePayrollDataList=new ArrayList<>();

        try(Connection connect=getConnection()){
            Statement statement=connect.createStatement();
            ResultSet resultSet=statement.executeQuery(sqlStatement);

            while(resultSet.next()){
                int id= resultSet.getInt("employeeID");
                String name=resultSet.getString("employeeName");
                double salary=resultSet.getDouble("employeeSalary");
                LocalDate date=resultSet.getDate("starDate").toLocalDate();
                employeePayrollDataList.add(new EmployeePayrollData(id, name,salary, date));
            }

        }catch(SQLException e){
            e.printStackTrace();

        }
        return employeePayrollDataList;
    }
}
