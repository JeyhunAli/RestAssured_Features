package com.restApi_Get;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.transform.Synchronized;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETNONBDDAPI {
	
	//prepare the request
	//hit the API
	//get the response
	//fetch the values from response
	
	/**
	 * this class is all about non bdd aproach in rest assured 
	 * 
	 * 
	 * 
	 */
	
	@Test
	public void getUser_Non_Bdd_Test(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af");
		
		Response response = request.get("public-api/users");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println(response.getHeader("Server"));
	}
	
	
	@Test
	public void getUser_Non_Bdd_WithQueryParams_Test(){
				
		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af");
		
		request.queryParam("first_name", "John");
		request.queryParam("gender", "male");
		
		Response response = request.get("public-api/users");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println(response.getHeader("Server"));
		System.out.println(response.getCookie("PHPSESSID"));
		System.out.println(response.getStatusLine());
		System.out.println(response.getContentType());

		
		//accesing json body with jsonPath 
		JsonPath js = response.jsonPath();
		System.out.println(js.getString("_meta.success"));
		Assert.assertEquals(js.getString("_meta.success"), true);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getHeader("Server"), "nginx");

	}
	
	
	
	//hashmap query parameter
	/**
	 * hashmap can store null key and null values 
	 * hashmap is always non-Synchronized -means multiple threads can contribute or attack same time 
	 * but hashtable is Synchronized with multy thread environment we can use hashtable 
	 * but in hashtable we cannot store null key and null values 
	 */
	@Test
	public void getUser_Non_Bdd_HashMap_QueryParams_Test(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer 3752ff357e824639e691f15daf3d957c142b47026cba2736576480f04b3e87af");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("first_name", "John");
		params.put("gender", "male");
		
		//here queryParams are method overloaded 
		//requelar query parameter and also hasmap object ref name we can pas as parametr
		request.queryParams(params);
		
		Response response = request.get("public-api/users");
		
		//actual values
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println(response.getHeader("Server"));
		
		//expected values
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getHeader("Server"), "nginx");
	}
	
	
	
	
	
	
	

}