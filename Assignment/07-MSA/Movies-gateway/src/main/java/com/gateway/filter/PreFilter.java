package com.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class PreFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		System.out.println("in the prefilter shouldFilter method");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("in the prefilter run method0");
		return null;
	}

	@Override
	public String filterType() {
		System.out.println("in the prefilter filterType method");
		return "post";
	}

	@Override
	public int filterOrder() {
		System.out.println("in the prefilter filterOrder method");
		return 0;
	}

}
