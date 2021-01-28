import java.util.Scanner;

public class Calculator {
	
	//private fields should not be accessed by other classes or objects
	private boolean error = false;
	private int num1, num2;
	private String operator;
	private double answer = 0;
	private final Scanner input = new Scanner(System.in);
	
	
	protected void performOperations() {
		
		//get first number and use do while loop for input validation
		System.out.println("Enter first number (must be int): ");
		do {
			if(this.input.hasNextInt()) {
				this.error = false;
				this.num1 = input.nextInt();
			}
			else {
				this.error = true;
				System.out.println("Please input an integer");
				this.input.next();
			}
		} while(this.error);
		
		
		//get second number and use do while loop for input validation
		System.out.println("Enter second number (must be int): ");
		do {	
			if(this.input.hasNextInt()) {
				this.error = false;
				this.num2 = input.nextInt();
			}
			else {
				this.error = true;
				System.out.println("Please input an integer");
				this.input.next();
			}
		} while(this.error);
		
		System.out.println("Enter arithmetic operator (*, +, /, -): ");
		do {
			this.operator = input.next();
			
			//implicitly casting int to double.
			if(this.operator.equals("+")) {
				this.error = false;
				answer = num1 + num2;
			}
			else if(this.operator.equals("-")) {
				this.error = false;
				answer =  num1 - num2;
			}
			else if(this.operator.equals("/")) {
				this.error = false;
				//still performing integer division.
				answer = num1 / num2; 
			}
			else if(this.operator.equals("*")) {
				this.error = false;
				answer = num1 * num2;
			}
			else {
				this.error = true;
				System.out.println("Please input a valid operator: *, +, /, -");
				this.input.next();
			}
		} while(this.error);
		
		System.out.println(num1 + " " + operator + " " + num2 +" = " + answer);
		input.close();
	}

}
