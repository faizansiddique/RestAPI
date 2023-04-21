package com.studentApp;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;

public class LoggingResponseValues extends TestBase{
	
	/*
	 * This test will print out the Response Headers
	 */
	@Test
	public void test001() {
		System.out.println("------------------------1. Printing Response Headers----------------------");
		given()
		.param("programme", "Computer Science")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log()
		.headers()
		.statusCode(200);
		
	}

	/*
	 * This test will print out the Response Status Line
	 */
	@Test
	public void test002() {
		System.out.println("------------------------2. Printing Response Status Line----------------------");
		given()
		.param("programme", "Computer Science")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log()
		.status();
		
	}
	
	/*
	 * This test will print out the Response Body
	 */
	@Test
	public void test003() {
		System.out.println("------------------------3. Printing Response Body----------------------");
		given()
		.param("programme", "Computer Science")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log()
		.body();
		
	}
	
	/*
	 * This test will print out the Response Body incase of an error
	 */
	@Test
	public void test004() {
		System.out.println("------------------------3. Printing Response Body incase of error----------------------");
		given()
		.param("programme", "Computer Science")
		.param("limit", -1)
		.when()
		.get("/list")
		.then()
		.log()
		.ifError();
		
	}

}
