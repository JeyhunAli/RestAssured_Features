package com.restApi_Post;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import javax.annotation.meta.When;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostApiWith_POJO {

	/**
	 * create a user POST -- URL 
	 * REQUEST JSON BODY 
	 * CONVERTING 
	 * USER JAVA CLASS (POJO)  --> JSON OBJECT ENCAPSULATION --> PRIVATE VARIABLES OR METHODS --> PUBLIC
	 * GETTERS AND SETTERS
	 *  POJO -- PLAIN OLD JAVA OBJECT WHILE CRETAING POJO CLASS
	 * DEFINING class var and methods as private encapsulation concept creating
	 * constructor out of that then getters and setters
	 * 
	 * 
	 * 
		 * POJO TO JSON POJO TO XML POJO TO TEXT POJO TO PDF POJO TO XLS FILE EVERYTHING
		 * IS SERIALIZATION FOR THAT WE HAVE TO USE THIRD PARTY API JACKSON API WE HAVE
		 * TO ADD DEPENDENACY another name of the jsckson is faster.jackson api
		 * 
		 */
	 

	@Test
	public void createUser_With_POJO_TEMPLATE() {

		// creating object of user class and passing parameters
		User user = new User("Jeyhun", "JeyhunALiyev@gmail.com", "male", "active");

		
		// converting java POJO into json -- Serilization
		// to convert we create object of ObjectMapper class
		ObjectMapper mapper = new ObjectMapper();

		String jsonUser = null;
		try {
			jsonUser = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		System.out.println(jsonUser);
        //run 
		
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		given()
		      .log().all()
		      .contentType(ContentType.JSON)
		      .header("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af")
		      //once serialization done then passing here as body 
		      .body(jsonUser)
		.when()
		      .post("/public-api/users")
	    .then()
	          .log().all()
	          .assertThat()
	          .statusCode(200)
	          .contentType(ContentType.JSON)
	          .and()
	          //validating body test
	          .body("data.name", equalTo(user.getName()))
		      .body("data.email", equalTo(user.getEmail()))
		      .body("data.gender", equalTo(user.getGender()));
		      
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}