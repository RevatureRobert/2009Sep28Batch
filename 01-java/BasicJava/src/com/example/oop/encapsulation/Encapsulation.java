package com.example.oop.encapsulation;

/*
 * Encapsulation encompasses the restriction of direct access to data.
 * 
 * HOW DOES JAVA ACHIEVE ENCAPSULATION?
 * ACCESS MODIFIERS
 * 
 * Access groups are
 * 					anywhere	subclasses		packages	same class
 * public				X			X				X			X
 * protected						X				X			X
 * default											X			X
 * private														X
 * 
 * Packages and imports
 * 		Packages are how we can organize our classes
 * 		Imports are how we can bring classes in other packages into our class;
 * 			a class within the same package doesn't need to import classes it references,
 * 			a class outside the package does need to import classes it references
 * 
 * To import JOptionPane class only, use a fully-qualified name:
 * 		import javax.swing.JOptionPane;
 * 
 * To import entire package of classes, use a wildcard:
 * 		import javax.swing.*;
 */

public class Encapsulation {
	
	public double accessibleAnywhere;
	protected int accessibleOnlyToSubclassesOrWithinPackage;
	boolean accessibleOnlyWithinPackage;
	private float accessibleOnlyInClass;
	
	// Getters & setters allow access and changes in fields
	// Getters & setters are typically public

	public float getAccessibleOnlyInClass() {
		return accessibleOnlyInClass;
	}

	// Typically want to use getters & setters instead of direct access because methods can enforce checks on data being accessed
	public void setAccessibleOnlyInClass(float accessibleOnlyInClass) {
		if(accessibleOnlyInClass > 0)
			this.accessibleOnlyInClass = accessibleOnlyInClass;
	}
}
