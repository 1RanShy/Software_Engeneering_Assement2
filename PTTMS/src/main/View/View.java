package main.View;

import java.util.List;
import java.util.Scanner;
import main.Model.*;

public class View {

	public void welcomeView() {
		System.out.println("------ Welcome to PTT Management System ------");
	};

	public void staffInformationPrint(Staff staff) {
		this.pageHeader();
		System.out.println(staff);
		System.out.println();
		this.toContinue();
	}

	public void requirementInfomationPrint(Requirement requirement) {
		if (requirement.getRequirementID() != null) {
			this.pageHeader();
			System.out.println(requirement);
			System.out.println();
			this.toContinue();
		} else {
			this.pageHeader();
			System.out.println("You have no requirement");
			System.out.println();
			this.toContinue();
		}
	}

	// print staff list
	public void staffListPrint(List<Staff> staffList) {
		this.pageHeader();
		for (int i = 0; i < staffList.size(); i++) {
			Staff element = staffList.get(i);
			System.out.printf("%d" + ". ", i + 1);
			System.out.println(element + "\n");
		}
		this.toContinue();
	}

	/*
	 * print requirement List
	 * 1. requirement1
	 * 2. requirement2
	 * 3. requirement2
	 */
	// print requirement list
	public void requirementListPrint(List<Requirement> requirementList) {
		this.pageHeader();
		for (int i = 0; i < requirementList.size(); i++) {
			Requirement element = requirementList.get(i);
			System.out.printf("%d" + ". ", i + 1);
			System.out.println(element + "\n");
		}
		this.toContinue();
	}

	// print course list
	public void courseListPrint(List<Course> courseList) {
		this.pageHeader();
		System.out.println("------ Couse Information ------");
		for (int i = 0; i < courseList.size(); i++) {
			Course element = courseList.get(i);
			System.out.printf("%d" + ". ", i + 1);
			System.out.println(element + "\n");
		}
	}

	// print training list
	public void trainingListPrint(List<Training> trainingList) {
		this.pageHeader();
		for (int i = 0; i < trainingList.size(); i++) {
			Training element = trainingList.get(i);
			System.out.printf("%d" + ". ", i + 1);
			System.out.println(element + "\n");
		}
		this.toContinue();
	}

	// Employee welcome interface
	public void welcomeStaffView(String staffID) {
		System.out.println();
		System.out.print(String.format("------ Welcome back, %s ------", staffID));
	}

	// PTT First level menu
	public int pttView() {
		this.pageHeader();
		System.out.println("------ Please enter a number below\n");
		System.out.println("------ 1. Check your own information\n");// Level 2: Call staffInformationPrint
		System.out.println("------ 2. Check your requirement and Training\n");// Level 2: Call requirementInfomationPrint()
		System.out.println("------ 3. Log Out\n");// Level 2: Call logOut()
		System.out.println("------ 4. Exit\n");// Level 2: Call logOut()
		return 4;
	}

	// class director First level menu
	public int classDirectorView() {
		this.pageHeader();
		System.out.println("------ Please enter a number below :\n");
		System.out.println("------ 1. Check your own information\n");// Level 2: CallstaffInformationPrint
		System.out.println("------ 2. Create Requirements\n");// ?Level 2: CallrequirementListPrint()print all requirements
		System.out.println("------ 3. Modify Requirements\n");// Level 2: Call print all requirements
		System.out.println("------ 4. Log Out\n"); // Level 2: Call logOut()
		System.out.println("------ 5. Exit\n");// Level 2: Call logOut()
		return 5;
	}

	public int classDirectorThirdView() {
		System.out.println("------ Please enter a number below :\n");
		System.out.println("------ 1. Choose a requirement number to modify\n");
		System.out.println("------ 2. Return the previous content\n");
		return 2;
	}

	// administrator First level menu
	public int administratorView() {
		this.pageHeader();
		System.out.println("------ Please enter a number below :\n");
		System.out.println("------ 1. Check your own information\n");// Level 2: CallstaffInformationPrint
		System.out.println("------ 2. Allocate requirements to PTT\n"); // Level 2
		System.out.println("------ 3. Check Requirements\n");// Level 2: Call print all requirements
		System.out.println("------ 4. Log Out\n");// Level 2: Call logOut
		System.out.println("------ 5. Exit\n");// Level 2: Call logOut()
		return 5;
	}

	// public void requirementView() {
	// System.out.println();
	// System.out.println("--------------------------------------------");
	// System.out.println("Do you want to create a new requirement?\n");
	// System.out.println();
	// }

	// Logout Prompt
	public void backToParentMenu() {
		System.out.println("Back to Parent Menu!\n");
	}

	// Logout Prompt
	public void logOut() {
		System.out.println("Log out successfully!\n");
	}

	// Secondary Session End
	public void toContinue() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please press enter to continue");
		scanner.nextLine();
		// scanner.close();
	}

	// Print Header
	public void pageHeader() {
		System.out.println();
		System.out.println();
		System.out.println("--------------------------------------------");
	}

}