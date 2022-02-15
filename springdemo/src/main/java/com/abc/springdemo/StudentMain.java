package com.abc.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		Student student = (Student) context.getBean("stu1");
		
		student.displayStudent();
		
		context.close();

	}

}
