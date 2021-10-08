package com.rest.api.authentications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.omg.CORBA.Request;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenereateTokenAtTheRunTime {
	 
	 /**
	  * passing grant Type, client id, client secret, token name
	  * to pass all these stuff we need method 
	  * and they are not paramaters or headers 
	  * they are in the form of 
	  * <<<<< formPara m>>>>>>>
	  */
	 
	 @Test
	 //generating access token then getting access token via jsonPath
	 public void generateToken_OAuth_2(){
		 RequestSpecification request =
		 RestAssured.given()
		           .formParam("client id", "TestingConcept")
		           .formParam("client secret", "d36df0355a4d350e469cef450df0f414")
		           .formParam("grant_type", "client_credentials");
		 
		Response response = request.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		  
		//accesing json using response.jsonPath
		//this way is handy because once we get json 
		// access token id then we can use it any call 
		//avoiding hard coding 
		String accessToken = response.jsonPath().getString("access_token");
		String tokentype = response.jsonPath().getString("token_type");
		System.out.println("tokenId "+accessToken);
		System.out.println("token_type is ::: "+ tokentype);
		
		
	
		//chicken feed 
		RequestSpecification requestt =
				RestAssured
				.given()
				   .auth()
				   //.oauth2("d6ec184575f9da6fbe99b1f7ccf58b9beeb53044");
		.oauth2(accessToken);
				   
				Response resonse = requestt.post("http://coop.apps.symfonycasts.com/api/2045/toiletseat-down");
				 System.out.println(resonse.getStatusCode());
				System.out.println(resonse.prettyPrint());
	 
	
	
		}
		
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	


