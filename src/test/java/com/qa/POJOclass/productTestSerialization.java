package com.qa.POJOclass;

import org.apache.juneau.annotation.Beanc;
import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;

public class productTestSerialization {

	public static void main(String[] args) {
		//	@Beanc(properties = "name, colors, price, sellerNames")
		//POJO TO JSON
		JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
				String sellerName [] = {"Google, Tesla, Microsoft, Apple"};
				Product product = new Product("MacBook", "white", 1000, sellerName);
				try {
					String json = jsonSerializer.serialize(product);
					System.out.println(json);
				} catch (SerializeException e) {
					
					e.printStackTrace();
				}
		
				
				// POJO TO XML
				XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
				String xml;
				try {
					xml = xmlSerializer.serialize(product);
					System.out.println(xml);
				} catch (SerializeException e) {
					
					e.printStackTrace();
				}
				
				
				// POJO TO HTML
				HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;
				String html;
				try {
					html = htmlSerializer.serialize(product);
					System.out.println(html);
				} catch (SerializeException e) {
					
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
	}

}
