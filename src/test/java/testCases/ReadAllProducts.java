package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class ReadAllProducts {

	@Test
	public void readAllProducts() {
		
		/*
		given: all input details(base URI,Headers,Payload/Body,QueryParameters)
		when: submit api requests(Http method,Endpoint/Resource)
		then: validate response(status code, Headers, responseTime, Payload/Body)
		
		base URL/ baseUri:https://techfios.com/api-prod/api/product
        Endpoint/Resourse:/read.php
         Headers:Content-Type:application/json; charset=UTF-8
        Http Method:GET
         
		*/
		
		Response response=
				
				
		given()
		    .baseUri("https://techfios.com/api-prod/api/product")
		    .header("Content-Type","application/json; charset=UTF-8").
		when()
		    .get("/read.php").
		then()
		    //.statusCode(200)
		    //.header("Content-Type","application/json; charset=UTF-8")
		    .extract().response();
		
		int actualStatusCode =response.getStatusCode();
		System.out.println("actualStatusCode:" + actualStatusCode);
		Assert.assertEquals(actualStatusCode,200);
		
		String actualHeader=response.getHeader("Content-Type");
		System.out.println("actualHeader:" + actualHeader);
		Assert.assertEquals(actualHeader,"application/json; charset=UTF-8");
		
		
		
	}
}
