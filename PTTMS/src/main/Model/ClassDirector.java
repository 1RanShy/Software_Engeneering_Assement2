package main.Model;

// import java.util.ArrayList;
// import java.util.List;

public class ClassDirector extends Staff {

  public ClassDirector(String staffID, String staffName, String email) {
    super(staffID, staffName, email);
  }

	// public String toString() {
	// 	String tmp = new String();
	// 	tmp = "This is your information : \n" + "staffID:" + this.getStaffID() + "   "
	// 				+ "staffName:" + this.getStaffName() + "   " + "eamil:" + this.getEmail();
	// 	return tmp;
	// }

    // Add "RequirementID" to "ClassDirector"
    // public void addRequirementID(String requirementID) {
    //     this.requirementIDList.add(requirementID);
    // }
    

		    // public String toString() {
    // String tmp = new String();
    // if (requirementList.size() == 0) {
    // return "No requirement\n";
    // }

    // for (int j = 0; j < requirementList.size(); j++) {
    // tmp += (String.format("ID: %s", requirementList.get(j).getRequirementId()) +
    // ' ' +
    // String.format("CreatedDate: %s", requirementList.get(j).getCreatedDate()) + '
    // ' +
    // String.format("CourseId: %s", requirementList.get(j).getCourseId()) + ' ' +
    // String.format("PttId: %s", requirementList.get(j).getPttId()) + ' ' +
    // String.format("AdminstratorId: %s",
    // requirementList.get(j).getAdminstratorId())) + ' ';
    // int stauts = requirementList.get(j).getReqStatus();
    // if (stauts == 0)
    // tmp += "Status: Incomplete\n";
    // else if (stauts == 1)
    // tmp += "Status: Complete\n";
    // else
    // tmp += "Status: Need to be modified\n";
    // }

    // return tmp;
    // }

}
