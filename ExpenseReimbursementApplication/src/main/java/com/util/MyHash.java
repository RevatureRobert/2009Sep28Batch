package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyHash 
{
	private String data;
	
	private String algorithm;
	
	public static String generateHash(String data, String algorithm) throws NoSuchAlgorithmException
	{
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		
		digest.reset();
		
		try
		{
		byte[] hash = digest.digest(data.getBytes());
		
		return bytesToStringHex(hash);
		}
		catch(Exception e)
		{
			System.out.println("Testing");
		}
		
		return "";
	}

	
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	public static String bytesToStringHex(byte[] bytes) 
	{
		char[] hexChars = new char[bytes.length * 2];
		
		for(int j = 0; j < bytes.length; j++)
		{
			int v = bytes[j] & 0xFF;
			
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2  + 1] = hexArray[v & 0x0F];
		}
		return new String (hexChars);
	}

	public MyHash(String data, String algorithm) {
		super();
		this.data = data;
		this.algorithm = algorithm;
	}
}
