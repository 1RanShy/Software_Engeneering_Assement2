package main.Model;

import java.util.ArrayList;
import java.util.List;

public class Staff {
	private String staffID;
	private String staffName;
	private String email;
	private List<String> requirementIDList; // Corresponding demand ID

	// Constructor
	public Staff(String staffID, String staffName, String email) {
		this.staffID = staffID;
		this.staffName = staffName;
		this.email = email;
		this.requirementIDList = new ArrayList<String>();
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStaffID() {
		return this.staffID;
	}

	public String getStaffName() {
		return this.staffName;
	}

	public String getEmail() {
		return this.email;
	}

	public List<String> getRequiremeIDList() {
		return this.requirementIDList;
	}

	public void addRequirementID(String requirementID) {
		this.requirementIDList.add(requirementID);
	}

	public ArrayList<String> toList() {
		// Create a List<String> object
		ArrayList<String> staffData = new ArrayList<String>();
		// Add the properties of the "Staff" class to the "List"
		staffData.add(this.staffID);
		staffData.add(this.staffName);
		staffData.add(this.email);
		for (int i = 0; i < this.requirementIDList.size(); ++i) {
			staffData.add(this.requirementIDList.get(i));
		}

		return staffData;
	}

	public String toString() {
		String tmp = new String();
		tmp = "This is your information : \n" + "staffID:" + this.getStaffID() + "   "
				+ "staffName:" + this.getStaffName() + "   " + "eamil:" + this.getEmail();
		return tmp;
	}
}
