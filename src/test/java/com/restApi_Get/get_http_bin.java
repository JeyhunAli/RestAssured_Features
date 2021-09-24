package com.restApi_Get;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class get_http_bin {
	
	
	@Test
	public void testHttpBin_1() {
		
		
		given().log().all().
		when().
		       get("https://httpbin.org").
		then().log().all().
		       assertThat()
		       .statusCode(200)
		.and()
		       .contentType(ContentType.HTML)
		.and() 
	           .header("Content-Length", "9593");
		
	}
	
	@Test
	public void testHttpBin_2() {
		
		Response response =
		
		given().log().all()
		.queryParam("get", "get")
		.param("oneparam", "1")
		.param("twoparam", "gelmishdun")
		.when().log().all()
		.get("https://httpbin.org");
		int i = response.statusCode();
		System.out.println(i);
		
		
	}
	
	

}
