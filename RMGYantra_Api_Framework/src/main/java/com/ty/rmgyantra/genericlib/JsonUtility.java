package com.ty.rmgyantra.genericlib;

import io.restassured.response.Response;

/**
 * 
 * @author Deepak
 *
 */
public class JsonUtility {
	
	 public String getJsonPathData(String jsonXpath, Response resp)
	 {
		   String result = resp.jsonPath().get(jsonXpath);
		return result;
		   
	 }
}
