package com.time.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerificationTime {

	@BeforeAll
	public static void init() {

		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";

	}

	@Test
	public void verifyTime() {

		Long responseTime = given().when().get("/list").time();

		System.out.println(responseTime);
	}

	@Test
	public void verifyTimeInSecond() {

		Long responseTime = given().when().get("/list").timeIn(TimeUnit.SECONDS);

		System.out.println(responseTime);
	}

}
