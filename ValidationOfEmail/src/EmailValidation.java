import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailValidation {

	public static void main(String[] args) {

		// Create array of employee emails
		String[] emails = new String[10];

		emails[0] = "zero@email.com";
		emails[1] = "one@email.com";
		emails[2] = "two@email.com";
		emails[3] = "three@email.com";
		emails[4] = "four@email.com";
		emails[5] = "five@email.com";
		emails[6] = "six@email.com";
		emails[7] = "seven@email.com";
		emails[8] = "eight@email.com";
		emails[9] = "nine@email.com";

		// Convert array into map for faster look up time
		Map<String, Integer> employeeEmails = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			employeeEmails.put(emails[0], i);
		}

		// Prompt user
		promptUser(employeeEmails);
	}

	protected static void promptUser(Map<String, Integer> _emails) {

		final Scanner input = new Scanner(System.in);
		String userEmail;
		boolean flag = false;

		// Do-While loop allows the user to search multiple times
		do {
			System.out.println("Enter email to search for: ");
			userEmail = input.next();
			input.nextLine();

			// call helper method to validate email and print out the appropriate response
			switch (validateEmail(_emails, userEmail)) {
			case 0:
				System.out.println("Email not found.");
				break;
			case 1:
				System.out.println("Email found.");
				break;
			case 2:
				System.out.println("Invalid email");
				break;

			}

			// Ask user if they would like to search again and set the flag accordingly
			System.out.println("Would you like to search again? (y or n): ");
			String choice = input.next();
			if (choice.equalsIgnoreCase("Y")) {
				flag = true;
			} else if (choice.equalsIgnoreCase("N")) {
				System.out.println("Exiting program");
				flag = false;
			} else {
				System.out.println("Invalid input, exiting program");
				flag = false;
			}
		} while (flag);

		input.close();

	}

	/*
	 * Checks user input against simple regex pattern. [A-Za-z0-9+.]+@(.+) allows
	 * for any number of upper/lower case letters, numbers, and '.' preceding the
	 * '@'. and any type of characters following the '@'. If the users input email
	 * matches the regex pattern then perform a look up and return 1 or 0 if the
	 * email is found. If the users input email does not match the pattern, then
	 * return 2.
	 */
	protected static int validateEmail(Map<String, Integer> _emails, String _email) {
		final String regex = "^[A-Za-z0-9+.]+@(.+)$";
		final Pattern p = Pattern.compile(regex);
		if (p.matcher(_email).matches()) {
			if (_emails.get(_email) == null) {
				return 0;
			} else
				return 1;
		} else {
			return 2;
		}
	}

}
