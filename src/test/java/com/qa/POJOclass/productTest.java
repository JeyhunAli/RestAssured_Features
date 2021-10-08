package com.qa.POJOclass;

import org.apache.juneau.annotation.Beanc;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.SerializeException;

public class productTest {

	public static void main(String[] args) {
		//	@Beanc(properties = "name, colors, price, sellerNames")
		
		JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
				String sellerName [] = {"Google, Tesla, Microsoft, Apple"};
				Product product = new Product("MacBook", "white", 1000, sellerName);
				try {
					String json = jsonSerializer.serialize(product);
					System.out.println(json);
				} catch (SerializeException e) {
					
					e.printStackTrace();
				}
		
		
	}

}
