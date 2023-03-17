package main.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

//Class Director submits requirements, administrator adds content, etc
public class Requirement {
	private String requirementID; // Identify the ID of the requirement
	private String createdDate; // Date on which the requirement was created
	private String classDirectorID; // The staffID of the "ClassDirector" that created the requirement
	private String courseID; // ID number of the course
	/*
	 * 0 represents incomplete
	 * 1 representative has completed (teacher arranged)
	 * -"1" means it needs to be modified (there is no suitable teacher) -->At this time, it should be necessary to modify the courseId
	 */
	private int reqStatus; // Current status of requirement
	private String adminstratorID; // Adding an administrator for PTT
	private String pttID; // The PTT for this course is blank when the Class director is created, and Administrator is required to fill in the following
	private String trainingID; // The "trainingID" assigned to the corresponding PTT

	public Requirement() {
	}

	public Requirement(String requirementID) {
		this.requirementID = requirementID;
	}

	// Constructor called when reading in a requirement file
	public Requirement(String requirementID, String createdDate, String classDirectorId, String courseID,
			String reqStatus) {
		this.requirementID = requirementID;
		this.createdDate = createdDate;
		this.classDirectorID = classDirectorId;
		this.courseID = courseID;
		this.reqStatus = Integer.parseInt(reqStatus);
	}

	// Administrator Settings "Ptt" and "Training"
	public void addPttID(String administratorID, String pttID, String trainingID) {
		this.pttID = pttID;
		this.adminstratorID = administratorID;
		this.trainingID = trainingID;
		this.reqStatus = 1;
	}

	public Requirement(String requirementID, String classDirectorId, String courseID) {
		this.requirementID = requirementID;
		// Created on
		SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy");// Format Date
		Date now = new Date();
		this.createdDate = timeFormat.format(now);
		// "Requirement" creator
		this.classDirectorID = classDirectorId;
		// Course requirements
		this.courseID = courseID;
		// The default initialization state is Unassigned
		this.reqStatus = 0;
		// Arrange the administrator for this requirement
		this.adminstratorID = null;
		// Schedule ptt to this requirement
		this.pttID = null;
		this.trainingID = null;
		this.reqStatus = 0;
	}

	// class director modify requirement
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	// The administrator did not find a suitable Ptt and modified the status of reqStatus to - 1, pending modification
	public void setReqStatustoModify(String adminstratorID) {
		this.adminstratorID = adminstratorID;
		this.reqStatus = -1;
	}

	// Determine whether the current CD is the person who created this requirement
	// public boolean isCdIdEquals(String staffID) {
	// // boolean isEquals = this.classDirectorID.equals(staffID);
	// return this.classDirectorID.equals(staffID);
	// }

	// Modify the requirement information. Only the class director who wrote this can modify the courseID information
	// public void modifyCourseID(String staffID, String courseID) { // The staffId is passed in by the system
	// if (this.classDirectorID.equals(staffID)) { // Returns true
	// this.courseID = courseID;
	// } else {
	// System.out.println("Sorry, you have no permission to modify.");
	// }
	// }

	public String getRequirementID() {
		return this.requirementID;
	}

	public String getCreatedDate() {
		return this.createdDate;
	}

	public String getCourseID() {
		return this.courseID;
	}

	public String getPttID() {
		return this.pttID;
	}

	public String getAdminstratorID() {
		return this.adminstratorID;
	}

	public int getReqStatus() {
		return this.reqStatus;
	}

	public String getClassDirectorID() {
		return this.classDirectorID;
	}

	public void setAdminstratorID(String administrator) {
		this.adminstratorID = administrator;
	}

	public void setTrainingID(String training) {
		this.trainingID = training;
	}

	public void setPTTID(String pttID) {
		this.pttID = pttID;
	}

	public void setReqStatus(int reqStatus) {
		this.reqStatus = reqStatus;
	}

	public ArrayList<String> toList() {
		// Create a List<String> object
		ArrayList<String> requirementData = new ArrayList<String>();
		// Add the properties of the Staff class to the List
		requirementData.add(this.requirementID);
		requirementData.add(this.createdDate);
		requirementData.add(this.classDirectorID);
		requirementData.add(this.courseID);
		requirementData.add(String.valueOf(this.reqStatus));
		if (this.adminstratorID != null) {
			requirementData.add(this.adminstratorID);
		}
		if (this.pttID != null) {
			requirementData.add(this.pttID);
			requirementData.add(this.trainingID);
		}
		return requirementData;
	}

	public String toString() {
		String status = new String();
		if (this.reqStatus == 1) {
			status = "Completed";
		} else if (this.reqStatus == 0) {
			status = "Incompelete";
		} else {
			status = "Need to be modified";
		}
		String tmp = new String();
		tmp = "This is the requirement : " + status + " \n" + "requiredmentID:" + this.getRequirementID()
				+ "   \t \t \t \t \t    "
				+ "classDirectorId:" + this.getClassDirectorID() + "   " + "\n" + "The created time:" + this.getCreatedDate()
				+ "   " + "courseId:" + this.getCourseID() + "   " + "pttId:" + this.getPttID() + "   "
				+ "administrator:" + this.getAdminstratorID() + "   " + "trainingID:" + this.trainingID;
		return tmp;
	}

}