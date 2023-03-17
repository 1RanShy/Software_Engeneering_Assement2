package main.Controller;

import java.util.ArrayList;
import java.util.List;

import main.Model.*;
import main.Service.*;
import main.View.Validator;
import main.View.View;

public class Controller {
	private FileIO fileIO; // File Import
	private List<ClassDirector> classDirectorList; // Store the object data of the Class director
	private List<Administrator> administratorList; // Store the object data of the Administrator
	private List<PTT> pttList; // Store the object data of the PTT
	private List<Course> courseList; // Store the object data of the Course
	private List<Training> trainingList; // Store the object data of the Training
	private List<Requirement> requirementList; // Store the object data of the Requirements
	private Staff currentUser; // Current logged-in user
	private Boolean isOpenSession; // Record the open/close state of the session layer, where 1 represents open and
																	// 2 represents closed.

	private Validator validator; // *
	private View view; // *

	// Singleton, lazy loading
	private static Controller controller;

	private Controller() {
		this.fileIO = new FileIO();
		this.classDirectorList = fileIO.createClassDirectorList(); // Read class director file
		this.administratorList = fileIO.createAdministratorList(); // Read administrator file
		this.pttList = fileIO.createPTTList(); // Read ptt file
		this.courseList = fileIO.createCourseList(); // Read course file
		this.trainingList = fileIO.createTrainingList(); // Read training file
		this.requirementList = fileIO.createRequirementList(); // Read requirement file
		this.currentUser = null;
		this.isOpenSession = false;

		this.validator = new Validator(); // *
		this.view = new View();
		// Welcome page
		this.view.welcomeView();
	}

	// get Singleton instance
	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}

	// Current employee role is "Class director"
	public void runClassDirectorSession() {
		this.view.welcomeStaffView(this.currentUser.getStaffName());
		while (this.isOpenSession) {
			// Select function
			int option = this.validator.optionValidator(this.view.classDirectorView());
			switch (option) {
				// Print personal information
				case 1:
					this.view.staffInformationPrint(this.currentUser);// Print current user's information
					break;
				case 2:
					this.createRequirementList();
					break;
				case 3:
					this.modifyRequirement();
					break;
				case 4:
					this.view.logOut();
					this.isOpenSession = false; // Close session
					break;
				case 5:
					// Save data and exit
					this.saveData();
					System.exit(1);
			}
			if (!this.isOpenSession) {
				break;
			}
		}
	}

	// Current employee role is "dministrator"
	public void runAdministratorSession() {
		this.view.welcomeStaffView(this.currentUser.getStaffName());
		while (this.isOpenSession) {
			// Select function
			int option = this.validator.optionValidator(this.view.administratorView());
			switch (option) {
				// Print personal information
				case 1:
					this.view.staffInformationPrint(this.currentUser);// Print current user's information
					break;
				case 2:
					// Allocate requirements to PTT
					this.allocateRequirement();
					break;
				case 3:
					this.view.requirementListPrint(this.requirementList);
					break;
				case 4:
					this.view.logOut();
					this.isOpenSession = false; // Close session
					break;
				case 5:
					// Save data and exit
					this.saveData();
					System.exit(1);
			}
			if (!this.isOpenSession) {
				break;
			}
		}
	}

	// Current staff identity is "PTT"
	public void runPTTSession() {
		this.view.welcomeStaffView(this.currentUser.getStaffName());
		while (this.isOpenSession) {
			// select function
			int option = this.validator.optionValidator(this.view.pttView());
			switch (option) {
				// print personal information
				case 1:
					this.view.staffInformationPrint(this.currentUser);// Print current user's information
					break;
				case 2:
					// Check your requirement and Training
					this.view.requirementInfomationPrint(this.requirementSearch(this.currentUser.getStaffID()));
					break;
				case 3:
					this.view.logOut();
					this.isOpenSession = false; // close session
					break;
				case 4:
					// save data and exit
					this.saveData();
					System.exit(1);
			}
			if (!this.isOpenSession) {
				break;
			}
		}
	}

	// set current logged-in user
	public String logVerify() {
		// Login verification current user
		this.currentUser = this.validator.loginValidator(this.getStaffList());
		this.isOpenSession = true;

		return this.currentUser.getStaffID();
	}

	// get all staffList
	public List<Staff> getStaffList() {
		List<Staff> staffList = new ArrayList<Staff>();
		staffList.addAll(this.classDirectorList);
		staffList.addAll(this.administratorList);
		staffList.addAll(this.pttList);

		return staffList;
	}

	public List<Requirement> getRequirementList() {
		return this.requirementList;
	}

	// class director creates a new requirement
	public void createRequirementList() {
		// display existing requirements
		this.view.requirementListPrint(this.requirementList);
		// display course list
		this.view.courseListPrint(this.courseList);
		// select a course number
		int option = this.validator.optionValidator(this.courseList.size());
		// generate new requirementID
		NumberGeneration numberGneration = new NumberGeneration();
		// generate requirementID list
		List<String> requirementID = new ArrayList<String>();
		for (Requirement requirement : this.requirementList) {
			requirementID.add(requirement.getRequirementID());
		}
		// construct requirement
		Requirement requirement = new Requirement(numberGneration.requirementNum(requirementID),
				this.currentUser.getStaffID(), this.courseList.get(option - 1).getCourseID());
		this.requirementList.add(requirement);
		// Add requirementID to current class director
		this.currentUser.addRequirementID(requirement.getRequirementID());
		System.out.println(String.format("Create %s Requirement successfully!", requirement.getRequirementID()));
		this.view.toContinue();
	}

	// class director modifies their existing requirements
	public void modifyRequirement() {
		boolean flag = true;
		// display existing requirements
		this.view.requirementListPrint(this.requirementList);
		// select an existing requirement or choose to exit
		switch (this.validator.optionValidator(this.view.classDirectorThirdView())) {
			case 1:
				System.out.println("\nPlease choose a requirement number:");
				int requirementOption = this.validator.optionValidator(this.requirementList.size());
				Requirement requirChoose = this.requirementList.get(requirementOption - 1);
				// determine whether the selected requirement is their own and in status -1
				if (!requirChoose.getClassDirectorID().equals(this.currentUser.getStaffID())) {
					System.out.println("You have no right to modify other's requiremnet. Please choose another one.");
				} else if (requirChoose.getReqStatus() != -1) {
					System.out.println("This requirement is in the Non-modifiable status. Please choose another one.");
				} else { // It must be a modifiable requirement
					// Continuously loop to ensure selecting the correct courseID
					while (flag) {
						// Print the course list
						this.view.courseListPrint(courseList);
						// Select a course number
						int courseOption = this.validator.optionValidator(courseList.size());
						Course courseChoose = this.courseList.get(courseOption - 1);
						// Determine whether the selected courseID is the same as the one in the current
						// requirement
						if (courseChoose.getCourseID().equals(requirChoose.getCourseID())) {
							System.out.println("The courseID is the same. Please choose another one.");
						} else {
							// Modification is successful, end the loop
							flag = false;
							requirChoose.setCourseID(courseChoose.getCourseID());
							requirChoose.setReqStatus(0);
							System.out.println("Modified successfully!");
						}
					}
				}
				// Return whether the selected requirement can be modified or not
				this.view.backToParentMenu();
				break;
			case 2:
				this.view.backToParentMenu();
				break;
		}
	}

	// Search for the corresponding requirement by entering a string
	private Requirement requirementSearch(String searchKey) {
		// String[] stringArray = { "apple", "banana", "cherry", "date" };
		// "this.requirementList" needs to query the required " requirement" in
		// "requirement_List"
		// searchKey is "pttID requirementID"
		// Requirement searchResult = new Requirement(); // Query the found requirement
		// result
		Requirement requirement = new Requirement();
		for (int i = 0; i < this.requirementList.size(); i++) {
			if ((this.requirementList.get(i).getPttID() == searchKey)
					|| (this.requirementList.get(i).getRequirementID() == searchKey)
					|| (this.requirementList.get(i).getClassDirectorID() == searchKey)
					|| (this.requirementList.get(i).getCourseID() == searchKey)
					|| (this.requirementList.get(i).getAdminstratorID() == searchKey)) {
				requirement = this.requirementList.get(i);
				break;
			}
			// getTrainingID
			// if (searchKey == this.requirementList.get(i).getT())
			// return this.requirementList.get(i);
			// System.out.println(item);
		}
		return requirement;
	}

	// Search for available "PTT list"
	private List<Staff> searchAvailablePTT(String courseID) {
		List<Staff> pttAvaliableList = new ArrayList<Staff>();
		for (PTT ptt : this.pttList) {
			if (ptt.getIfAvailable() && ptt.getCanTeach().equals(courseID.substring(1, 2))) {
				pttAvaliableList.add((Staff) ptt);
			}
		}
		return pttAvaliableList;
	}

	// Return training with remaining quota
	private List<Training> searchAvailableTraining() {
		List<Training> trainList = new ArrayList<Training>();
		for (Training training : this.trainingList) {
			if (training.getPTTIDList().size() < Training.getMaxPTTSize()) {
				trainList.add(training);
			}
		}
		return trainList;
	}

	// "Administrator" Allocate "pptID" to "requirement" and add "training" for it,
	// pay attention to linkage!
	public void allocateRequirement() {
		// Print the "requirement list"
		this.view.requirementListPrint(this.requirementList);
		int requirementOption = this.validator.optionValidator(this.requirementList.size());
		Requirement requirChoose = this.requirementList.get(requirementOption - 1);
		// Check whether the selected requirement is in status 0, i.e., to be assigned
		if (requirChoose.getReqStatus() != 0) {
			System.out.println("You need to choose a requirement to be allocated. Please choose another one.");
		} else {
			// Search "PTT list" with the same attribute
			List<Staff> pttAvaliableList = this.searchAvailablePTT(requirChoose.getCourseID());
			if (pttAvaliableList.size() != 0) {
				// Print "PTT" information for "administrator"
				this.view.staffListPrint(pttAvaliableList);
				// Choose an appropriate "PTT"
				int pttOption = this.validator.optionValidator(pttAvaliableList.size());
				PTT pttChoose = (PTT) pttAvaliableList.get(pttOption - 1);
				// Print the available "training list"
				List<Training> availableTrainingList = this.searchAvailableTraining();
				// Check whether there are available "trainings"
				if (availableTrainingList.size() == 0) {
					System.out.println("No training is available!");
				} else {
					// Print the available "training list"
					this.view.trainingListPrint(availableTrainingList);
					// Choose a suitable "training ID"
					int trainingOption = this.validator.optionValidator(availableTrainingList.size());
					Training trainingChoose = availableTrainingList.get(trainingOption - 1);
					// Start adding relationship data for each object
					// Add "ptt" to "training"
					trainingChoose.addPTTID(pttChoose.getStaffID());
					// Add "pttID" and "trainigID" to "requirement"
					requirChoose.addPttID(this.currentUser.getStaffID(), pttChoose.getStaffID(), trainingChoose.getTrainingID());
					// Change the status of "requirement" to "Allocated"
					requirChoose.setReqStatus(1);
					// Add "trainingID" and "requirement ID" to "PTT"
					pttChoose.setTrainingID(trainingChoose.getTrainingID());
					pttChoose.addRequirementID(requirChoose.getRequirementID());
					// Add "requirementID" to "administrator"
					this.currentUser.addRequirementID(requirChoose.getRequirementID());
					// Inform "administrator" that "ptt" and "training" have been successfully added
					// to "requirement"
					System.out.println(String.format("Allocate %s(%s) to %s Requirement successfully!",
							pttChoose.getStaffName(), pttChoose.getStaffID(), requirChoose.getRequirementID()));
					this.view.toContinue();
				}
			} else {
				System.out.println("There is no matched teacher in system!");
				// If no matching teachers were found, the reqStatus of the requirement needs to
				// be changed to "-1"
				requirChoose.setReqStatus(-1);
				// Add administratorID to require
				requirChoose.setAdminstratorID(this.currentUser.getStaffID());
				// Add requireID to administrator
				this.currentUser.addRequirementID(requirChoose.getRequirementID());
				// Inform administrator that no suitable teacher was found, and the status of
				// the requirement needs to be changed by class director
				System.out.println(String.format("%s Requirement need to be modified! There are no suitable teachers.",
						requirChoose.getRequirementID()));
				this.view.toContinue();
			}
		}
	}

	// Save data to corresponding file
	public void saveData() {
		this.fileIO.writeFile(this.converToFormatStaffData(this.classDirectorList), FileName.getClassDirector());
		this.fileIO.writeFile(this.converToFormatStaffData(this.administratorList), FileName.getAdministrator());
		this.fileIO.writeFile(this.converToFormatStaffData(this.pttList), FileName.getPTT());
		this.fileIO.writeFile(this.converToFormatRquireData(this.requirementList), FileName.getRequire());
		this.fileIO.writeFile(this.converToFormatCourseData(this.courseList), FileName.getCourse());
		this.fileIO.writeFile(this.converToFormatTrainingData(this.trainingList), FileName.getTraining());
		System.out.println("Data saved");
	}

	// Generic programming, which converts List<T>into List<ArrayList<String>> for
	// easy storage in files
	public <T extends Staff> List<ArrayList<String>> converToFormatStaffData(List<T> staffList) {
		List<ArrayList<String>> list = new ArrayList<>();
		for (Staff staff : staffList) {
			list.add(staff.toList());
		}
		return list;
	}

	public List<ArrayList<String>> converToFormatRquireData(List<Requirement> requirList) {
		List<ArrayList<String>> list = new ArrayList<>();
		for (Requirement requir : requirList) {
			list.add(requir.toList());
		}
		return list;
	}

	public List<ArrayList<String>> converToFormatCourseData(List<Course> courseList) {
		List<ArrayList<String>> list = new ArrayList<>();
		for (Course course : courseList) {
			list.add(course.toList());
		}
		return list;
	}

	public List<ArrayList<String>> converToFormatTrainingData(List<Training> trainingList) {
		List<ArrayList<String>> list = new ArrayList<>();
		for (Training training : trainingList) {
			list.add(training.toList());
		}
		return list;
	}
}