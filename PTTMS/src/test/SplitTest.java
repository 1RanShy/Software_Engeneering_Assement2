package test;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class SplitTest {
	public static void main(String[] agrs) {
		String s = "sc0001,Marcus Mike, , , ,";
		List<String> parts = new ArrayList<String>(Arrays.asList(s.split(",")));
		System.out.println(parts);
		System.out.println(parts.size());
	}
	
}
