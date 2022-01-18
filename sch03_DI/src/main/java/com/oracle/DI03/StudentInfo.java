package com.oracle.DI03;

public class StudentInfo {
	
	private Student student;
	
	public StudentInfo(Student student) {
		this.student=student;
		System.out.println("StudentInfo 생성자...");
	}
	
	public void getStudentInfo() {
		if(student!=null) {
			System.out.println("이름 : "+student.getName());
			System.out.println("이름 : "+student.getAge());
			System.out.println("이름 : "+student.getGradeNum());
			System.out.println("이름 : "+student.getClassNum());
			System.out.println("======================");
		}
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
