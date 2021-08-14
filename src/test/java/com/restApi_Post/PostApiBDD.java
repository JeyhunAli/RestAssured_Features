package com.restApi_Post;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.Assert;
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
	
	@Test
	public void tokenPostApi_test_File2() {
		
		//here extract is accesing json value method
		/**
		 * everything is in a chane 
		 * getting baseUrl with RestAssured
		 * then given > content type 
		 * then body > with new file object getting path of the json file 
		 * then when > post call
		 * then extract > path 
		 * 
		 * here i use assertnotnull because 
		 * everytime its generating new id its dynamic 
		 */
	   
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		
		String tokenId = 
		given() 
		       .log().all()
		       .contentType(ContentType.JSON)
		       .body(new File("/Users/jey/eclipse-workspace/RestAssured_Features/src/test/java/dataFiles/credentials.json"))
		.when()
		       .post("auth") 
		.then()
		        .log().all()
		        .extract().path("token");
		System.out.println("tokenId is: " + tokenId);
		Assert.assertNotNull(tokenId , "dynamic token id");
	}
	
	
	
	@Test
	//here passing multiple data from json file 
	//we can have more body matching stuff as well 
	
	public void tokenPostApi_test_File3() {
		
		RestAssured.baseURI = "https://gorest.co.in/";
		
		given()
		       .log().all()
		       .contentType(ContentType.JSON)
		       .header("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af")
		       .body(new File("/Users/jey/eclipse-workspace/RestAssured_Features/src/test/java/dataFiles/user.json"))
		.when()
		       .post("/public-api/users")
		.then()
		       .log().all()
		       .assertThat()
		       .body("code", equalTo(201))
		       .and()
		       .statusCode(200);
		
		       
		
		       
		
	}
	
	
	
	
	

}

