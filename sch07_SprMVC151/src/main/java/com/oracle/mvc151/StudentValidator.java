package com.oracle.mvc151;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {
	
	// 검증할 객체의 클래스 타입 정보
	@Override
	public boolean supports(Class<?> student) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(student);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("StudentValidator validate() start..");
		Student student=(Student)target;
		String studentName=student.getName();
		if(studentName==null||studentName.trim().isEmpty()) {
			System.out.println("studentName is Null or empty");
			errors.rejectValue("name", "회원 이름 공백 또는 Null 오류");
		}
		int studentId=student.getId();
		if(studentId==0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "studentId 0으로 입력");
		}
		
	}

}
