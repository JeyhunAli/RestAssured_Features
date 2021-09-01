package com.rest.api.put;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restApi_Post.User;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutAPITest {
	
	//create user with post call 
	//user info
	//update the user info with put caLL 
	//OTHER attrivute should remain same 
	//the attributes which has been changed, need to check
	
	
	
	@Test
	public void updateUserInfo_put_call() {
		
		// 1. Create a POST REQUEST with Payload
		User user = new User("Ali", "Has@gmail.com", "male", "Active");
		
		// Conver this POJO to JSON -- using JACKSON API - ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		String newUser = null;
		
		try {
			newUser = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		System.out.println("postCall new user is: " + newUser);
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		String userId =
		given() 
		      .log().all()
		      .contentType(ContentType.JSON)
		      .header("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af")
		      .body(newUser)
		.when()
		      .post("/public-api/users")
		.then()    
		      .log().all()
		      .assertThat()
		      .contentType(ContentType.JSON)
		      .extract().path("data.id");
		//we have to exctarct it so later i can use for my put call
		//because api doc styiled on this way 
		System.out.println("id" + userId);
		
		
		
		//calling put Api 
		
		user.setEmail("HuseynN@gmail.com");
		
		
		String updatedUserEmail = null;
		
		try {
			updatedUserEmail = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
		
			e.printStackTrace();
		}
		
		given()
		      .log().all()
		      .contentType(ContentType.JSON)
		      .header("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af")
		      .body(updatedUserEmail)
		.when()
		      //appending userid
		      .post("/public-api/users" + userId)
	    .then()
	          .log().all()
	          .assertThat()
	          .contentType(ContentType.JSON)
	    .and()
	          .body("data.email", equalTo(user.getEmail()))
	    .and()
	          .body("data.id", equalTo(userId))
	    .and()
	          .body("data.name", equalTo(user.getName()));
		      
		      
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
