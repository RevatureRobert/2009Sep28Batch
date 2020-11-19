package com.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class PostFilter extends ZuulFilter{

	
	//decides if this filter should call the run method. 
	@Override
	public boolean shouldFilter() {
		System.out.println("in the post filter shouldFilter method");
		return true;
	}

	//filters. 
	@Override
	public Object run() throws ZuulException {
		System.out.println("in the post filter run method");
		return null;
	}

	@Override
	public String filterType() {
		System.out.println("in the filterType of the post filter");
		return "post";
	}

	//determines what order the filter should run 
	@Override
	public int filterOrder() {
		System.out.println("in the post filter filterOrder method");
		return 0;
	}

}
