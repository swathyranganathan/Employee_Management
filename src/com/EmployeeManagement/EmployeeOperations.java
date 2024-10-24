package com.EmployeeManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeOperations {
    private Connection con;

    // Constructor receives a DatabaseConnection object
    public EmployeeOperations(jdbc dbConnection) {
        this.con = dbConnection.connect();
        if(this.con == null){
            System.out.println("Error: Cannot proceed");
            System.exit(1);
        }
    }


    public void addEmployee(Employee employee) {
        String query = "INSERT INTO EMPLOYEE(ID, NAME, DEPARTMENT,SALARY) VALUES (?,?,?,?)";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, employee.getId());
            pst.setString(2, employee.getName());
            pst.setString(3, employee.getDepartment());
            pst.setDouble(4, employee.getSalary());
            pst.executeUpdate();
            System.out.println("Employee added Sucessfully!");
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public void showAllEmployee() {
        String query = "SELECT * FROM EMPLOYEE";
        try (PreparedStatement pst =  con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String department = rs.getString("DEPARTMENT");
                double salary = rs.getDouble("SALARY");
                System.out.println("ID: "+ id+", NAME: "+ name+", DEPARTMENT: "+ department+", SALARY: "+salary);
            }
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void showEmployeeById(int id){
        String query = "SELECT * FROM EMPLOYEE WHERE ID = ?";
        try (PreparedStatement pst = con.prepareStatement(query)){
            pst.setInt(1,id);
            ResultSet rs= pst.executeQuery();

            if(rs.next()) {
                String name = rs.getString("NAME");
                String department = rs.getString("DEPARTMENT");
                double salary = rs.getDouble("SALARY");
                System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
            }else {
                System.out.println("Employee not found.");
            }

        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void updateEmployee(Employee employeeUpdate) {
        String query = "UPDATE EMPLOYEE SET NAME=?, DEPARTMENT=?, SALARY=? WHERE ID=?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, employeeUpdate.getName());
            pst.setString(2, employeeUpdate.getDepartment());
            pst.setDouble(3, employeeUpdate.getSalary());
            pst.setInt(4, employeeUpdate.getId());
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee updated successfully. ");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteEmployee(int id){
        String query = "DELETE FROM EMPLOYEE WHERE ID= ?";
        try(PreparedStatement pst= con.prepareStatement(query)){
            pst.setInt(1,id);
            int rowsAffected = pst.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Employee deteled successfully. ");
            }else {
                System.out.println("Employee not found. ");
            }
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
