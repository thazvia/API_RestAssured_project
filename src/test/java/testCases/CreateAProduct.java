package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;


public class CreateAProduct {

	@Test
	public void createAProduct() {
		
		/*
		given: all input details(base URI,Headers,Payload/Body,QueryParameters)
		when: submit api requests(Http method,Endpoint/Resource)
		then: validate response(status code, Headers, responseTime, Payload/Body)
		
		base URL/ baseUri:https://techfios.com/api-prod/api/product
        Endpoint/Resourse:/read_one.phpp
         Headers:Content-Type:application/json
        QueryPrameters:id=2941
        Http Method:GET
        
        
        {
    "name" : "TR samsung S21",
    "price" : "850",
    "description" : "The best phone.",
    "category_id" : 2
}
         
		*/
		
		HashMap<String,String> payload = new HashMap<String,String>();
		payload.put("name", "TR samsung S21");
		payload.put("price", "850");
		payload.put("description", "The best phone.");
		payload.put("category_id", "2");
		
		
		Response response=
				
				
		given()
		    .baseUri("https://techfios.com/api-prod/api/product")
		    .header("Content-Type","application/json; charset=UTF-8")
		   .body(new File("src\\main\\java\\data\\CreatePayload.json"))
		   // .body(payload)
		    //.queryParam("name","RS Amazing Pillow 2.0").
		    //  .auth().preemptive().basic("username", "password").
		    .header("Authoriztion","Bearer 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").
		when()
		    .post("/create.php").
		then()
		    //.statusCode(200)
		    //.header("Content-Type","application/json; charset=UTF-8")
		    .extract().response();
		
		int actualStatusCode =response.getStatusCode();
		System.out.println("actualStatusCode:" + actualStatusCode);
		Assert.assertEquals(actualStatusCode,201);
		
		String actualHeader=response.getHeader("Content-Type");
		System.out.println("actualHeader:" + actualHeader);
		Assert.assertEquals(actualHeader,"application/json; charset=UTF-8");
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body:"+responseBody);
		
		JsonPath jp = new JsonPath(responseBody);
		//System.out.println("jp:"+ jp.prettyPrint());
		
		String productmessage = jp.get("message");
		System.out.println("productmessage:"+productmessage);
		//Assert.assertEquals(productmessage,"2941");
		
		
	
	}
}
