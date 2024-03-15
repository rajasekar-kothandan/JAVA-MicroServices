package com.microservice;

import com.microservice.filters.ErrorFilter;
import com.microservice.filters.PostFilter;
import com.microservice.filters.PreFilter;
import com.microservice.filters.RouteFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class StoreAppProxyApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(StoreAppProxyApiApplication.class, args);
	}

	@Bean
	public PreFilter getPreFilter(){

		return new PreFilter();
	}

	@Bean
	public PostFilter getPostFilter(){

		return new PostFilter();
	}

	@Bean
	public RouteFilter getRouteFilter(){

		return new RouteFilter();
	}

	@Bean
	public ErrorFilter getErrorFilter(){

		return new ErrorFilter();
	}

}
