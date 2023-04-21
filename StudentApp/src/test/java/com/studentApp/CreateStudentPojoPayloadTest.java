package com.studentApp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class CreateStudentPojoPayloadTest extends TestBase{
	
	@DisplayName("Create Student with Payload as an object")
	@Test
	public void createNewStudent() {
		
		Faker fake = new Faker();
		
		List<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		courses.add("Phyton");
		
		StudentPojo student = new StudentPojo();
		student.setFirstName(fake.name().firstName());
		student.setLastName(fake.name().lastName());
		student.setEmail(fake.internet().emailAddress());
		
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
		
		
	}

}
