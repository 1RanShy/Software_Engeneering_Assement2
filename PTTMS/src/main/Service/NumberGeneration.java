package main.Service;

import java.util.List;

/*
*Number generation for requirement
*Number example: r0002
*The function finds the maximum number+1 and returns*/
public class NumberGeneration {

	public String requirementNum(List<String> requirementID) {
		int currentNum = Integer.parseInt(requirementID.get(0).substring(1));
		for (String s : requirementID) {
			int temp = Integer.parseInt(s.substring(1));
			if (currentNum < temp) {
				currentNum = temp;
			}
		}
		return "r" + String.format("%04d", currentNum + 1);
	}
}
