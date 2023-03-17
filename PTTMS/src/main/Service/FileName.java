package main.Service;

// import java.util.List;
// import java.util.ArrayList;

public class FileName {
	private static final String DATA_DIR = "./data/";
	// private static final String FILENAME_STAFFLIST = DATA_DIR + "staffTable.txt";
	private static final String FILENAME_CLASSDIRECTORLIST = DATA_DIR + "classDirectorTable.txt";
	private static final String FILENAME_ADMINISTRATORLIST = DATA_DIR + "administratorTable.txt";
	private static final String FILENAME_PTTLIST = DATA_DIR + "pttTable.txt";
	private static final String FILENAME_REQUIREMENTSLIST = DATA_DIR + "requirementsTable.txt";
	private static final String FILENAME_COURSELIST = DATA_DIR + "courseTable.txt";
	private static final String FILENAME_TRAININGLIST = DATA_DIR + "trainingTable.txt";

	// public static String getStaff() {
	// return FileName.FILENAME_STAFFLIST;
	// }

	public static String getClassDirector() {
		return FileName.FILENAME_CLASSDIRECTORLIST;
	}

	public static String getAdministrator() {
		return FileName.FILENAME_ADMINISTRATORLIST;
	}

	public static String getPTT() {
		return FileName.FILENAME_PTTLIST;
	}

	public static String getRequire() {
		return FileName.FILENAME_REQUIREMENTSLIST;
	}

	public static String getCourse() {
		return FileName.FILENAME_COURSELIST;
	}

	public static String getTraining() {
		return FileName.FILENAME_TRAININGLIST;
	}

	// public static List<String> getFileNameList() {
	// List<String> fileNameList = new ArrayList<String>();
	// fileNameList.add(FILENAME_CLASSDIRECTORLIST);
	// fileNameList.add(FILENAME_ADMINISTRATORLIST);
	// fileNameList.add(FILENAME_PTTLIST);
	// fileNameList.add(FILENAME_REQUIREMENTSLIST);
	// fileNameList.add(FILENAME_COURSELIST);
	// fileNameList.add(FILENAME_TRAININGLIST);

	// return fileNameList;
	// }
}