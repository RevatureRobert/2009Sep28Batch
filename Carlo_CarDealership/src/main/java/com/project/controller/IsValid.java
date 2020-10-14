package com.project.controller;

import java.util.List;

import com.project.model.User;

public class IsValid {

	public static boolean email(String email) {
		// Determine whether email contains any extraneous characters
		boolean flag = true;
		if(email.length()<8)
			return false;
		for(int i = 0; i < email.length(); i++) {
			char tempChar = email.charAt(i);
			if(Character.isAlphabetic(tempChar) || tempChar=='_' || tempChar=='.' || tempChar=='@') {
				continue;
			} else {
				flag = false;
			}
		}
		
		return flag;
		
//		if ((Pattern.matches("[a]+", email) == false) && (email.length() > 7)) {
//		    return true; 
//		} else {
//			return false;
//		}
	}

	public static boolean username(String username) {
		// TODO Auto-generated method stub
		return true;
	}

	public static boolean validPassword(String password) {
		// TODO Auto-generated method stub
		return true;
	}

	public static boolean emailAlreadyExists(String email, List<User> L) {
		
		for(int i = 0; i < L.size(); i++) {				// Determine if email exists for object in list
			if(L.get(i).getEmail().equals(email)) {
				return true;
			}
		}
		
		return false;
	}
	
}
