package ResponseSpecBuldConcept;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderConcept_2 {



public static RequestSpecification commonResponse() {
	
	RequestSpecBuilder builder = new RequestSpecBuilder();
	
	builder.setBaseUri("https://gorest.co.in");
	builder.setBasePath("/public/v1/users");
	
	RequestSpecification requestSpec = builder.build();
	return requestSpec;
	

	
}

@Test
public void getUsers() {
	
	ValidatableResponse validate =
	
	 given().log().all()
	        .spec(commonResponse())
	 .when().log().all()
	        .get()
	 .then().log().all()
	        .assertThat()
	        .statusCode(200)
	 .and()
	        .contentType(ContentType.JSON)
	        .and()
	        .header("Connection", "keep-alive");
	System.out.println("validateresponse" + "" + validate.header("Connection", "keep-alive"));
	
	
	
}

@Test
public void getUsers_2() {
	
	Response response =
	
	given().log().all()
	       .spec(commonResponse())
	       .queryParam("name", "Sarada Mehrotra")
	       .queryParam("gender", "female")
    .when()
           .get();
           response.getBody();
           response.jsonPath();
           int statuscode = response.statusCode();
           assertEquals(statuscode, 200);
           response.
    then().log().all()
          .assertThat()
          .header("Cache-Control", "max-age=0, private, must-revalidate");
           response.prettyPrint();
           
           
           JsonPath extractor = response.jsonPath();
           
          String currentstatus = extractor.getString("current");
          System.out.println("currentstatus: " + currentstatus);
          
          String name = extractor.get("name");
          System.out.println("name is: " +name);
   
}

     @Test
     public void getUsers_3() {
    	 String jsonvalue = 
    	 given().log().all()
    	 .spec(commonResponse())
    	 .when()
    	 .get()
    	 .then()
    	 .log().all()
    	 .extract().path("pages");
    	 System.out.println("json value is: " +jsonvalue);
    
    	 
    	 
     }

























}
