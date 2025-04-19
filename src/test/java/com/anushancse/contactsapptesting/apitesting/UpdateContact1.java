package com.anushancse.contactsapptesting.apitesting;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateContact1 {
  @Test
  public void updateUserBypatch() {
	  String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2ODAyOTNhNmU4NmZiNzAwMTU5YWE3NTQiLCJpYXQiOjE3NDUwNzY4ODd9.cLl5PJ7CpQFrCiyWwuuT3jvds-7u0QmuuLMbniksFrc";
	  String baseURL = "https://thinking-tester-contact-list.herokuapp.com/contacts/6803847e7ea1ff0015adfa11";
      Map<String, Object> data = new HashMap<>();
	          data.put("firstName","Anna");
	          
	         

	          Response response = RestAssured.given().header("Authorization","Bearer "+token)
	                  .contentType(ContentType.JSON)  
	                  .accept(ContentType.JSON)        
	                  .body(data)                   
	                  .when()
	                  .patch(baseURL);                 

	         int statusCode = response.getStatusCode();
	          System.out.println("HTTP Response Code: " + statusCode);

	          if (statusCode == 201) {
	              System.out.println("updated successfully!");
	          } else {
	              System.out.println("Failed to update. Response Code: " + statusCode);
	          }

	          System.out.println("response"+response.getBody().asString());
	         
	         
	        
	          
	      }
	 

  }
  
