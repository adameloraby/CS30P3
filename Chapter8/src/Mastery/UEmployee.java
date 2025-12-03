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
