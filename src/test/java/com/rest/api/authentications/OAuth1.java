package com.rest.api.authentications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




/**
 * link->       https://github.com/rest-assured/rest-assured/wiki/Usage#oauth-1
 * 
 * 
 * @author jey
 * when we are using OAuth1  first of all we need 
 * Scribe 
 * In order to use OAuth 1 and OAuth 2 
 * (for query parameter signing) you need to add Scribe to your classpath 
 * 
 * <dependency>
            <groupId>com.github.scribejava</groupId>
            <artifactId>scribejava-apis</artifactId>
            <version>2.5.3</version>
            <scope>test</scope>
  </dependency>
 * 
 *
 *
 *
 */
public class OAuth1 {
	
	
	@Test
	//here passing all the requiret key, secret, token inside pharenthesis
	//along with your url
	public void twitterApi_OAuth1() {
		RequestSpecification request =
		RestAssured.given()
	                .auth()
	                .oauth("consumerKey", "consumerSecret", "accessToken", "secretToken");
		      
		Response response = request.post("twitter.com  here can be your URL");
				System.out.println(response.statusCode());
	        	System.out.println(response.prettyPrint());
		
	}
	
	
	

}
