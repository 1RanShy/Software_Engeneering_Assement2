package main.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
// import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import main.Model.*;

import java.util.ArrayList;

public class FileIO {
	public FileIO() {
	}

	// Create class director list
	public List<ClassDirector> createClassDirectorList() {
		// Read ClassDirector file data to data
		List<ArrayList<String>> data = this.readFile(FileName.getClassDirector());
		// Create classDrectorList
		List<ClassDirector> classDirectorList = new ArrayList<ClassDirector>();
		// Constructive Class Director
		for (List<String> li : data) {
			ClassDirector cd = new ClassDirector(li.get(0), li.get(1), li.get(2));
			for (int i = 3; i < li.size(); ++i) {
				cd.addRequirementID(li.get(i));
			}
			classDirectorList.add(cd);
		}
		return classDirectorList;
	}

	// Create administrator list
	public List<Administrator> createAdministratorList() {
		// Read Administrator file data to data
		List<ArrayList<String>> data = this.readFile(FileName.getAdministrator());
		// Create administratorList
		List<Administrator> administratorList = new ArrayList<Administrator>();
		// Constructive Administrator
		for (List<String> li : data) {
			Administrator administrator = new Administrator(li.get(0), li.get(1), li.get(2));
			for (int i = 3; i < li.size(); ++i) {
				administrator.addRequirementID(li.get(i));
			}
			administratorList.add(administrator);
		}
		return administratorList;
	}

	// Create ppt list
	public List<PTT> createPTTList() {
		// Read PTT file data to data
		List<ArrayList<String>> data = this.readFile(FileName.getPTT());
		// Create PTT
		List<PTT> pttList = new ArrayList<PTT>();
		// Constructive PTT
		for (List<String> li : data) {
			PTT ptt = new PTT(li.get(0), li.get(1), li.get(2), li.get(3));
			if (li.size() > 4) {
				ptt.addRequirementID(li.get(4));
				ptt.setTrainingID(li.get(5));
			}
			pttList.add(ptt);
		}
		return pttList;
	}

	// Create course list
	public List<Course> createCourseList() {
		// readCourse file data to  data
		List<ArrayList<String>> data = this.readFile(FileName.getCourse());
		// Create Course
		List<Course> courseList = new ArrayList<Course>();
		// Constructive Course
		for (List<String> li : data) {
			Course course = new Course(li.get(0), li.get(1));
			courseList.add(course);
		}
		return courseList;
	}

	// Createtraining list
	public List<Training> createTrainingList() {
		// readTraining file data to  data
		List<ArrayList<String>> data = this.readFile(FileName.getTraining());
		// Create Training
		List<Training> trainingList = new ArrayList<Training>();
		// Constructive Training
		for (List<String> li : data) {
			Training training = new Training(li.get(0), li.get(1), li.get(2));
			for (int i = 3; i < li.size(); ++i) {
				training.addPTTID(li.get(i));
			}
			trainingList.add(training);
		}
		return trainingList;
	}

	// Create requirement list
	public List<Requirement> createRequirementList() {
		// readClassDirector file data to  data
		List<ArrayList<String>> data = this.readFile(FileName.getRequire());
		// Create requirementList
		List<Requirement> requirementList = new ArrayList<Requirement>();
		// Constructive Requirement
		for (List<String> li : data) {
			Requirement rq = new Requirement(li.get(0), li.get(1), li.get(2), li.get(3), li.get(4));
			if (li.size() == 6) {
				rq.setReqStatus(-1);
				rq.setAdminstratorID(li.get(5));
			} else if (li.size() > 6) {
				rq.setAdminstratorID(li.get(5));
				rq.setPTTID(li.get(6));
				rq.setTrainingID(li.get(7));
			}
			requirementList.add(rq);
		}
		return requirementList;
	}

	// Reading a file into a two-dimensional list
	private List<ArrayList<String>> readFile(String fileName) {
		// Create a temporary ArrayList object to store the read data
		List<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		try {
			//Create a FileReader object, give the name of the file to be read
			FileReader fileReader = new FileReader(fileName);
			// Create a BufferedReader object and input it as a character stream to prevent garbled code
			BufferedReader reader = new BufferedReader(fileReader);
			// Skip the first line, the first line of the data file is convenient, and the field name is marked
			reader.readLine();
			String tmpStr = null;
			// Loop through each line of the file
			while (null != (tmpStr = reader.readLine())) {
				// Read the contents of a row
				String[] line = tmpStr.split(",");
				// Use the split method, using "," as the separator, to split into a string array and store it in ArrayList
				ArrayList<String> parts = new ArrayList<String>();
				for (String s : line) {
					parts.add(s);
				}
				data.add(parts);
			}
			// Close file stream
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	// public List<ArrayList<String>> convertStaffListToList(List<Staff> staffList)
	// {
	// List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	// for (Staff staff : staffList) {
	// list.add(staff.toList());
	// }
	// return list;
	// }

	public List<ArrayList<String>> convertCourseListToList(List<Course> courseList) {
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		for (Course course : courseList) {
			list.add(course.toList());
		}
		return list;
	}

	public List<ArrayList<String>> convertRequirementListToList(List<Requirement> requirementList) {
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		for (Requirement requirement : requirementList) {
			list.add(requirement.toList());
		}
		return list;
	}

	public List<ArrayList<String>> convertTrainingListToList(List<Training> trainingList) {
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		for (Training training : trainingList) {
			list.add(training.toList());
		}
		return list;
	}

	// Write data to a txt file
	public void writeFile(List<ArrayList<String>> data, String targetFile) {
		try {
			// Create a BufferedReader object to read the file content
			BufferedReader reader = new BufferedReader(new FileReader(targetFile));
			// Read the first line of the file and save it in a variable
			String firstLine = reader.readLine();
			// Close the BufferedReader object
			reader.close();

			// Create a FileWriter object, specify the file name to write
			FileWriter fileWriter = new FileWriter(targetFile, false);
			// Create a BufferedWriter object to buffer the output stream and improve write efficiency
			BufferedWriter writer = new BufferedWriter(fileWriter);

			// Write the first line back into the file and wrap it
			writer.write(firstLine + "\n");

			// Traverse each ArrayList<String>object in the data to represent a row of data
			for (ArrayList<String> row : data) {
				// Create a StringBuilder object to splice strings
				StringBuilder line = new StringBuilder();
				// Traverse each string in row to represent a field value
				for (String field : row) {
					// Add field values to the line, separated by commas
					line.append(field).append(",");
				}
				// Remove the last comma
				line.deleteCharAt(line.length() - 1);
				// Convert line to a string, write it to a file, and wrap it
				writer.write(line + "\n");
			}

			writer.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}