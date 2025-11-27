package CresMart;

public class Manager extends Employee
{
	private double yearlySalary;
	
	public Manager(String fn, String ln, double S)
	{
		super(fn, ln);
		yearlySalary = S;
		
	}
	
	public double pay(double weeks)
	{
		double payEarned;
		
		payEarned = yearlySalary / 52 * weeks;
		
		return payEarned;
	}
	
	public String toString()
	{
		return(super.toString()
				+ ", Manager"
				+ "salary" + yearlySalary);
	}
}
