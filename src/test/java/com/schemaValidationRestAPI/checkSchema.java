package com.schemaValidationRestAPI;

/**
 * 
 * @author jey
 * 
 * for schema validation first we need dependancy 
 * <!-- https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator -->
		<dependency>
			<groupId>io.rest-assured</groupId>
			<artifactId>json-schema-validator</artifactId>
			<version>4.3.3</version>
		</dependency>
 *
 *data schema have to match in both the cases 
 * for example data migration process without mathcing is not possible 
 *
 * Schema diagrammatic presentation a structured framework or plan
 * 
 * this schema validation is avaialable in rest Assured but ist not available in http client
 * schema validation is also API contract 
 * 
 * schema should create from response body 
 *
 */

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class checkSchema {
	
	
	@Test 
	public void booking_schema_test() {
		
		// first getting exact schema of json payload 
		// https://www.liquid-technologies.com/online-json-to-schema-converter
		// website helps us to get exact schema of json 
		// then we storing it under source folder 
		//then actual body we storing in data file 
		// passing as body data file path 
		// and as assortion body  .body(matchesJsonSchemaInClasspath("BookingSchema.json"));
		//its giving us data validation point 
		// if i can change any data type from string to integer it will definately throw an error
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		given()   
		          .log().all()
		          .contentType(ContentType.JSON)
		          .body(new File("/Users/jey/eclipse-workspace/RestAssured_"
		          		+ "Features/src/test/java/dataFiles/BookingData.json"))
	    .when()
		          .post("/booking")
		.then()
		          .log().all()
		          .assertThat()
		          .statusCode(200)
	    .and()
		          .body(matchesJsonSchemaInClasspath("BookingSchema.json"));
		
		
		
		
	}

}
