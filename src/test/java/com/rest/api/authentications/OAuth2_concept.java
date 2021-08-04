package com.rest.api.authentications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuth2_concept {
	
	  
		
		@Test
		public void oAuth2APIstest() {
			
			RequestSpecification request =
			RestAssured
			.given()
			   .auth()
			   .oauth2("d6ec184575f9da6fbe99b1f7ccf58b9beeb53044");
			   
			Response resonse = request.post("http://coop.apps.symfonycasts.com/api/2045/toiletseat-down");
			 System.out.println(resonse.getStatusCode());
			System.out.println(resonse.prettyPrint());
		}
		
		
		

	}

	


