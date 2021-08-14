package com.rest.api.put;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restApi_Post.User;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutCallUpdate {

	// Create a user with post call
	// user info
	// update the info with put call
	// 1. other attributes should remain same
	// 2. the attribute which has been changed, need to check

	@Test
	public void update_User_PUT_API_Test() {
		// 1. Create a POST REQUEST with Payload
		User user = new User("Hassan", "Hadann@gmail.com", "male", "Active");

		// Conver this POJO to JSON -- using JACKSON API - ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		String userJson = null;

		try {
			userJson = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("POST CALL JSON is: "+ userJson );
		
		//write POST CALL:
		RestAssured.baseURI = "https://gorest.co.in";
		
		String userId =
		    
		given().log().all()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af")
			.body(userJson).
		when().log().all()
			.post("/public-api/users").
		then().log().all()
			.assertThat()
				.contentType(ContentType.JSON)
				.extract().path("id");
		
		System.out.println("user id is:::>"+ userId);
		
		
		//Call the PUT API:
		
		user.setEmail("hasann@gmail.com");
//		user.setAddress("Hinjewadi, Pune");
//		user.setPhone("+91-900000000");
		
		// Conver this POJO to JSON -- using JACKSON API - ObjectMapper
		String updatedUserJson = null;

				try {
					updatedUserJson = mapper.writeValueAsString(user);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
		
		given().log().all()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af")
			.body(updatedUserJson).
		when().log().all()
			.put("public-api/users/"+userId).
		then().log().all()
			.assertThat()
				.contentType(ContentType.JSON)
				.and()
					.body("data.email", equalTo(user.getEmail()))
				.and()
					.body("data.id", equalTo(userId))
				.and()
					.body("data.name", equalTo(user.getName()));

		
		//post--> get
		//post--> put --> get
		//its always good practice to do get call after all post put calls 
		// just to verify the data is exact and matching with actual data 
		
		
		
	}

}