package com.anushancse.contactsapptesting.apitesting;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddNewUser {
  @Test
  public void PostRequest() {
	  String baseURL = "https://thinking-tester-contact-list.herokuapp.com/users";
      Map<String, Object> data = new HashMap<>();
	          data.put("firstName","Test");
	          data.put("lastName", "User");
	          data.put("email", "riya17450540869091@gmail.com");
	          data.put("password", "myPassword");
	         

	          Response response = RestAssured.given()
	                  .contentType(ContentType.JSON)  
	                  .accept(ContentType.JSON)        
	                  .body(data)                   
	                  .when()
	                  .post(baseURL);                 

	         int statusCode = response.getStatusCode();
	          System.out.println("HTTP Response Code: " + statusCode);

	          if (statusCode == 201) {
	              System.out.println("user created successfully!");
	          } else {
	              System.out.println("Failed to create user. Response Code: " + statusCode);
	          }

	         
	          System.out.println("Response Body: " + response.getBody().asString());
	      }
	  

}