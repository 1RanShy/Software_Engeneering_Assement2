package test;

import main.View.Validator;

public class ValidatorTest {

	public static void main(String[] args) {
		// 格式2：assert [boolean 表达式] : [错误表达式 （日志）]
		Validator validator = new Validator();
		int maxNo = 40;
		System.out.println(validator.optionValidator(maxNo));
	}
}