package com.walmart.extractingData;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationExample {

	static RequestSpecBuilder builder;
	static RequestSpecification requestSpec;
	static String APIKEY = "75e3u4sgb2khg673cbv2gjup";

	@BeforeAll
	public static void init() {
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";
		
		builder = new RequestSpecBuilder();
		builder.addParam("format", "json");
		builder.addParam("apiKey", APIKEY);
		builder.addHeader("Accept", "*/*");
		
		requestSpec = builder.build();

	}

	@DisplayName("Get root of the element")
	@Test
	public void getRootElement() {
		
		given()
		.spec(requestSpec)
		.when()
		.get("/taxonomy")
		.then()
		.extract()
		.path("categories");
	
		// System.out.println(rootElement.toString());
	}
	
	@DisplayName("Get all info")
	@Test
	public void getInfo() {
		
		given()
		.spec(requestSpec)
		.when()
		.get("/taxonomy")
		.then()
		.log()
		.all();
		}

}
