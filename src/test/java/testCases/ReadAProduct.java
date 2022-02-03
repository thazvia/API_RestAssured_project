package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;


public class ReadAProduct {

	@Test
	public void readAProduct() {
		
		/*
		given: all input details(base URI,Headers,Payload/Body,QueryParameters)
		when: submit api requests(Http method,Endpoint/Resource)
		then: validate response(status code, Headers, responseTime, Payload/Body)
		
		base URL/ baseUri:https://techfios.com/api-prod/api/product
        Endpoint/Resourse:/read_one.phpp
         Headers:Content-Type:application/json
        QueryPrameters:id=2941
        Http Method:GET
         
		*/
		
		Response response=
				
				
		given()
		    .baseUri("https://techfios.com/api-prod/api/product")
		    .header("Content-Type","application/json")
		    .queryParam("id","2972").
		    //.queryParam("name","RS Amazing Pillow 2.0").
		    //  .auth().preemptive().basic("username", "password").
		   // .header("Authoriztion","Bearer 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")
		when()
		    .get("/read_one.php").
		then()
		    //.statusCode(200)
		    //.header("Content-Type","application/json; charset=UTF-8")
		    .extract().response();
		
//		long actualresponseTime=response.getTimeIn(TimeUnit.MILLISECONDS);
//		System.out.println("actualresponseTime:" +actualresponseTime);
//		if(actualresponseTime<=2000) {
//			System.out.println("Response time is  within range");
//		}else {
//			System.out.println("Response time is out of range");
//		}
		
		
		
		int actualStatusCode =response.getStatusCode();
		System.out.println("actualStatusCode:" + actualStatusCode);
		Assert.assertEquals(actualStatusCode,200);
		
		String actualHeader=response.getHeader("Content-Type");
		System.out.println("actualHeader:" + actualHeader);
		Assert.assertEquals(actualHeader,"application/json");
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body:"+responseBody);
		
		JsonPath jp = new JsonPath(responseBody);
		//System.out.println("jp:"+ jp.prettyPrint());
		
		String productId = jp.get("id");
		System.out.println("productId:"+productId);
		Assert.assertEquals(productId,"2972");
		
//		String productPrice = jp.getString("price");
//		System.out.println("productPrice:"+ productPrice);
//		Assert.assertEquals(productPrice,"199");
//	
	}
}
