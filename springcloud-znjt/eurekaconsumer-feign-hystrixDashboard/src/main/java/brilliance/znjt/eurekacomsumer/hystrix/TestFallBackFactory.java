package brilliance.znjt.eurekacomsumer.hystrix;

import org.springframework.stereotype.Component;

import brilliance.znjt.eurekacomsumer.interfaces.TestInterface;
import feign.hystrix.FallbackFactory;

/*捕获异常用*/
@Component
public class TestFallBackFactory implements FallbackFactory<TestInterface>{
	
	 @Override
	 public TestInterface create(Throwable cause) {
	        return new TestInterface() {
	            @Override
	            public String hello(String name) {
	            	System.out.println(cause.getMessage());
	                return "service is error:"+cause.getMessage();
	            }
	        };
	    }


}
