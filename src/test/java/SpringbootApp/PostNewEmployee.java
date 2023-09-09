package SpringbootApp;

import org.testng.annotations.Test;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostNewEmployee {

	@Test
	public void test1() {
		JSONObject requestBody = new JSONObject(); 
		requestBody.put("firstName", "Tushar"); 
		requestBody.put("lastName", "Gupta"); 
		requestBody.put("salary", "10000"); 
		requestBody.put("email", "abc@gmail.com");

		RestAssured.baseURI = "http://localhost:8088/employees";

		RequestSpecification request = RestAssured.given();

		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(requestBody.toString()).post();

		String body = response.getBody().asString();

		System.out.println("Response body is " + body);

		System.out.println("Response code is " + response.statusCode());
		
		Assert.assertEquals(response.statusCode(),  201);

	}
}