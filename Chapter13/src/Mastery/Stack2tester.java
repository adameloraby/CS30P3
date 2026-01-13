package SkillBuilders;

public class Stack2tester 
{

	public static void main(String[] args) 
	{
		Stack2 s2 = new Stack2(3);
		s2.push("Blue");
		s2.push("Orange");
		s2.push(4);
		System.out.println("Top is pointing to: " + s2.top());
		System.out.println("Size of the stack " + s2.size());
		s2.pop();
		System.out.println("Top is pointing to: " + s2.top());
		System.out.println("Size of the stack " + s2.size());


	}
}
