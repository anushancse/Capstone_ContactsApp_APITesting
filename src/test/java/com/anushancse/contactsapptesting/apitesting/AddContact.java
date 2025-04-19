package com.anushancse.contactsapptesting.apitesting;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddContact {
	
	String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2ODAyOTNhNmU4NmZiNzAwMTU5YWE3NTQiLCJpYXQiOjE3NDUwNjAwNjV9.zzc-W-2Xcqjfs-dgZ9BECg2zL6d_jdRoMPHFFTvoQ3Q";
  @Test
  public void addcontact() {
	  String baseURL = "https://thinking-tester-contact-list.herokuapp.com/contacts";
      Map<String, Object> data = new HashMap<>();
	          data.put("firstName","John");
	          data.put("lastName", "Doe");
	          data.put("birthdate", "1970-01-01");
	          data.put("email","jdoe@fake.com");
	          data.put("phone", "8005555555");
	          data.put("street1", "1 Main St.");
	          data.put("street2", "Apartment A");
	          data.put("city", "Anytown");
	          data.put("stateProvince", "KS");
	          data.put("postalCode", "12345");
	          data.put("country","USA");
	         

	          Response response = RestAssured.given().header("Authorization","Bearer "+token)
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
	          System.out.println("bearer token"+token);
	      }
	  


  }

