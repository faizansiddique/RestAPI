package com.studentApp;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;

public class DeleteStudent extends TestBase{
	
	@DisplayName("Delete Student from DB")
	@Test
	public void deleteStudent() {
		
		given()
		.when()
		.delete("/102")
		.then()
		.statusCode(204);
		
		
	}

}
