package github;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DeleteRepo {

	 public void test1() throws IOException {
		 
		 byte[]dataFile = Files.readAllBytes(Paths.get("repodata.json"));
			
			RestAssured.baseURI = "https://api.github.com/user/repos";

			RequestSpecification request = RestAssured.given();

			Response response = request.auth().oauth2("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").
					contentType(ContentType.JSON).accept(ContentType.JSON).body(dataFile)
					.post();

			String body = response.getBody().asString();

			System.out.println("Response body is " + body);

			System.out.println("Response code is " + response.statusCode());

			Assert.assertEquals(response.statusCode(), 201);

		 
	 }
}
