package com.ty.rmgyantra.genericlib;

import java.util.Random;
/**
 * 
 * @author Deepak
 *
 */
public class JavaUtility {

	
	public static int getRanDomNum() {
		Random ran = new Random();
		      int num =  ran.nextInt(2000);
			return num;
	}
}
