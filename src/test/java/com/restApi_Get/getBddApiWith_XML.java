package com.restApi_Get;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getBddApiWith_XML {
	
	
	
	@Test
	public void getUser_Bdd_Test_xml(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		RequestSpecification request = RestAssured.given().log().all();
		request.contentType(ContentType.JSON);
		request.header("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af");
		request.header("Accept", "application/xml");
		
		Response response = request.get("public-api/users?name=John");
		request.log().all();
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println(response.getHeader("Server"));
	}
	
	
	
	@Test
	public void getUser_Bdd_Test_xml_2(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		Response response = 
		
		given()
		      .log().all()
		      .contentType(ContentType.JSON)
		      .header("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af")
		      .header("Accept", "application/xml")
		.when()
		      .log().all()
		      .get("public-api/users?name=John");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		      
		
		
		
		
	}
	
	
	
	

}
