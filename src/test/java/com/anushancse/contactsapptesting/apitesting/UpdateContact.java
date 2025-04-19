package com.anushancse.contactsapptesting.apitesting;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateContact {
  @Test
  public void updatingUser() {
	  
	  String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2ODAyOTNhNmU4NmZiNzAwMTU5YWE3NTQiLCJpYXQiOjE3NDUwNzkyOTR9.nLkSIHCyYPGDkPiS0mK0hfVL8syxKkVToW9DZWIyUNU";
	  String baseURL = "https://thinking-tester-contact-list.herokuapp.com/contacts/6803847e7ea1ff0015adfa11";
      Map<String, Object> data = new HashMap<>();
	          data.put("firstName","Amy");
	          data.put("lastName", "Miller");
	          data.put("birthdate", "1992-02-02");
	          data.put("email", "amiller@fake.com");
	          data.put("phone",  "8005554242");
	          data.put("street1", "13 School St.");
	          data.put("street2",  "Apt. 5");
	          data.put("city", "Washington");
	          data.put("stateProvince", "QC");
	          data.put("postalCode", "A1A1A1");
	          data.put("country","Canada");
	         

	          Response response = RestAssured.given().header("Authorization","Bearer "+token)
	                  .contentType(ContentType.JSON)  
	                  .accept(ContentType.JSON)        
	                  .body(data)                   
	                  .when()
	                  .put(baseURL);                 

	         int statusCode = response.getStatusCode();
	          System.out.println("HTTP Response Code: " + statusCode);

	          if (statusCode == 201) {
	              System.out.println("updated successfully!");
	          } else {
	              System.out.println("Failed to update. Response Code: " + statusCode);
	          }

	          System.out.println("response"+response.getBody().asString());
	         
	         
	         String email = response.jsonPath().getString("email");
	 		Assert.assertEquals(email, "amiller@fake.com");
	 		System.out.println("email is matched");
	          
	      }
	  


  }

