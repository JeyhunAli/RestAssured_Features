package com.restApi_Post;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostApiBDD {

	@Test
	public void tokenPostApi_test_String() {
		
		//first way passing json payload 
		//but not a good way to practice 
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		
		given() 
		       .log().all()
		       .contentType(ContentType.JSON)
		       .body("{\"username\" : \"admin\", \"password\" : \"password123\"}")
		.when()
		       .post("auth") //service url 
		.then()
		        .log().all()
		        .assertThat()
		        .statusCode(200);
	}
	
	
	@Test
	public void tokenPostApi_test_File() {
		
	    // second way creating package under package 
		//  .json file then 
		//as body we are passing new File object and path of the json file 
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		
		given() 
		       .log().all()
		       .contentType(ContentType.JSON)
		       .body(new File("/Users/jey/eclipse-workspace/RestAssured_Features/src/test/java/dataFiles/credentials.json"))
		.when()
		       .post("auth") 
		.then()
		        .log().all()
		        .assertThat()
		        .statusCode(200);
	}
	
	
	
	
	
	

}

