package test;

import main.Service.NumberGeneration;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerationTest {
	public static void main(String[] args) {
		NumberGeneration numberGeneration = new NumberGeneration();
		List<String> requirementID = new ArrayList<String>();
		requirementID.add("r0001");
		requirementID.add("r0009");
		requirementID.add("r0023");
		requirementID.add("r0304");
		requirementID.add("r0290");
		requirementID.add("r0199");
		String newID = numberGeneration.requirementNum(requirementID);
		System.out.println(newID);
	}
}
