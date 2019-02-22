package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	UserService userService;
	
	//---------------------------GET请求开始---------------------------------------------------------------------------
	
	@RequestMapping(value="/helloConsumer",method = RequestMethod.GET)
	public String helloConsumer() {
		return userService.helloService();
	}
	
	
	@RequestMapping(value="/ribbon-consumer",method = RequestMethod.GET)
	public String helloConsumerString() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://EUREKA-DISCOVERYCLIENT/hello?name={1}", String.class,"didi");
		String body = responseEntity.getBody();
		return body;
	}
	
	/*@RequestMapping(value="/ribbon-consumer",method = RequestMethod.GET)
	public String helloConsumerMap() {
		Map<String,String> params = new HashMap<String, String>();
		params.put("name", "dada");
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://EUREKA-DISCOVERYCLIENT/hello?name={name}", String.class,params);
		String body = responseEntity.getBody();
		return body;
	}
	
	@RequestMapping(value="/ribbon-consumer",method = RequestMethod.GET)
	public String helloConsumer1() {
		return restTemplate.getForObject("http://EUREKA-DISCOVERYCLIENT/hello", String.class);
	}
	
	
	//---------------------------GET请求结束------------------------------------------------------
	
	//---------------------------POST请求开始(重载方法和GET类似)------------------------------------------------------
	
	@RequestMapping(value="/ribbon-consumer",method = RequestMethod.GET)
	public String helloConsumerPost1() {
		User user = new User("didi",25);
		return restTemplate.postForObject("http://EUREKA-DISCOVERYCLIENT/hello", user,String.class);
	}
	//---------------------------POST请求结束------------------------------------------------------
	
	
	//---------------------------PUT请求开始(重载方法和GET类似)------------------------------------------------------
	
		@RequestMapping(value="/ribbon-consumer",method = RequestMethod.GET)
		public void helloConsumerPut() {
			Long id = 100001L;
			User user = new User("didi",25);
			restTemplate.put("http://EUREKA-DISCOVERYCLIENT/user{1}", user,id);
		}
	//---------------------------PUT请求结束------------------------------------------------------
	
	//---------------------------PUT请求开始(重载方法和GET类似)------------------------------------------------------
			@RequestMapping(value="/ribbon-consumer",method = RequestMethod.GET)
			public void helloConsumerDelete() {
				Long id = 100001L;
				User user = new User("didi",25);
				restTemplate.delete("http://EUREKA-DISCOVERYCLIENT/user{1}", user,id);
			}
	//---------------------------PUT请求结束------------------------------------------------------
*/		
}
