package com.anushancse.contactsapptesting.apitesting;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LogInUser {
  @Test
  public void postlogin() {
	 
	  String baseURL = "https://thinking-tester-contact-list.herokuapp.com/users/login";
      Map<String, Object> data = new HashMap<>();
	          
	          data.put("email", "smart@gmail.com");
	          data.put("password", "smart@123");
	         

	          Response response = RestAssured.given().
	        		  contentType(ContentType.JSON)  
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
	          
	          String token = response.jsonPath().getString("token"); 
	         
	          System.out.println("token :"+token);
	      }
	  

	  
  }

