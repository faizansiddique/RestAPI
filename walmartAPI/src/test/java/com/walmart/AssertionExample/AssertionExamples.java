package com.walmart.AssertionExample;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class AssertionExamples {

	static ValidatableResponse validatableResponse;

	@BeforeAll
	public static void init() {
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";

		validatableResponse = given().param("format", "json").param("apiKey", "75e3u4sgb2khg673cbv2gjup").when()
				.get("/taxonomy").then();
	}

	@DisplayName("Validate name of first element")
	@Test
	public void validateNameOfFirstElement() {

		validatableResponse.body("categories[0].name", equalTo("Personal Care"));
		
	}

	@DisplayName("Validate given name is present in data")
	@Test
	public void validateNamePresentInData() {

		validatableResponse.body("categories.name", hasItem("Shop by Brand"));
		
	}
	
	@DisplayName("Validate given ID is present in data")
	@Test
	public void validateIDPresentInData() {

		validatableResponse.body("categories.id", hasItem("3734780"));
		
	}
	
	@DisplayName("Validate multiple name is present in data")
	@Test
	public void validateMultipleNamePresentInData() {

		validatableResponse.body("categories.name", hasItems("Shop by Brand", "Personal Care", "Toys"));
		
	}


	@DisplayName("Validate name inside Map is present")
	@Test
	public void validateNameInsideMapPresentInData() {

		validatableResponse.body("categories[2].children[1]", hasValue("Gift Ideas"));
		
	}
	
	@DisplayName("Validate HashMap data inside List")
	@Test
	public void getHashMapNameInsideList() {

		validatableResponse.body("categories.findAll{it.name=='Beauty'}", hasItems(hasEntry("name", "Beauty")));
	}

	@DisplayName("Validate Multiple Assertion")
	@Test
	public void getMultipleDataInsideList() {

		validatableResponse
		.body("categories[2].children[1]", hasValue("Gift Ideas"))
		.body("categories.name", hasItems("Shop by Brand", "Personal Care", "Toys"))
		.body("categories.findAll{it.name=='Beauty'}", hasItems(hasEntry("name", "Beauty")))
		.statusCode(200);
	}
	
	@DisplayName("Logical Assertion")
	@Test
	public void validateSizeUsingLogicalExpression() {

		validatableResponse
		.body("categories.size()", greaterThan(30))
		.body("categories.size()", lessThan(40))
		.statusCode(200);
		
	}



}
