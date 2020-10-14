package com.dealership.frontend;

import java.security.MessageDigest;

public class Utilities {
	/**
	 * Hashes a password by using a basic MD5 algorithm.
	 * 
	 * @param password the password String to be hashed.
	 * @return a String object representing the hashed password.
	 */
	public static String hashPassword(String password) {
		StringBuilder result = new StringBuilder(32);
		
		try {
			MessageDigest hasher = MessageDigest.getInstance("MD5");
			
			// Hashes the string, then builds a new string out of the resulting
			// byte array
			byte[]hashBytes = hasher.digest(password.getBytes());
			for(byte b: hashBytes)
				result.append(String.format("%02x", b));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result.toString();
	}

	/**
	 * 
	 * @param totalDue
	 * @param downPayment
	 * @param loanMonths
	 * @param yearlyInterestRate
	 * @return
	 */
	public static float calculateMonthlyPayment(float totalDue, float downPayment, int loanMonths, float yearlyInterestRate) {
		float result = totalDue - downPayment;
		float monthlyInterest = (float)Math.pow(yearlyInterestRate * 100f, 1f / 12f) / 100f;
		float factor = (float)Math.pow(1 + monthlyInterest, loanMonths);
		
//		float loanMonths = loanStartDate.until(loanEndDate).toTotalMonths();		
//		result *= yearlyInterestRate;
//		result /= (12F * (1F - 1F/(float)Math.pow(1F + yearlyInterestRate/12F, 12F * loanMonths)));

		result *= (monthlyInterest * factor);
		result /= (factor - 1);
		result = Math.round(result*100f) / 100F;
		
		return result;
	}
}
