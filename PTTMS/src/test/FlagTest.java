package test;

public class FlagTest {
	public static Boolean swap(Boolean flag) {
		flag = !flag;
		return flag;
	}
	public static void main(String[] args) {
		Boolean flag = true;
		flag = swap(flag);
		System.out.println(flag);
	}
}