/*

Program: UEmployee.java          Last Date of this Revision: December 3rd, 2025

Purpose: Base class for university employees containing name and salary.

Author: Adam Eloraby  
School: CHHS
Course: Computer Programming 30 

*/

package Mastery;

public class UEmployee {

    private String name;
    private double salary;

    public UEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Get methods 
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Optional: toString for display
    @Override
    public String toString() {
        return "Employee Name: " + name + ", Salary: $" + salary;
    }
}
