package com.studentApp;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;

public class PatchUpdateStudentEmailPojoPayloadTest extends TestBase{
	
	@DisplayName("Update Student with Payload as an object using patch request")
	@Test
	public void patchUpdateStudent() {
		
		Faker fake = new Faker();
		
		StudentPojo student = new StudentPojo();
		student.setEmail(fake.internet().emailAddress());
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/102")
		.then()
		.statusCode(200);
		
		
	}

}
