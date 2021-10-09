package com.qa.POJOclass;

import java.io.File;
import java.io.IOException;

import org.apache.juneau.json.JsonParser;
import org.apache.juneau.parser.ParseException;

public class productTestDeSerialization {

	public static void main(String[] args) throws ParseException, IOException {
		
		JsonParser jsonParser =	JsonParser.DEFAULT;
		 
		File file = new File("/Users/jey/eclipse-workspace/RestAssured_Features/src/test/java/dataFiles/dsta.json");
		Product pro = jsonParser.parse(file, Product.class);
		System.out.println(pro.getName());
		System.out.println(pro.getColor());
		
		
		
	}

}
