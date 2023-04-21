package com.studentApp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class MyFirstTest extends TestBase{

	
	private void styles() {
		
		RestAssured.given()
					.queryParam("", "")
					.when()
					.get("")
					.then();
		
		RestAssured.given()
					.expect()
					.when();
	}
	
	@DisplayName("Getting Student List from DB")
	@Test
	public void getAllStudentInfo() {
		
		/*
		 * RequestSpecification requestSpec = RestAssured.given();
		 * 
		 * Response response = requestSpec.get("http://localhost:8085/student/list");
		 * response.prettyPrint();
		 * 
		 * ValidatableResponse validatableResponse = response.then();
		 * validatableResponse.statusCode(200);
		 */
		
		/*
		 * RestAssured.given() .when() .get("http://localhost:8085/student/list")
		 * .then() .statusCode(200);
		 */
		
		/*
		 * given() .when() .get("http://localhost:8085/student/list") .prettyPrint();
		 */
		
		given()
		.when()
		.get("/list")
		.then()
		.statusCode(200);

	}
	
	@DisplayName("Getting CS Student from DB")
	@Test
	public void getSingleCSStudentInfo() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("programme", "Computer Science");
		params.put("limit", 1);
		
		/*
		 * Response response = given() .queryParam("programme", "Computer Science")
		 * .queryParam("limit", 1) .get("http://localhost:8085/student/list");
		 * 
		 * response.prettyPrint();
		 */
		
		/*
		 * Response response = given() .queryParams("programme", "Computer Science",
		 * "limit", 1) .get("http://localhost:8085/student/list");
		 * 
		 * response.prettyPrint();
		 */
		
		Response response =
				given()
				.queryParams(params)
				.get("/list");
				
				response.prettyPrint();
				
				
	}
	
	@DisplayName("Passing Path Parameters in Get Response")
	@Test
	public void getTheStudentInfoUsingPathParam() {
		
		Response response =
				given()
				.pathParam("id", 9)
				.when()
				.get("/{id}");
				
				response.prettyPrint();
	}
	
}
