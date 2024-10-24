package com.EmployeeManagement;

import java.sql.Connection;
import java.util.Scanner;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    //constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    //Getters for Employee fields
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
