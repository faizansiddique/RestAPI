package com.studentApp;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;

public class LoggingRequestValue extends TestBase{
	
	/*
	 * This test will print out the Request Header
	 */
	@Test
	public void test001() {
		System.out.println("------------------------1. Printing Request Header----------------------");
		given()
		.log()
		.headers()
		.when()
		.get("/1")
		.then()
		.statusCode(200);
		
	}
	
	/*
	 * This test will print out the Request Parameters
	 */
	@Test
	public void test002() {
		System.out.println("------------------------2. Printing Request Parameters----------------------");
		given()
		.param("programme", "Computer Science")
		.param("limit", 1)
		.log()
		.params()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
		
	}
	
	/*
	 * This test will print out the Request Body
	 */
	@Test
	public void test003() {
		System.out.println("------------------------3. Printing Request Body----------------------");
		
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
		.log()
		.body()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
		
	}
	
	/*
	 * This test will print out all Request details
	 */
	@Test
	public void test004() {
		System.out.println("------------------------4. Printing all Request details----------------------");
		
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
		.log()
		.all()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
		
	}
	
	/*
	 * This test will print out all Request details if Validation fails
	 */
	@Test
	public void test005() {
		System.out.println("------------------------5. Printing all Request details if Validation fails----------------------");
		
		List<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		courses.add("Phyton");
		
		StudentPojo student = new StudentPojo();
		student.setFirstName("Joniel");
		student.setLastName("Robeli");
		student.setEmail("paris.nicolases@hotmail.com");
		
		student.setProgramme("Computer Science");
		student.setCourses(courses);
				
		given()
		.when()
		.contentType(ContentType.JSON)
		.log()
		.ifValidationFails()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
		
	}

}
