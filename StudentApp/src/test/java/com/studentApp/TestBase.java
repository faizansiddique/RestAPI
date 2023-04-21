package com.studentApp;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;

public class TestBase {
	
	@BeforeAll
	public static void init() {
		
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";
		
	}

}
