package com.restApi_Get;

/**
 * these two static imports we have to add manually
 * under these imports we have a lot of libraries
 * 
 * import static io.restassured.RestAssured.*;
 * import static org.hamcrest.Matchers.*;
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
 * rest assured is used to automate the the api 
 * rest is architicture use to read the api for example get, put,delete patch 
 * 
 * rest assured and http clients two java libraries both is automating rest api 
 * 
 * rest assured is quite famous
 * rest assured build upon on top of the HTTP clients 
 * internaly rest assured calls http clients 
 * almost both of them have same features and functionlities 
 * but http clients is a little faster compare rest assured 
 * rest assured is more user friendly
 * and has two types BDD AND NON BDD 
 * http clients is complately NON BDD  
 * in rest assured we use maven project with pom.xml file 
 * in rest assured bdd is not cucumber its rest assured based bdd framework 
 * just because we are going to use given() when()  then() and()
 * and it build inside rest assured 
 * there's no page object model in rest assured framework 
 * in rest assured we use given() when()  then() and() keywords thats belongs to the rest assured 
 * its not coming from bdd cucumber 
 * 
 * 
 * 
 * git fetch
 * git pull origin master
 * 
 * 
 * src main java is always used to store generics wrappers utilites pages generic functions 
 * src test java is always for test 
 * 
 * rest assured and testNG dependenceis is more important first time when starting wrting rest assured features 
 * 
 * 
 * 
 */
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Get_API_BDD {

	/**
	 * rest assured BDD given() when() then() and()
	 * 
	 * rest assured library its providing you with its own bdd keyword method
	 * concept
	 */
	@Test
	public void getApiTest_1() {

		given().log().all().
		when().log().all().
		     get("http://ergast.com/api/f1/2021/circuits.json").
		then().log().all()
		     .assertThat().
			 body("MRData.CircuitTable.Circuits.circuitId", hasSize(22));

	}

	@Test
	public void getApiTest_2() {

		Response responce = 
			given().log().all().
			when().log().all().
				get("http://ergast.com/api/f1/2021/circuits.json");
		responce.getBody();
		int statuscode = responce.getStatusCode();
		assertEquals(statuscode, 200);
		System.out.println(responce.prettyPrint());
		System.out.println("satus code is: " + statuscode);
		System.out.println(responce.prettyPrint());
		
	}

	@Test
	public void getApiTest_3() {

		RestAssured.baseURI = "http://ergast.com";
		given().
		when().
		     get("/api/f1/2021/circuits.json").
		then().log().all().
		     assertThat().
		     statusCode(200).
		and().
		     header("Content-Length", equalTo("4972")).
		and().
		     contentType(ContentType.JSON);

	}

	@Test
	//passing query param with param method 
	//along with url also possible but better do it like this
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

	
	/**
	 * data provider with the name
	 * @return type of data provider is two dimensial array 
	 * creating method 
	 * storing those data into two D array
	 */
	@DataProvider(name = "getYearData")
	public Object[][] getCircuitYearInfo() {
		return new Object[][] { 
			{ "2017", 20 }, 
			{ "2016", 21 }, 
			{ "1966", 9 }
            };

	}

	/**
	 * calling data provider with the name 
	 * @param seasonYear
	 * @param circuitNumber
	 */
	@Test(dataProvider = "getYearData")
	public void numberOfCircuitsYearTest(String seasonYear, int circuitNumber) {

		given().log().all().
		        pathParam("raceSeason", seasonYear).
		when().log().all()
				.get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
		then().log().all().
		         assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(circuitNumber));
	}
	
	
	
	
	@Test
	//this method is less recomandable 
	public void getBook() {

		given().log().all()
		.when()
		     .get("https://simple-books-api.glitch.me")
		.then()
		     .assertThat()
		.statusCode(200);
		System.out.println("status code is equal 200");
	}
	
	@Test
	//this method is always recomandable because u have more control 
	public void getBook_2() {
		
		Response response =
		given().log().all()
		.when()
		     .get("https://simple-books-api.glitch.me");
		int ststusCode = response.getStatusCode();
		System.out.println("status code is: " + ststusCode);
		Assert.assertEquals(ststusCode, 200,  "passed");
		System.out.println(response.prettyPrint());
		
	}
	
	@Test
	public void getBook_3() {
		
		RestAssured.baseURI = "https://simple-books-api.glitch.me";
		given().log().all()
		.when()
		       .get("/status")
		.then().log().all()
		       .assertThat()
		       .statusCode(200)
		.and()
		       .contentType(ContentType.JSON)
		.and()
		       .header("content-length", equalTo("15"))
		.and() 
		       .header("x-powered-by", equalTo("Express"));
		
		
	}
	
	

}
