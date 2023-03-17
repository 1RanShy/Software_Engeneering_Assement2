package test;

import main.View.View;
import main.Model.ClassDirector;

public class ViewTest {

	public static void main(String[] args) throws Exception {
		View Test = new View();
		ClassDirector classDirector = new ClassDirector("sc001", "Mike", "theshy1011@163.com");
		Test.staffInformationPrint(classDirector);
		// char staffID = ' ';
		// staffID = Test.Judge_Identity("sc001");
		// Test.welcomeView();
		// staffID = Test.Judge_Identity("sp001");
		// if (staffID == 'p')
		// Test.pttView();
		// staffID = Test.Judge_Identity("sc001");
		// if (staffID == 'c')
		// Test.classDirectorView();
		// staffID = Test.Judge_Identity("sa001");
		// if (staffID == 'a')
		// Test.administratorView();

		// PTT ptt = new PTT("sc001", "Mike", "theshy1011@163.com", "Math");
		// Test.staffInformationPrint(ptt);

		// Requirement rq1 = new Requirement("SC001", "Math");
		// Test.requirementInfomationPrint(rq1);
	}
}
