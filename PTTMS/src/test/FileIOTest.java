package test;

import main.Service.FileIO;

public class FileIOTest {
	public static void main(String[] args) {
		FileIO fileIO = new FileIO();
		// System.out.println(fileIO.readFile(FileName.getStaff()));

		System.out.println(fileIO.createClassDirectorList());
		// List<ArrayList<String>> data = fileIO.loadData();
		// for (ArrayList<String> li : data)
		// System.out.println(li);
	}
}
