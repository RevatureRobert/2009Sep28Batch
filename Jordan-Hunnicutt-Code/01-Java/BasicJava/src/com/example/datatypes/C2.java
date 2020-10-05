package com.example.datatypes;

public class C2 extends Constructors{
	
	C2(){
		super(); //calls the parent's constructor.  With no constructor made, it automatically does this.
		//if we comment out super, will it still print 0, or give an error? Even if we comment it out, it still calls super();
		//because every class extends object, we have to have a link to get to object, so super is always intrinsically in every constructor
	}
	
}
