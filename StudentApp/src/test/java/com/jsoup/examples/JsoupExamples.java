package com.jsoup.examples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;

public class JsoupExamples {
	
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
	public void getTitle() {

		String response = given().when().get("http://localhost:9999/").asString();

		Document document = Jsoup.parse(response);
		System.out.println("The title of the page is " + document.title().toUpperCase());

	}

	@Test
	public void extractingElementsByTag() {

		String response = given().when().get("http://localhost:9999/").asString();

		Document document = Jsoup.parse(response);
		Elements element = document.getElementsByTag("form");
		
		System.out.println("The number of form elements: "+element.size());
		
		for(Element e : element) {
//			System.out.println(e);
		}
	}
	
	@Test
	public void extractingElementsById() {

		String response = given().when().get("http://localhost:9999/").asString();

		Document document = Jsoup.parse(response);
		Element element = document.getElementById("command");
		
		System.out.println("Extracting form elements: "+element.text());
		
	}
	
	@Test
	public void extractingLinks() {

		String response = given().when().get("http://localhost:9999/").asString();

		Document document = Jsoup.parse(response);
		Elements links = document.select("a[href]");
		
		for(Element e : links) {
			System.out.println("The links are: "+e);
		}
		
	}
	
	@Test
	public void extractingEmailInformation() {
		
		String response = given().sessionId(filter.getSessionId()).when().get("/student/list").asString();

		Document document = Jsoup.parse(response);
		
		Elements element = document.select("table tbody tr td:nth-child(4)");
		
		System.out.println("The total of emails available: "+element.size());
		
		for(Element emailId : element) {
			
			System.out.println("The email id are: "+emailId.text());
		}
		
	}

}
