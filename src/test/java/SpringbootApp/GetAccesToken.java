package SpringbootApp;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAccesToken {

	public static void main(String[] args) {

		Response response = RestAssured.given().baseUri("http://localhost:8088").auth()
				.basic("rest-assured", "password").contentType("application/x-www-form-urlencoded")
				.formParam("grant_type", "password").formParam("username", "onlyfullstack")
				.formParam("password", "secret").when().post("/oauth/token");

		System.out.println("Response is " + response.body().asString());

		JsonPath jpath = response.jsonPath();
		String token = jpath.get("access_token");
		System.out.println("Token is " + token);
		// return token;

		// students Token;
		response = RestAssured.given()
				.baseUri("http://localhost:8088")
				.auth()
				.oauth2(token)
				.when()
				.get("/students");

		System.out.println("Get Students Response is " + response.getBody().asString());
		//==============================Get Students using header================
		
		HashMap<String,Object> headers =new HashMap<String,Object>();
		headers.put("Authorization","Bearer" +token);
		
		response = RestAssured.given()
				.baseUri("http://localhost:8088")
				.headers(headers)
				.when()
				.get("/students");

		System.out.println("Get Student Response is" +response.getBody().asString());
		
		
		
		
		
		
	}

}
