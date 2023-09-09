package RestAPIBDD;

import org.hamcrest.Matchers;
import org.jsoup.helper.HttpConnection.Response;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import junit.framework.Assert;

public class GetRequestBDD {

	@Test

	public void test1() {

		RestAssured.given().baseUri("http://localhost:3000/employees")
		.when()
		.get()
		.then()
		.log()
		.body()
		.statusCode(200)
		.body("[4].name",Matchers.equalTo("John"));

	}

	@Test
	public void test2() {

		RestAssured.given().baseUri("http://localhost:3000/employees").when()
		.get("/3")
		.then()
		.log()
		.body()
		.statusCode(200)
		.body("name", Matchers.equalTo("Veena"));

	}

	
	@Test
	public void test3() {
		
		Response response = (Response) RestAssured.given()
				.baseUri("http://localhost:3000/employees")
						 .when()
						 .get();
						 
						 Assert.assertEquals(response.statusCode(), 200);
		
	}
}