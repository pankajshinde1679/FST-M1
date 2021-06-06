package activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity2 {
    // Set base URL
    final static String ROOT_URI = "https://petstore.swagger.io/v2/user";
    JSONObject obj = new JSONObject();
    
    @Test(priority=1)
    public void addNewUserFromFile() throws Exception {
        // Import JSON file      
    	String file = "src/main/java/activities/userinfo.json";
    	    	
        // Read JSON file as String     
    	String reqBody = readFileAsString(file);
        
    	System.out.println("The request body is :" +reqBody);

        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .body(reqBody) // Pass request body from file
            .when().post(ROOT_URI); // Send POST request

        //inputJSON.close();

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("1680"));
    }
    
    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
    
    @Test(priority=2)
    public void getUserInfo() throws IOException {
        // Import JSON file to write to
        FileWriter file = new FileWriter("src/main/java/activities/userGETResponse.json");

        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .pathParam("username", "pankajshinde2") // Pass request body from file
            .when().get(ROOT_URI + "/{username}"); // Send POST request
        
        // Get response body
        String resBody = response.getBody().asPrettyString();
        
        // Print response.
        System.out.println("The response is : " +resBody);

        try {
           // Write into file.        	
        	file.write(response.getBody().asPrettyString());
        	
        	// Close the file.
        	file.close();
           
        } catch (IOException excp) {
            excp.printStackTrace();
        }
        
        // Assertion
        response.then().body("id", equalTo(1680));
        response.then().body("username", equalTo("pankajshinde2"));
        response.then().body("firstName", equalTo("Pankaj2"));
        response.then().body("lastName", equalTo("Shinde2"));
        response.then().body("email", equalTo("pankajshinde2@gmail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9876543210"));
    }
   
    @Test(priority=3)
    public void deleteUser() throws IOException {
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .pathParam("username", "pankajshinde2") // Add path parameter
            .when().delete(ROOT_URI + "/{username}"); // Send POST request

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("pankajshinde2"));
    }
    
}