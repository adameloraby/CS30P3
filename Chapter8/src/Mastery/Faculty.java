/*

Program: Faculty.java          Last Date of this Revision: December 3rd, 2025

Purpose: Represents faculty employees; inherits UEmployee and stores
         department information.

Author: Adam Eloraby  
School: CHHS
Course: Computer Programming 30 

*/

package Mastery;

public class Faculty extends UEmployee {

    private String department;

    public Faculty(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return super.toString() + ", Department: " + department;
    }
}

