package main.Model;

import java.util.ArrayList;

/*
 * goodAt - > canTeach
 * 
 */

public class PTT extends Staff {
	private String canTeach; // Currently, it is tentatively decided that a teacher can only teach one type of course, such as mathematics 'm'
	private String trainingID;

	// Constructor
	public PTT(String staffID, String staffName, String email, String canTeach) {
		super(staffID, staffName, email);
		this.canTeach = canTeach;
		this.trainingID = null;
	}

	public void setCanTeach(String canTeach) {
		this.canTeach = canTeach;
	}

	public void setTrainingID(String trainingID) {
		this.trainingID = trainingID;
	}

	public String getCanTeach() {
		return this.canTeach;
	}

	// Assign "requirements" to "PTT"
	public void addRequirementID(String requirementID) {
		if (this.getRequiremeIDList().isEmpty()) {
			this.getRequiremeIDList().add(requirementID);
		} else {
			this.getRequiremeIDList().set(0, requirementID);
		}

	}

	public Boolean getIfAvailable() {
		return (this.trainingID == null);
	}

	public String getTrainingID() {
		return this.trainingID;
	}

	public ArrayList<String> toList() {
		// Create a List<String> object
		ArrayList<String> PTTData = new ArrayList<String>();
		// Add the properties of the "Staff" class to the "List"
		PTTData.add(this.getStaffID());
		PTTData.add(this.getStaffName());
		PTTData.add(this.getEmail());
		PTTData.add(this.canTeach);
		if (this.trainingID != null) {
			PTTData.add(this.getRequiremeIDList().get(0));
			PTTData.add(this.trainingID);
		}
		return PTTData;
	}

	public String toString() {
		String tmp = new String();
		tmp = "This is your information : \n" + "staffID:" + this.getStaffID() + "   "
				+ "staffName:" + this.getStaffName() + "   " + "eamil:" + this.getEmail() + "   "
				+ "canTeach:" + this.getCanTeach();
		return tmp;
	}
}
