/*

Program: Staff.java          Last Date of this Revision: December 3rd, 2025

Purpose: Represents staff employees; inherits UEmployee and stores
         job title information.

Author: Adam Eloraby  
School: CHHS
Course: Computer Programming 30 

*/

package Mastery;

public class Staff extends UEmployee {

    private String jobTitle;

    public Staff(String name, double salary, String jobTitle) {
        super(name, salary);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String toString() {
        return super.toString() + ", Job Title: " + jobTitle;
    }
}

