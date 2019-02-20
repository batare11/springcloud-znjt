package brilliance.znjt.eurekacomsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/consume")
public class TestController {
	
	@Autowired
    RestTemplate restTemplate;

	@GetMapping(value="/hello",produces=MediaType.APPLICATION_JSON_VALUE)
	@HystrixCommand(fallbackMethod = "helloError")
    public String hello(@RequestParam String name){
    	return restTemplate.postForEntity("http://PRODUCER-SERVICE/produce/hello", name, String.class).getBody();
        //return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();

    }
	
	/*除Throwable这个参数，其他参数要与原调用方法保持一致*/
	public String helloError(String name,Throwable e) {
        return "service is error:"+e.getMessage();
    }



}
