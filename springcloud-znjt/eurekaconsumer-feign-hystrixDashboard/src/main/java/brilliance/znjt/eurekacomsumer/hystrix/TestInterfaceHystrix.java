package brilliance.znjt.eurekacomsumer.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import brilliance.znjt.eurekacomsumer.interfaces.TestInterface;

/*不捕获异常用*/
@Component
public class TestInterfaceHystrix implements TestInterface{
	
	@Override
	public String hello(@RequestBody String name){
		return "service is error";
	}

}
