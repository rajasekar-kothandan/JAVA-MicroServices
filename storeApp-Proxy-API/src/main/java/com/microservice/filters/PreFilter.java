package com.microservice.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class PreFilter extends ZuulFilter {

    @Override
    public String filterType() {

        return "pre";
    }

    @Override
    public int filterOrder() {

        return 0;
    }

    @Override
    public boolean shouldFilter() {

        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println("---------------------In Pre-Filter Method---------------------------");
        System.out.println("\n Request Method: " + request.getMethod() + "Request URL " + request.getRequestURL().toString());
        return null;
    }

}
