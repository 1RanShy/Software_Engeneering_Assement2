package main.View;

import java.util.List;
import java.util.Scanner;
import main.Model.Staff;
import main.Model.Course;

/**
 * Specifically responsible for input verification functions, including
 * authentication during system login (based on input), as well as verification
 * during input in various submenus
 */
public class Validator {
	private Scanner scanner;

	public Validator() {
		this.scanner = new Scanner(System.in);
	}

	public Staff loginValidator(List<Staff> staffList) {
		String regex = "^s[c, p, a][0-9]{3}$";
		// Continue cycling until the correct employee number is entered
		while (true) {
			System.out.println("Please enter your staff number: ");
			// Read a line of input
			String input = this.scanner.nextLine();
			// Judge whether the entered serial number is legal
			if (input.matches(regex)) {
				// Judge whether the input is an employee in the system
				for (Staff staff : staffList) {
					if (staff.getStaffID().equals(input)) {
						return staff;
					}
				}
				System.out.println("No available information in the system!");
			} else {
				System.out.println("Please check and enter a valid number!");
			}
		}
	}

	// Use the second bit of the staffID to determine the identity
	// public char judgeIdentity(String staffID) {
	// char secondChar = staffID.charAt(1);
	// return secondChar;
	// }

	public int optionValidator(int maxNo) {
		// Define a regular expression for validation, with at least one digit
		String regex = "^[0-9]{1,}$";
		// Continue cycling until the correct number is entered
		while (true) {
			System.out.println("Please enter number from 1 to " + maxNo);
			// Read a line of input
			String input = this.scanner.nextLine();
			// Judge whether the entered serial number is legal
			if (input.matches(regex)) {
				// Convert the input serial number to an integer and determine its validity
				int inputToNum = Integer.parseInt(input);
				if (inputToNum >= 1 && inputToNum <= maxNo) {
					return inputToNum;
				} else {
					System.out.println("Out of number range!");
				}
			} else {
				System.out.println("Please check and enter a valid number!");
			}
		}
	}

	// Judge whether the entered course is correct
	public String inputCourseID(List<Course> courseList) {
		String regex = "^c[m, p , c][0-9]{3}$";
		// Continue cycling until the correct employee number is entered
		while (true) {
			System.out.println("Please enter courseID you want to create a new requirement: ");
			// Read a line of input
			String input = this.scanner.nextLine();
			// Judge whether the entered serial number is legal
			if (input.matches(regex)) {
				// Determine whether the input is a course in the system
				for (Course course : courseList) {
					if (course.getCourseID().equals(input)) {
						return input;
					}
				}
				System.out.println("No available information in the system!");
			} else
				System.out.println("Please check and enter a valid number!");
		}
	}
}