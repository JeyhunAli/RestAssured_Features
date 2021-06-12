package com.restApi_Get;

/**
 * these two static imports we have to add manually
 */
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

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
	public void getApiTest() {
		
		given()
		.when()
		.get("http://ergast.com/api/f1/2017/circuits.json");

	}

}
