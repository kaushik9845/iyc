package com.iyc.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static void main(String[] args) throws ParseException {
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date birthDate = (Date) df.parse("16-11-1988");
		System.out.println(birthDate);
	}

}
