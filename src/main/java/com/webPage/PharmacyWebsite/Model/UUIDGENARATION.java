package com.webPage.PharmacyWebsite.Model;

import java.time.LocalDate;
import java.util.Random;

public class UUIDGENARATION {
	public static void main(String[] args) {		
		System.out.println(uuidGenaration());
	}
	
	public static String uuidGenaration() {
		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuilder  stb = new StringBuilder((LocalDate.now()).toString());
		Random random = new Random();
		int length = 5;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphaNumericString.length());
			char randomChar = alphaNumericString.charAt(index);
			stb.append(randomChar);
		}
		return stb.toString();
	}
}
