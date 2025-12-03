/*
 
Program: Customer.java          Last Date of this Revision: December 3rd, 2025

Purpose: Represents a bank customer with first and last name.

Author: Adam Eloraby  
School: CHHS
Course: Computer Programming 30 
 
*/

package Mastery;
public class Customer 
{
private String firstName, lastName;
		
	
	/**
	 * constructor
	 * pre: none
	 * post: A Customer object has been created. 
	 * Customer data has been initialized with parameters.
	 */
	public Customer(String fName, String lName) {
		firstName = fName;
		lastName = lName;
	}
	

	/** 
	 * Returns a String that represents the Customer object.
	 * pre: none
	 * post: A string representing the Customer object has 
	 * been returned.
	 */
	public String toString() {
		String custString;

		custString = " " + firstName + " " + lastName + " ";	//changed for Chap 11 Exer 1
	 	return(custString);
	}

	
	
}
