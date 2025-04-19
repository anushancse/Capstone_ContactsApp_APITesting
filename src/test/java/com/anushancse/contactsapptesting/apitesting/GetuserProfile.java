package com.anushancse.contactsapptesting.apitesting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class GetuserProfile {
  @Test
  public void GetUserDetails() {
		
	  String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2ODAzNjk4ODdlYTFmZjAwMTVhZGY5YmYiLCJpYXQiOjE3NDUwNTQwODh9.xz_Stiwk7uV0jF6eSn7UIEGzydictLlGTo6lv0esFng";
	  
	given().header("Authorization","Bearer "+token).when().get("https://thinking-tester-contact-list.herokuapp.com/users/me").then().statusCode(200).log().body();
      System.out.println("sucessfully find  datails");
  }
  }
