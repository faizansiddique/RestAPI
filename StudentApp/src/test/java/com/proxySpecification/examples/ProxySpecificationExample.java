package com.proxySpecification.examples;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.specification.ProxySpecification;

import static io.restassured.RestAssured.*;

public class ProxySpecificationExample {
	
	
	@BeforeAll
	public static void init() {

		ProxySpecification ps = new ProxySpecification("localhost", 5555, "http");
		
		RestAssured.baseURI = "http://localhost:8085/student";
		RestAssured.proxy(ps);
	}
	
	@Test
	public void sendRequest() {
		
		//ProxySpecification ps = new ProxySpecification("localhost", 5555, "http");
		
		given()
		//.proxy("localhost", 5555)
		//.proxy(ps)
		.when()
		.get("/list")
		.then()
		.log()
		.body();
	}


}
