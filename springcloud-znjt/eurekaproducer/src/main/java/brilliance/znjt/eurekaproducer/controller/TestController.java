package brilliance.znjt.eurekaproducer.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import brilliance.znjt.eurekaproducer.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/produce", produces = { "application/json;charset=UTF-8" })
@Api("业务层测试")
public class TestController {
	  
       private Logger log = LoggerFactory.getLogger(TestController.class);
	    
	   @Autowired
	    private DiscoveryClient client;//获取注册信息用
	   
	   @Autowired
	    private Registration registration; // 服务注册
	   
	   @Autowired
	   private TestService testService;
	   
	   @PostMapping(value="/hello",produces=MediaType.APPLICATION_JSON_VALUE)
	   @ApiOperation("获取服务注册信息")
	    public String hello(@RequestBody(required=false) String name) {
	        return name +":"+registration.getHost()+","+registration.getPort()+","+registration.getServiceId();
	    }
	   
	   @GetMapping(value="/test",produces=MediaType.APPLICATION_JSON_VALUE)
	    public String test(@RequestParam String name) {
	        return name +":"+registration.getHost()+","+registration.getPort()+","+registration.getServiceId();
	    }
	   
	   @GetMapping(value="/pxd",produces=MediaType.APPLICATION_JSON_VALUE)
	   @ApiOperation("获取pxd")
	   public String getString() {
		   List<Map<String, String>> resultMap = this.testService.getTestData();
		   log.info("获取pxdpxdpxdpxd的日志");
		   return "{\"abc\":\"this is pxd"+resultMap.toString()+"\"}";
	   }

}
