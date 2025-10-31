package SkillBuilders;

import java.io.File;
import java.util.Scanner;


public class MyFilepart1of2 {

	public static void main(String[] args) 
	{
		File textFile;
		Scanner input = new Scanner(System.in);
		String fileName;
		
		//obtain file name from the user
		System.out.println("Enter file name: ");
		fileName = input.nextLine();
				
		// determine if the file exists or not
		textFile = new File(fileName);
		if(textFile.exists())
		{
			System.out.println("File exists");
		}
		else
		{
			System.out.println("File does not exist");
		}
	}

}
