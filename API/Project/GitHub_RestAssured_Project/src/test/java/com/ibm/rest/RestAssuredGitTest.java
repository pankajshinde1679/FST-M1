package com.ibm.rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

import org.testng.annotations.AfterClass;

public class RestAssuredGitTest {

	// Declare request specification
	RequestSpecification requestSpec;
	// Declare response specification
	ResponseSpecification responseSpec;

	String sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDDII6HGS1ehoS5uH/F3hG4pUDJq4Mnt6o/XX3+VKITEnnaEaMGfIKYOW9lC8Cbl5ouag73EIY+U4Qs0Rl31FEl1HXnrJoc3+Uws4btUcnjIGd0d934IBzPXRqiaV2IGaAaCpqDLXdZ+2BV+N7NhdqNb568FCurZN/ErZsDb6liST48w80SCVZuvk3P8wJNyLmruK4Yxd/PWO0pS4ZCyu19CNhynJqnwB7eVFEKASEfjPDoE1aGmO/65/y811wTr11VITmgmhQPkUWHKFosylRYujavdp3H+JVUCmSu9TApRixCMxBuSdH9aknxFW/VDCXcPn3q+Rizqy4WWqaliwfL+g6OB7n3hnX1qkay4h6qm8QWLyaejJkM44Gf8QXAB0rDwcGAO5g6ucXnLdgDs3E3TpRfwk9oezBBsRC8swNmtrzAJ8vipiDqH3ggtZTs4fhx7Un4Fjpr6+1pxLov3CodM2kTtKK7kW4o0IeULNtCl5KdwHGLx3DeTBsSW4QadKs=";
	int keyId = 0;	

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://api.github.com";

		requestSpec = new RequestSpecBuilder()
				// Set content type
				.setContentType(ContentType.JSON)
				// Set access token
				.addHeader("Authorization", "token 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")
				// Set base URL
				.setBaseUri("https://api.github.com")
				// Build request specification
				.build();

	}

	@Test(priority=1)
	public void postRequest() {

		String reqBody = "{\"title\": \"TestKey\", \"key\": \""+sshKey+"\"}";

		Response response = given().spec(requestSpec) // Use requestSpec
				.body(reqBody) // Send request body
				.when().post("/user/keys"); // Send POST request

		// Response body
		String resBody = response.getBody().asPrettyString();		
		System.out.println("Response Body: ");
		System.out.print(resBody);

		// Check status code.
		response.then().statusCode(201);

	}

	@Test(priority=2)
	public void getRequest() {

		// Send get request.
		Response response = given().spec(requestSpec)
				.when().get("/user/keys"); 

		// Print response body
		String resBody = response.getBody().asPrettyString();
		System.out.println("Response Body : ");
		System.out.print(resBody);		

		// Check status code.
		response.then().statusCode(200);
	}

	@Test(priority=3)
	public void deleteRequest() {

		// Send delete request.
		Response response = given().spec(requestSpec)
				.pathParam("keyId", sshKey).when().delete("/user/keys/{keyId}");

		// Print response body
		String resBody = response.getBody().asPrettyString();
		System.out.println("Response Body : ");
		System.out.print(resBody);	

		// Check status code.
		response.then().statusCode(404);


	}


}
