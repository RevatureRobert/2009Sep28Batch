package com.dealership.pojos;

import com.dealership.frontend.Utilities;

/**
 * The User abstract class is the parent class of all user types. Contains fields
 * for identifying and addressing the user.
 * 
 * This object does not retain a plain representations of its password; all
 * passwords are hashed before being stored.
 * 
 * @author Nicolas Hernandez
 *
 */
public abstract class User {
	/**
	 * The unique user identifier, same as the user's login name
	 */
	private String userid;
	
	/**
	 * An encrypted version of the user's password.
	 */
	private String passwordHash;
	
	/**
	 * The name that the user wishes to be addressed as.
	 */
	private String colloquialName;
	
	
	/**
	 * Initializes a User object with the given name and password hash, for
	 * rebuilding existing Users.
	 * 
	 * @param username
	 * @param passwordHash hashed password of the current User
	 */
	public User(String username, String passwordHash, String colloquialName) {
		this.userid = username;
		this.passwordHash = passwordHash;
		this.colloquialName = colloquialName;
	}
	
	
	/**
	 * Validates login credentials for this user.
	 * 
	 * @param username
	 * @param unhashedPassword a plain string representing the password as entered
	 * 							by the user
	 * @return a boolean specifying whether or not a login is valid
	 */
	public boolean isLoginValid(String username, String unhashedPassword) {
		return (this.userid.equals(username) &&
				this.passwordHash.equals(Utilities.hashPassword(unhashedPassword)));
	}
	
	
	/**
	 * Takes an UN-HASHED password and stores its hashed value internally.
	 * 
	 * This method should be used for users defining their passwords.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		passwordHash = Utilities.hashPassword(password);
	}
	
	
	
	/**
	 * Returns this user's username.
	 * 
	 * @return this user's username.
	 */
	public String getUsername() {
		return userid;
	}
	/**
	 * Sets the username to the given String.
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.userid = username;
	}
	/**
	 * Returns this user's HASHED password.
	 * 
	 * @return the hashed password.
	 */
	public String getPasswordHash() {
		return passwordHash;
	}
	/**
	 * Sets the password hash to the given String.
	 * 
	 * @param passwordHash
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	/**
	 * Returns the user's commonly-spoken name.
	 * 
	 * @return the familiar name of the user.
	 */
	public String getColloquialName() {
		return colloquialName;
	}
	/**
	 * Sets the familiar name of the user.
	 * 
	 * @param colloquialName what the user would like to be called.
	 */
	public void setColloquialName(String colloquialName) {
		this.colloquialName = colloquialName;
	}
}
