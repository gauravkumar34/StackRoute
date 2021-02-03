package com.stackroute;

public class Employee {

    private String empName;
    private int empCode;
    private double salary;
//
//    public Employee(String empName, int empCode, double salary) {
//        this.empName = empName;
//        this.empCode = empCode;
//        this.salary = salary;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empCode=" + empCode +
                ", salary=" + salary +
                '}';
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

}
