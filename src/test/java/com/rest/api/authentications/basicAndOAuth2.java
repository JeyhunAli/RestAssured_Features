package com.rest.api.authentications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class basicAndOAuth2 {
	
	/**
	 * we have two options using .auth() .oauth2 method 
	 * or 
	 * using header method just like postman and passing Authorization and Bearer token
	 * then validatinng
	 * 
	 * 
	 * 
	 * 
	 * basic OAuth
	 * passing username and password 
	 * 
	 * OAuth1 
	 * consumer key, consumer secret 
	 * Access token, secret token 
	 * 
	 * OAuth2
	 * if you have direct access token just pass it and call your api
	 * but if you dont have it then if you are in postman you have to click get new token 
	 * then there are certain information you have to provide 
	 * token name, grand type, client id client secret 
	 * these information provide u by developers 
	 * 
	 * 
	 */
	
	@Test
	public void basic_Auth() {
		//basic authentication in rest assured passing username and password 
		//using .auth()  and .preemptive() method 
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
		
		//same in postman 
		//if u pass token through header u need Bearer keyword 
		// if u pass through Authentication OAuth2 no need to
		
		
		//using .auth() .oauth2 method 
		//if you are using 
		//1 with header: append your token with Berare Token 
		//2. with OAuth2() method: no need to add Bearer just pass the value 
		/**
		 * sometimes while using .auth() and .oauth2 method if we passing Bearer along with token it might not work 
		 * because internally it calling bearer 
		 * if both not working we can pass method as header then Bearer and token all together
		 */
		given().log().all()
		.auth()
		//.oauth2("a57eebb4185fb6d55a4294c8c0c5b9cde28a86d05cba3e1e0b0c778f02a1a2ca")
		.oauth2("Bearer a57eebb4185fb6d55a4294c8c0c5b9cde28a86d05cba3e1e0b0c778f02a1a2ca")
		.when().log().all()
		.get("https://gorest.co.in/")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
	}
	
	@Test 
	public void OAuth_2_Test_OAuth_Header() {
		//using header method just like postman and passing Authorization and Bearer token
		//then validatinng
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
		/**
		 * we can pass query parameters in two ways 
		 * 1) .queryParam method
		 * 2) .param method 
		 * but more clearness for query parameters better use .queryParam method
		 */
		
		RestAssured.baseURI = "https://gorest.co.in/";
		
		given()
		      .log().all()
		      .contentType("applivation/json")     
		      .header("Authorization", "Bearer a57eebb4185fb6d55a4294c8c0c5b9cde28a86d05cba3e1e0b0c778f02a1a2ca")
		      .queryParam("name", "Emiliya")
		      .queryParam("gender", "female")
		      .param("status", "active").
		when()
		      .log().all()
		      .get("/public-api/users").
		then()
		      .log().all()
		      .statusCode(200)
		      .and()
		      .header("Content-Encoding", "gzip");
		
	}
	
	@Test
	public void OAuth_2_Test_OAuth_Header_WithQueryParam_2() {
		
		//its better to have content type and header validation after then() method 
		
		RestAssured.baseURI = "https://gorest.co.in/";
		given()
		       .log().all()
		       .contentType("application/json")
		       .header("Authorization", "Bearer a57eebb4185fb6d55a4294c8c0c5b9cde28a86d05cba3e1e0b0c778f02a1a2ca")
		       .queryParam("name", "Opalinaa Gandhi")
			   .queryParam("gender", "female")
			   .param("status", "active").
	    when()
			      .log().all()
			      .get("/public-api/users").
	    then()
			      .log().all()
			      .statusCode(200).
	    and()
	              .contentType("application/json")
	              .header("connection", equalTo("keep-alive"))
	              .header("Content-Encoding", equalTo("gzip"));
			      
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
