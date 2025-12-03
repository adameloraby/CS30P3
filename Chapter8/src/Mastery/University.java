package Mastery;

public class University {

    public static void main(String[] args) {

        Faculty prof1 = new Faculty("John Doe", 105000, "Engineering");
        Faculty prof2 = new Faculty("Mr. Smith", 85000, "Computer Science");
        
        Staff secretary1 = new Staff("Jane Doe", 57000, "Administrative Assistant");
        Staff secretary2 = new Staff("Ms. Smith", 38000, "Underwater Ceramic Technician");

        System.out.println("FACULTY MEMBER:");
        System.out.println(prof1);
        System.out.println(prof2);

        System.out.println("\nSTAFF MEMBER:");
        System.out.println(secretary1);
        System.out.println(secretary2);

    }
}
/* Screen Dump
FACULTY MEMBER:
Employee Name: John Doe, Salary: $105000.0, Department: Engineering
Employee Name: Mr. Smith, Salary: $85000.0, Department: Computer Science

STAFF MEMBER:
Employee Name: Jane Doe, Salary: $57000.0, Job Title: Administrative Assistant
Employee Name: Ms. Smith, Salary: $38000.0, Job Title: Underwater Ceramic Technician
*/

