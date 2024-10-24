package com.EmployeeManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        jdbc dbConnection = new jdbc();
        EmployeeOperations emp = new EmployeeOperations(dbConnection);


        while (true) {
            System.out.println(" ");
            System.out.println("1. Add Employee");
            System.out.println("2. Show all Employee");
            System.out.println("3. Show Employee based on ID");
            System.out.println("4. Update the Employee");
            System.out.println("5. Delete the Employee");
            System.out.println("6.Exit");
            System.out.println("Enter your choice: ");

            int input = sc.nextInt();
            sc.nextLine();

            switch (input){
                case 1:
                    System.out.println("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Employee Department: ");
                    String department = sc.nextLine();
                    System.out.println("Enter Employee Salary: ");
                    double salary= sc.nextDouble();
                    Employee employee=new Employee(id,name,department,salary);
                    emp.addEmployee(employee);
                    break;
                case 2:
                    emp.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter Employee ID: ");
                    id =sc.nextInt();
                    emp.showEmployeeById(id);
                    break;
                case 4:
                    System.out.println("Enter Employee ID to update: ");
                    id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Employee Name to Modify: ");
                    name=sc.nextLine();
                    System.out.println("Enter Employee Department to Modify: ");
                    department= sc.nextLine();
                    System.out.println("Enter Employee Salary to Modify: ");
                    salary=sc.nextDouble();
                    Employee employeeUpdate=new Employee(id,name,department,salary);
                    emp.updateEmployee(employeeUpdate);
                    break;
                case 5:
                    System.out.println("Enter Employee ID to Delete: ");
                    id = sc.nextInt();
                    emp.deleteEmployee(id);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}