package com.madsis.reportes.util;

public class UtilString {

	public static String defineString(String value) {
		if (value != null)
			return (value.trim().equalsIgnoreCase("null")) ? "" : value.trim();
		else
			return new String();
	}

}
