package com.qa.alphasense.testpages;



import static org.testng.Assert.assertThrows;

import java.io.File;
import java.util.Properties;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.alphasense.base.BasePage;

import com.qa.alphasense.util.AppConstants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;



public class Test_02_AlphaSenseAPITests 
{

	BasePage basePage =new BasePage();
	Properties prop = basePage.init_properties();




	@Test(priority = 1, description = "Page Status Code Test")
	public void checkingStatus() throws Exception
	{
		int expectedCode = 200;

		RestAssured.baseURI= prop.getProperty("url");
		RequestSpecification request = RestAssured.given().log().all();
		Response response = request.get("public-api/users");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, expectedCode);



	}


	@Test(priority = 2, description = "Application Website Name")
	public void verificationOfApplicationWebsite() throws Exception
	{

		RestAssured.baseURI= prop.getProperty("url");
		RequestSpecification request = RestAssured.given().log().all();
		Response response = request.get("public-api/users");

		ResponseBody body = response.getBody();
		String responseMessage = body.asString();
		String expectedMessage = "\"alpha-sense.(org|com)\"";

		try 
		{
			if(responseMessage.contains(expectedMessage))
			{
				System.out.println("Response message contains : " + expectedMessage);
			}
		} 

		catch (Exception e) 

		{
			System.out.println("The message : " + expectedMessage + " is not found in the response message");
			e.printStackTrace();
		}

		finally 

		{
			System.out.println("The response message :");
			System.out.println(responseMessage);
		}
	}

	@Test(priority = 3, description = "Attempt of Posting Json File Without Authantication Code (Negative Test)")
	public void postingJsonData (int expectedCode)
	{

		RestAssured.baseURI= prop.getProperty("url");
		RequestSpecification request = RestAssured.given().log().all();
		request.contentType("application/json");
		File file = new File(AppConstants.JSON_FILE_PATH);

		try 
		{
			request.body(file);
			Response response = request.post("public-api/users/");
			System.out.println(response.prettyPrint());

		} 
		catch (Exception e) 

		{
			e.printStackTrace();
		}



	}



}






