package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {

	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * 错误信息
	 */
	static String errorMsg = "error";
	
	@HystrixCommand(fallbackMethod = "helloFallback")
	public String helloService() {
		return restTemplate.getForEntity("http://EUREKA-DISCOVERYCLIENT/hello", String.class).getBody();
	}
	
	public String helloFallback() {
		return errorMsg;
	}
}
