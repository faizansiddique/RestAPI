package com.filedownload.examples;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.junit.jupiter.api.Test;

public class FileDownloadExample {
	
	@Test
	public void verifyDownloadedFile() {
		
		//Read file
		File inputFile = new File(System.getProperty("user.dir")+File.separator+"geckodriver-v0.29.0-win64.zip");
		
		//length of the input file
		int expectedValue = (int)inputFile.length();
		System.out.println("The size of expected value "+expectedValue+" bytes");
		
		//Read the downloaded file
		//https://github.com/mozilla/geckodriver/releases/download/v0.29.0/geckodriver-v0.29.0-win64.zip
		
		byte[] actualValue = given()
		.when()
		.get("https://github.com/mozilla/geckodriver/releases/download/v0.29.0/geckodriver-v0.29.0-win64.zip")
		.then()
		.extract()
		.asByteArray();
		
		System.out.println("The size of actual value "+actualValue.length+" bytes");
		
		//JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.LENIENT);
	}

}
