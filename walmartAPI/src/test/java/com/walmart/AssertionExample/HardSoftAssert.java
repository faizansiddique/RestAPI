package com.walmart.AssertionExample;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class HardSoftAssert {
	
	static ValidatableResponse validatableResponse;

	@BeforeAll
	public static void init() {
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";

		validatableResponse = given().param("format", "json").param("apiKey", "75e3u4sgb2khg673cbv2gjup").when()
				.get("/taxonomy").then();
	}

	@DisplayName("Hard Assertexample")
	@Test
	public void hardAssert() {
		
		validatableResponse
		.body("categories[0].id", equalTo("1005862"))
		.body("categories[0].name", equalTo("Personal Care"))
		.body("categories[0].path", equalTo("Personal Care"))
		.statusCode(200);
		
	}
	
	@DisplayName("Soft Assertexample")
	@Test
	public void softAssert() {
		
		validatableResponse
		.body("categories[0].id", equalTo("1005862"),
				"categories[0].name", equalTo("Personal Care"),
				"categories[0].path", equalTo("Personal Care"))
		.statusCode(200);
		
	}
	

}
