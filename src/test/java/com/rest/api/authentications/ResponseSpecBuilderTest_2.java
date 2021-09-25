package com.rest.api.authentications;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilderTest_2 {
	
	
	/**
	 * lets say we have hundreds of test cases 
	 * all these test cases have some common sides 
	 * lets say for all the get calls status code 
	 * lets say for all the post call content-type 
	 * or specific header should be there 
	 * 
	 * its kind defining one common method and every time calling that function for every test cases 
	 * this is the way we are avoiding writing multiple line of the code again and again 
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
	ResponseSpecification spec = res
			.expectContentType(ContentType.JSON)
			.expectHeader("Server", "nginx")
			.expectHeader("Connection", "keep-alive")
			.expectStatusCode(200)
			.build();
	
	
	ResponseSpecification spec_Bad_request = res
			.expectContentType(ContentType.JSON)
			.expectHeader("Server", "nginx")
			.expectHeader("Connection", "keep-alive")
			.expectStatusCode(400)
			.build();
	
	
	
	ResponseSpecification spec_401_AuthFailed_request = res
			.expectContentType(ContentType.JSON)
			.expectHeader("Server", "nginx")
			.expectHeader("Connection", "keep-alive")
			.expectStatusCode(401)
			.build();
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void responseSpecTest() {
		RestAssured.baseURI = "https://gorest.co.in";
		  given() 
		          .log().all()
		          .header("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af")
		 .when()
		          .get("/public-api/users")
		 .then()
		          .log().all()
		          .assertThat()
		          .spec(spec);
		  
	}
	
	
	@Test
	public void responseSpec_Bad_Request_Test() {
		RestAssured.baseURI = "https://gorest.co.in";
		  given() 
		          .log().all()
		          .header("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af1")
		 .when()
		          .get("/public-api/users")
		 .then()
		          .log().all()
		          .assertThat()
		          .spec(spec_Bad_request);
		  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
