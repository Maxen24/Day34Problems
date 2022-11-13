package com.bridgelabz;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public enum IOService {
        CONSOLE_IO, FILE_IO, DB_IO, REST_IO
    }

    private List<EmployeePayrollData> employeePayrollList;



    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    private void readEmployeePayrollData(Scanner consoleInputReader) {

        System.out.println("Enter the Employee Id : ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter the Employee Name : ");
        String name = consoleInputReader.next();
        System.out.println("Enter the Employee Salary : ");
        double salary = consoleInputReader.nextDouble();
        System.out.println("Enter the date: ");
        LocalDate date= LocalDate.parse(consoleInputReader.next());

        employeePayrollList.add(new EmployeePayrollData(id, name, salary,date));
    }

    private void writeEmployeePayrollData() {
        System.out.println("\nWriting Employee Payroll Roster to Console\n" + employeePayrollList);

    }
    //UC-2 Ability for Employee Payroll
    //Service to retrieve the Employee
    //Payroll from the Database
    //- Using JDBC read the employee payroll data from the
    //database
    //- Add Start Data to EmployeePayroll Class and ensure
    //backward compatibility
    //- Populate the EmployeePayroll Object
    //- Return the list of Employee Payroll Data
    //- Any Error throw Custom Exceptions
    public List<EmployeePayrollData> readEmployeePayrollDataFromDatabase(IOService ioService){
        if (ioService.equals(IOService.DB_IO)){
            this.employeePayrollList=new EmployeePayrollDBService().readData();
        }
        return this.employeePayrollList;
    }


    public static void main (String[]args){

        System.out.println("---------- Welcome To Employee Payroll Application ----------\n");
        List<EmployeePayrollData> employeePayrollList = null;
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        employeePayrollList=employeePayrollService.readEmployeePayrollDataFromDatabase(IOService.DB_IO);

        employeePayrollList.forEach(System.out::println);

    }

}

