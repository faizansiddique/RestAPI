package com.formAuth.example;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FormAuth {
	
	public static SessionFilter filter;
	
	@BeforeAll
	public static void init() {
		
		filter = new SessionFilter();
		
		RestAssured.baseURI = "http://localhost:9999";
		
		given()
		.auth()
		.form("user", "user", new FormAuthConfig("/login", "uname", "pwd"))
		.filter(filter)
		.get();
		
		System.err.println(filter.getSessionId());
	}
	
	@Test
	public void getStudent() {
		
		given()
		.sessionId(filter.getSessionId())
		.get("/student/list")
		.then()
		.log()
		.all();
		
	}
	
	

}
