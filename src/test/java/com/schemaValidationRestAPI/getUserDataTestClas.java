package com.schemaValidationRestAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;



public class getUserDataTestClas {
	
	
	
	@Test
	public void userDataSchemaValidation() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		given()
		      .log().all()
		      .headers("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af")
		      .contentType(ContentType.JSON)
		.when()
		      .get("/public-api/users?name=Jey")
		.then()
		       .log().all()
		       .assertThat()
		       .statusCode(200)
               .body(matchesJsonSchemaInClasspath("getUserSChema.json"));
		
	}

}
