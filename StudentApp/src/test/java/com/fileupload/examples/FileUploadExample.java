package com.fileupload.examples;

import java.io.File;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;



public class FileUploadExample {
	
	@Test
	public void fileUploadExample() {
		
		File inputFile = new File(System.getProperty("user.dir")+File.separator+"06052011116.jpg");
		System.out.println(inputFile.length());
		
		String APIKEY = "25bc77820eac8bb7077fa86b40fb56df77f70ed1";
		String endpoint = "https://sandbox.zamzar.com/v1/jobs";
		
		RestAssured
		.given()
		.auth()
		.basic(APIKEY, "")
		.multiPart("source_file", inputFile)
		.multiPart("target_format", "png")
		.when()
		.post(endpoint)
		.then()
		.log()
		.all();
		
	}
	

}
