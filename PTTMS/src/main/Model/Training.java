package main.Model;

import java.util.ArrayList;
import java.util.List;

public class Training {
	private String trainingID; // The Id of "Training"
	private String trainingName; // name
	/*
	 * A total of five digits
	 * The first digit is from Monday to Friday
	 * The second and third digits are the start time
	 * The fourth and fifth digits are the end time
	 */
	private String trainingTime; // Training time
	private List<String> pttIDList; // PttID participating in the training
	private static int maxPTTSize = 3; // How many people can each class have at most

	public Training(String trainingId, String trainingName, String trainingTime) {
		this.trainingID = trainingId;
		this.trainingName = trainingName;
		this.trainingTime = trainingTime;
		this.pttIDList = new ArrayList<String>(maxPTTSize);
	}

	// public String getTraining(String trainingId) {
	// return trainingId + trainingTime + pttIDList;
	// }

	// Schedule a new PTTID
	public boolean addPTTID(String pttID) {
		// Determine if the maxPTT is exceeded
		if (this.pttIDList.size() < Training.maxPTTSize) {
			this.pttIDList.add(pttID);
			return true;
		} else
			return false;
	}

	// Obtain the pttID scheduled for this training
	public List<String> getPTTIDList() {
		return this.pttIDList;
	}

	public static int getMaxPTTSize() {
		return Training.maxPTTSize;
	}

	public String getTrainingID() {
		return this.trainingID;
	}

	// Remove PTT
	// public void remove(PTT ptt) {
	// int j;
	// for (j = 0; j < i; j++)
	// if (pttList.get(j) == ptt)
	// break;
	// i--;
	// for (; j < i; j++)
	// pttList.set(j, pttList.get(j + 1));
	// }

	// Find a specific PTT
	// public PTT find(String pttId) {
	// for (int j = 0; j < i; j++)
	// if (pttList.get(j).getStaffID().equals(pttId))
	// return pttList.get(j);
	// return null;
	// }

	public ArrayList<String> toList() {
		// Create a List<String> object
		ArrayList<String> trainingData = new ArrayList<String>();
		// Add the properties of the "Staff" class to the List
		trainingData.add(this.trainingID);
		trainingData.add(this.trainingName);
		trainingData.add(this.trainingTime);
		for (String s : this.pttIDList)
			trainingData.add(s);
		return trainingData;
	}

	// Print out the TrainingID and trainingTime and all PTTIDs participating in
	// this training
	public String toString() {
		String list = "";
		for (int i = 0; i < this.pttIDList.size(); i++) {
			list += this.pttIDList.get(i);
		}
		return "TrainingID:" + this.trainingID + "    " + "trainingName:" + this.trainingName + "    "
				+ "trainingTime:" + this.trainingTime + "\n"
				+ "\nAll the PTTS who take this training : " + list + "\nThe remaining PTT number : "
				+ Integer.toString(Training.maxPTTSize - this.pttIDList.size());
	}
}
