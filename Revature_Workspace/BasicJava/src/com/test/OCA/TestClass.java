package com.test.OCA;

import java.util.Set;
import java.util.Stack;

public class TestClass{
	public void myMethod() throws Exception {
        yourMethod();
    }
    
    public void yourMethod() throws Exception {
        throw new Exception();
    }

}