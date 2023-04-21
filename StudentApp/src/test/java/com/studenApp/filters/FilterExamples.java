package com.studenApp.filters;

import org.apache.commons.io.output.WriterOutputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import static io.restassured.RestAssured.*;

import java.io.PrintStream;
import java.io.StringWriter;

public class FilterExamples {

	public static StringWriter requestWriter;
	public static PrintStream requestCapture;

	public static StringWriter responseWriter;
	public static PrintStream responseCapture;

	public static StringWriter errorWriter;
	public static PrintStream errorCapture;
	
	@BeforeAll
	public static void init() {

		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";

	}

	@BeforeEach
	public void beforeEachTest() {

		requestWriter = new StringWriter();
		requestCapture = new PrintStream(new WriterOutputStream(requestWriter), true);

		responseWriter = new StringWriter();
		responseCapture = new PrintStream(new WriterOutputStream(responseWriter), true);
		
		errorWriter = new StringWriter();
		errorCapture = new PrintStream(new WriterOutputStream(errorWriter), true);

	}

	@Test
	public void getStudent() {

		String response = given()
							.when()
							.get("/list")
							.asString();

		System.out.println(response);
	}
	
	@Test 
	public void getStudentRequestFilter() {

		given()
		.filter(new RequestLoggingFilter(requestCapture))
		.when()
		.get("/list");

		System.err.println(requestWriter.toString());

	 }
	
	@Test 
	public void getStudentResponseFilter() {

		given()
		.filter(new ResponseLoggingFilter(responseCapture))
		.when()
		.get("/list");

		System.err.println(responseWriter.toString());

	 }
	 
	@Test 
	public void getStudentErrorFilter() {

		given()
		.filter(new ErrorLoggingFilter(errorCapture))
		.when()
		.get("/lists");

		System.err.println(errorWriter.toString());

	 }
}
