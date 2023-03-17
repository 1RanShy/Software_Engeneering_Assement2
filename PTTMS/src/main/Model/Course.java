package main.Model;

import java.util.ArrayList;

//The most important thing is to use the "Id" when "CD" modifying the "requirement"
public class Course {
	/*
	 * The format of the course ID can be four digits, such as 1023
	 * The first digit represents different account categories
	 */
	private String courseID; // The Id number of the course
	private String courseName; // Course name, available or not

	public Course(String courseID, String courseName) {
		this.courseID = courseID;
		this.courseName = courseName;
	}

	public String getCourseID() {
		return courseID;
	}

	public ArrayList<String> toList() {
		// Create a List<String>object
		ArrayList<String> CourseData = new ArrayList<String>();
		// Add the properties of the Staff class to the List
		CourseData.add(this.courseID);
		CourseData.add(this.courseName);
		return CourseData;
	}

	public String toString() {
		return "courseID: " + this.courseID + ", courseName: " + this.courseName;
	}

}
