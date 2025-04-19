package com.anushancse.contactsapptesting.apitesting;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateUser {
  @Test
  public void patchRequest() {
	  String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2ODAyOTNhNmU4NmZiNzAwMTU5YWE3NTQiLCJpYXQiOjE3NDUwNzY4ODd9.cLl5PJ7CpQFrCiyWwuuT3jvds-7u0QmuuLMbniksFrc";
	  String baseURL = "https://thinking-tester-contact-list.herokuapp.com/users/me";
      Map<String, Object> data = new HashMap<>();
	          data.put("firstName","Updated");
	          data.put("lastName", "Username");
	          data.put("email", "riya17449984953191@gmail.com");
	          data.put("password", "myNewPassword");
	         

	          Response response = RestAssured.given().header("Authorization","Bearer "+token)
	                  .contentType(ContentType.JSON)  
	                  .accept(ContentType.JSON)        
	                  .body(data)                   
	                  .when()
	                  .patch(baseURL);                 

	         int statusCode = response.getStatusCode();
	          System.out.println("HTTP Response Code: " + statusCode);

	          if (statusCode == 200) {
	              System.out.println("update successfully!");
	          } else {
	              System.out.println("Failed to updated Response Code: " + statusCode);
	          }

	         
	          System.out.println("Response Body: " + response.getBody().asString());
	          
	          System.out.println("Bearer token" + token);
	      }
	  

}