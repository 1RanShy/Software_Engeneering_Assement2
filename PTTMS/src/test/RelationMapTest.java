package test;

import main.Service.FileIO;
import java.util.List;
import main.Model.ClassDirector;

public class RelationMapTest {
	public static void main(String[] agrs) {
		FileIO fileIO = new FileIO();
		List<ClassDirector> cdList = fileIO.createClassDirectorList();
		for (ClassDirector cd : cdList)
			System.out.println(cd);
		// RelationMap rm = new
		// RelationMap(fileIO.readFile(FileName.getClassDirector()));
		// System.out.print(rm.getRelation().get("sc001"));
	}
}
