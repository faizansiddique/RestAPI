package com.walmart.extractingData;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonResponseTaxonomyAPI {

	static ValidatableResponse validatableResponse;

	@BeforeAll
	public static void init() {
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";

		validatableResponse = given().param("format", "json").param("apiKey", "75e3u4sgb2khg673cbv2gjup").when()
				.get("/taxonomy").then();
	}

	@DisplayName("Get root of the element")
	@Test
	public void getRootElement() {

		List<String> rootElement = validatableResponse.extract().path("categories");
		// System.out.println(rootElement.toString());
	}

	@DisplayName("Get name of first element")
	@Test
	public void getNameOfFirstElement() {

		String getFisrtName = validatableResponse.extract().path("categories[0].name");
		System.out.println(getFisrtName);
	}

	@DisplayName("Get Children name of first element")
	@Test
	public void getChildrenNameOfFirstElement() {

		String getFisrtChildrenName = validatableResponse.extract().path("categories[0].children[0].name");
		System.out.println(getFisrtChildrenName);
	}

	@DisplayName("Get id of first element")
	@Test
	public void getIdOfFirstElement() {

		String getIdFisrt = validatableResponse.extract().path("categories[0].id");
		System.out.println(getIdFisrt);
	}

	@DisplayName("Get All id of first element")
	@Test
	public void getAllIdOfFirstElement() {

		List<String> getAllIdFisrt = validatableResponse.extract().path("categories.id");
		System.out.println(getAllIdFisrt.toString());
	}

	@DisplayName("Get Size")
	@Test
	public void getSizeOfElements() {

		int getSize = validatableResponse.extract().path("categories.size()");
		System.out.println(getSize);
	}

	@DisplayName("Get children info for name Beauty")
	@Test
	public void getInfoWithName() {

		String info = validatableResponse.extract().path("categories.find{it.name=='Beauty'}.children[6].name");
		System.out.println(info);
	}

}
