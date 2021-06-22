package com.rest.api.authentications;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class basic_authentications {
	
	
	@Test
	public void basic_Auth() {
		
		given().log().all()
		.auth()
		.preemptive()
		   .basic("admin", "admin")
		  .when().log().all()
		   .get("https://the-internet.herokuapp.com/basic_auth")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
	}
	
	@Test 
	public void OAuth_2_Test() {
		
		given().log().all()
		.auth()
		.oauth2("Bearer a57eebb4185fb6d55a4294c8c0c5b9cde28a86d05cba3e1e0b0c778f02a1a2ca")
		.when().log().all()
		.get("https://gorest.co.in/")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
	}
	
	@Test 
	public void OAuth_2_Test_OAuth_Header() {
		
		RestAssured.baseURI = "https://gorest.co.in/";
		given().log().all()
		.contentType("application/json")
		.header("Authorization", "Bearer a57eebb4185fb6d55a4294c8c0c5b9cde28a86d05cba3e1e0b0c778f02a1a2ca")
		.when()
		.get("/public-api/users")
		.then().log().all()
		.statusCode(200)
		.and()
		.header("Content-Encoding", "gzip");
		
	}
	
	
	
	@Test 
	public void OAuth_2_Test_OAuth_Header_WithQueryParam() {
		
		RestAssured.baseURI = "https://gorest.co.in/";
		
		given()
		      .log().all()
		      .contentType("applivation/json")     
		      .header("Authorization", "Bearer a57eebb4185fb6d55a4294c8c0c5b9cde28a86d05cba3e1e0b0c778f02a1a2ca")
		      .queryParam("name", "Emiliya")
		      .queryParam("gender", "female").
		when()
		      .log().all()
		      .get("/public-api/users").
		then()
		      .log().all()
		      .statusCode(200)
		      .and()
		      .header("Content-Encoding", "gzip");
		       
		      
		 
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
