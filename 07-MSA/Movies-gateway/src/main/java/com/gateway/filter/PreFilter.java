package com.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class PreFilter extends ZuulFilter {
	
	@Override
	public boolean shouldFilter() { // if it should call the run() method
		System.out.println("PreFilter shouldFilter method");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("PreFilter run method");
		
		
		
		return null;
	}

	@Override
	public String filterType() { // Post? Pre?
		System.out.println("PreFilter filterType method");
		return "pre";
	}

	@Override
	public int filterOrder() { // what the order of the filter should run in
		System.out.println("PreFilter filterOrder method");
		return 0;
	}
}
