package com.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class PostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() { // if it should call the run() method
		System.out.println("PostFilter shouldFilter method");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("PostFilter run method");
		return null;
	}

	@Override
	public String filterType() { // Post? Pre?
		System.out.println("PostFilter filterType method");
		return "post";
	}

	@Override
	public int filterOrder() { // what the order of the filter should run in
		System.out.println("PostFilter filterOrder method");
		return 0;
	}
	
}
