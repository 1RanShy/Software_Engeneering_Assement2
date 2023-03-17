package test;
import java.util.ArrayList;
import java.util.List;

import main.Model.Course;
import main.Model.Requirement;
import main.Model.Staff;
import main.Model.Training;

//Test toList Function of Course.java, Requirement.java, Staff.java, Training.java
public class ToListTest {
    public static void main(String[] args) {
      // Test Course
      //创建一个对象
      Course course1 = new Course("cp001", "physics");
      Course course2 = new Course("cm001", "physics");
      // 调用toList()方法，得到一个List<String>对象
      ArrayList<String> courseData1 = course1.toList();
      ArrayList<String> courseData2 = course2.toList();
      // 打印List<String>对象的内容
      System.out.println(courseData1);
      System.out.println(courseData2);
      List<ArrayList<String>> data1 = new ArrayList<ArrayList<String>>();
      data1.add(courseData1);
      data1.add(courseData2);
      
      // Test Requirement
      //创建一个对象
      Requirement requirement1 = new Requirement("r0001", "10-02-2023", "sc001", "cm001", "1");
      Requirement requirement2 = new Requirement("r0002", "11-02-2023", "sc002", "cc001", "-1");
      // 调用toList()方法，得到一个List<String>对象
      ArrayList<String> requirementData1 = requirement1.toList();
      ArrayList<String> requirementData2 = requirement2.toList();
      // 打印List<String>对象的内容
      System.out.println(requirementData1);
      System.out.println(requirementData2);
      List<ArrayList<String>> data2 = new ArrayList<ArrayList<String>>();
      data2.add(requirementData1);
      data2.add(requirementData2);      
    
      // Test Staff
      //创建一个Staff对象
        Staff staff1 = new Staff("S001", "Tom", "tom@gmail.com");
        Staff staff2 = new Staff("S002", "Tom", "tom@gmail.com");
        // 调用toList()方法，得到一个List<String>对象
        ArrayList<String> staffData1 = staff1.toList();
        ArrayList<String> staffData2 = staff2.toList();
        // 打印List<String>对象的内容
        System.out.println(staffData1);
        System.out.println(staffData2);
        List<ArrayList<String>> data3 = new ArrayList<ArrayList<String>>();
        data3.add(staffData1);
        data3.add(staffData2);
      
        // Test Training        
        //创建一个对象
        Training Training1 = new Training("t0001", "t1", "10911");
        Training Training2 = new Training("t0002", "Tom", "10911");
        // 调用toList()方法，得到一个List<String>对象
        ArrayList<String> TrainingData1 = Training1.toList();
        ArrayList<String> TrainingData2 = Training2.toList();
        // 打印List<String>对象的内容
        System.out.println(TrainingData1);
        System.out.println(TrainingData2);
        List<ArrayList<String>> data4 = new ArrayList<ArrayList<String>>();
        data4.add(TrainingData1);
        data4.add(TrainingData2);

      }
        

}