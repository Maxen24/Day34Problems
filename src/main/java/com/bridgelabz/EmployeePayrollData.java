package com.bridgelabz;
import java.time.LocalDate;

public class EmployeePayrollData {
    public int employeeId;
    public String employeeName;
    public static double employeeSalary;
    public LocalDate starDate;

    public EmployeePayrollData(Integer id, String name, Double salary, LocalDate date) {

        this.employeeId = id;
        this.employeeName = name;
        this.employeeSalary = salary;
        this.starDate=date;
    }


    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", startDate=" + starDate +
                '}';
    }
}