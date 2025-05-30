package com.model;

public class Employee {
    private int empno;
    private String name;
    private String doj;
    private String gender;
    private double salary;

    public Employee(int empno, String name, String doj, String gender, double salary) {
        this.empno = empno;
        this.name = name;
        this.doj = doj;
        this.gender = gender;
        this.salary = salary;
    }

    // Getters and Setters
    public int getEmpno() { return empno; }
    public void setEmpno(int empno) { this.empno = empno; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDoj() { return doj; }
    public void setDoj(String doj) { this.doj = doj; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
