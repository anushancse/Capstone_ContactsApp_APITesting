package com.anushancse.contactsapptesting.apitesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetContactList {
  @Test
  public void specificUser() {
 String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2ODAyOTNhNmU4NmZiNzAwMTU5YWE3NTQiLCJpYXQiOjE3NDUwNjAwNjV9.zzc-W-2Xcqjfs-dgZ9BECg2zL6d_jdRoMPHFFTvoQ3Q";
	  
	  String baseURL = "https://thinking-tester-contact-list.herokuapp.com/contacts/";
	  Response response = RestAssured.given().header("Authorization","Bearer "+token)
              .contentType(ContentType.JSON)  
              .accept(ContentType.JSON)                           
              .when()
              .get(baseURL);                 

     int statusCode = response.getStatusCode();
      System.out.println("HTTP Response Code: " + statusCode);

      if (statusCode == 200) {
          System.out.println("user foud successfully!");
      } else {
          System.out.println("Failed to find user. Response Code: " + statusCode);
      }
      System.out.println("response"+response.getBody().asString());
  }
  


  }

