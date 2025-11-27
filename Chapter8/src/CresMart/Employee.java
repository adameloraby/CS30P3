package CresMart;

public abstract class Employee 
{
	private String firstName, lastName;
	
	//Constructor Method
	
	public Employee(String fn, String ln) 
	{
		firstName = fn;
		lastName= ln;
	}
	
	public String toString()
	{
		return(firstName + " " + lastName);
	}
	
	abstract double pay(double period);
}
