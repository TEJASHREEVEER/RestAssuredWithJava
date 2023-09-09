package RestAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DeleteRequest {
	@Test
	public void test1() {
		RestAssured.baseURI = "http://localhost:3000/employees";

		RequestSpecification request = RestAssured.given();

		Response response = request.delete("/10");

		System.out.println("Response code is " + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);

	}

}
