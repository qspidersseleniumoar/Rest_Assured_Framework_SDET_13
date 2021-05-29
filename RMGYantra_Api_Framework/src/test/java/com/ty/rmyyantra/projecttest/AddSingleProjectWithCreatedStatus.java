package com.ty.rmyyantra.projecttest;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;

import com.ty.rmgyantra.genericlib.BaseClass;
import com.ty.rmgyantra.genericlib.DataBaseUtilities;
import com.ty.rmgyantra.genericlib.IEndPoints;
import com.ty.rmgyantra.genericlib.JavaUtility;
import com.ty.rmgyantra.pojolib.Project;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class AddSingleProjectWithCreatedStatus extends BaseClass{
	
	@Test
	public void addSingleProjectWithCreatedStatus() throws Throwable {

		
		String projNAme = "JhonyWalkerWhisky_"+JavaUtility.getRanDomNum();
		
		Project pobj = new Project("deepak", projNAme, "Created", 10);
		
		Response resp = given()                               // pre conditions
						  .contentType(ContentType.JSON)
						  .body(pobj)
						.when()                             // actual http test
						   .post(IEndPoints.addSingleProjectWithCreatedStatus);
		
		resp.then()
		     .log().all()
		     .and()
		     .contentType(ContentType.JSON);
		
		//capture Project NAme & status
		    String apiProjecName  = resp.jsonPath().get("projectName");
		    String apiStatus  = resp.jsonPath().get("status");
					  
	     //write Selenium program to capture data from GUI
		    
		 //Write JDBC program to capture data from Mysql DB
		    boolean projectNAmeresult = dbLib.executeQueryAndGetData("select * from project" ,4 , apiProjecName);
		    Assert.assertTrue(projectNAmeresult);
		    boolean projectStatus = dbLib.executeQueryAndGetData("select * from project" ,5 , apiStatus);
		    Assert.assertTrue(projectStatus);

		    
	}

}
