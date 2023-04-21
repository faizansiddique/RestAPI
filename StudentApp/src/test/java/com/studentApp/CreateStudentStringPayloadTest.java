package com.studentApp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateStudentStringPayloadTest extends TestBase{
	
	@DisplayName("Create Student with Payload as String")
	@Test
	public void createNewStudent() {
		
		String payLoad = "{\"firstName\":\"test2\",\"lastName\":\"user\",\"email\":\"test2@gmail.com\",\"programme\":\"Computer Science\",\"courses\":[\"Java\",\"C++\"]}";
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(payLoad)
		.post()
		.then()
		.statusCode(201);
		
		
	}

}
