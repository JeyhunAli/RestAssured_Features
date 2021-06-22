package com.restApi_Get;

/**
 * these two static imports we have to add manually
 * 
 * Rest assured is java DSL(domain specific languaga) library
 * it means there are a lot of classes and methods which we can use to hit the api and then 
 * we can get the responce and we can validate the response 
 * 
 * rest
 * rest api
 * rest assured 
 * 
 * rest api build upon on rest architicure 6 guidliance 
 * rest api is web services 
 * rest assured is is java library to automate the the api 
 * rest is architicture use to read the api for example get, put,delete patch 
 * 
 * rest assured and http clients two java libraries both is automating rest api 
 * rest assured is quite famous
 * rest assured build upon on top of the HTTP clients 
 * internaly rest assured calls http clients 
 * almost both of them have same features and functionlities 
 * but http clients is a little faster comare rest assured 
 * rest assured is more user friendly
 * and has two types BDD AND NON BDD 
 * http clients is NON BDD  
 * in rest assured we use maven project with pom.xml file 
 * there's no page object model in rest assured framework 
 * in rest assured we use given() when()  then() and() keywords thats belongs to the rest assured 
 * its not coming from bdd cucumber 
 * 
 * 
 * git fetch
 * git pull origin master
 * 
 * 
 */
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Get_API_BDD {

	/**
	 * rest assured BDD 
	 * given() 
	 * when() 
	 * then() 
	 * and()
	 * 
	 * rest assured library its providing you with its own bdd keyword method concept
	 */
	@Test
	public void getApiTest_1() {
		
		given().log().all()
		.when().log().all()
		.get("http://ergast.com/api/f1/2021/circuits.json")
		.then().log().all()
		.assertThat()
		.body("MRData.CircuitTable.Circuits.circuitId", hasSize(22));

	}
	
	
	
	@Test
	public void getApiTest_2() {
		
		Response responce = given().log().all().when().log().all().get("http://ergast.com/api/f1/2021/circuits.json");
		responce.getBody();
		int statuscode = responce.getStatusCode();
		assertEquals(statuscode, 200);
		System.out.println("satus code is: " +statuscode);
		System.out.println(responce.prettyPrint());
	}
	
	
	
	@Test
	public void getApiTest_3() {
		
		RestAssured.baseURI = "http://ergast.com";
		given()
		.when()
		.get("/api/f1/2021/circuits.json")
		.then().log().all()
		.assertThat().statusCode(200)
		.and()
		.header("Content-Length", equalTo("4972"))
		.and()
		.contentType(ContentType.JSON);
		

	}
	
	
	@Test
	public void getApiTest_4() {
		
		String paramValue = "test";
		String paramValue2 = "bar";
		String expectedMd5Value = "098f6bcd4621d373cade4e832627b4f6";
		
	      given().log().all()
	      .param("text", paramValue)
	      .param("bar", paramValue2)
	      
	      .when().log().all()
	           .get("http://md5.jsontest.com")
	      .then().log().all()
	      .assertThat()
	      .body("md5", equalTo(expectedMd5Value));
	           
	    System.out.println("paramValue is:: " + paramValue);  
	    System.out.println("second paramValue is:: " + paramValue2);  

	    System.out.println("expectedMd5Value is:: " + expectedMd5Value);
	    
	}   
	           
	
	@DataProvider(name = "getYearData")
	public Object[][] getCircuitYearInfo(){
		return new Object[][] {
			{"2017", 20},
			{"2016", 21},
			{"1966", 9}
		
		};
	
	
	}
	
	@Test(dataProvider="getYearData")
	public void numberOfCircuitsYearTest(String seasonYear, int circuitNumber){
		
		given().log().all()
			.pathParam("raceSeason", seasonYear)
		.when().log().all()
			.get("http://ergast.com/api/f1/{raceSeason}/circuits.json")
		.then().log().all()
			.assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(circuitNumber));
	}
	
	
	
	
	

	
}
	
	
	


