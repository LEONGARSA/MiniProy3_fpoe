/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.contactos.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author LAURA
 */
public class Util {
        public static boolean isNumeric(String value) {
		return value != null && value.matches("^[0-9]*$");
	}
	
	public static boolean isAlphabetic(String value) {
		return value != null && value.matches("^[a-zA-Zá-úÁ-Ú\\s]*$");
	}
	
	public static boolean hasValidLength(String value, int maxLength, boolean isRequired) {
		if (isRequired && (value == null || value.isBlank())) {
			return false;
		}
		
		return value.length() <= maxLength;
	}
	
	public static String dateToString(Date date) {
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(date);
	}
}
