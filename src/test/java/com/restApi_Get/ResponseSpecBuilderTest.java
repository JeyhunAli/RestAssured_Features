package com.restApi_Get;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilderTest {

	// t1 t2 t3 t4 ...t100
	// status code = 200 --> 201
	// content type
	// header
	
	/**
	 * lets say we have hundreds of test cases 
	 * all these test cases have some common sides 
	 * lets say for all the get calls status code 
	 * lets say for all the post call content-type 
	 * or specific header should be there 
	 * 
	 * its kind defining one common method and every time calling that function for every test cases 
	 * this is the way we are avoiding writing multiple line of the code again again 
	 * another advantage lets say for status code we are waiting 200 
	 * but tomorrow it changed from 200 to 201 
	 * then we have to go each and every test cases and change them accordingly its time taking process but 
	 * with Response builder class we can define in one class and we can change it only from one place 
	 *  
	 */
	
	
	
	/**
	 * multiple ResponseSpecification creation is also possible 
	 * one for 400 series status code 
	 * one for negative test cases 
	 * one for different headers and authontiocation 
	 */
	
	
	

	ResponseSpecBuilder res = new ResponseSpecBuilder();
	ResponseSpecification resSpec_200_OK = res.
			expectContentType(ContentType.JSON).
			expectStatusCode(200).
			expectHeader("Server", "nginx").
			build();
	
	ResponseSpecification resSpec_400_BAD_REQUEST = res.
			expectStatusCode(400).
			expectHeader("Server", "nginx").
			build();
	
	ResponseSpecification resSpec_401_AUTH_FAIL = res.
			expectStatusCode(401).
			expectHeader("Server", "nginx").
			build();

	@Test
	public void ResponseSpecTest(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		given()
		.header("Authorization", "Bearer _FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k")
		.when()
			.get("/public-api/users")
		.then()
			.assertThat()
				.spec(resSpec_200_OK);
	}
	
	@Test
	public void ResponseSpec_Auth_Fail_Test(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		given()
		.header("Authorization", "Bearer _FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k11111")
		.when()
			.get("/public-api/users")
		.then()
			.assertThat()
				.spec(resSpec_401_AUTH_FAIL);
	}
	

}