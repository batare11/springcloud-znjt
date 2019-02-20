package brilliance.znjt.eurekacomsumer.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import brilliance.znjt.eurekacomsumer.hystrix.TestFallBackFactory;

/*@FeignClient(name = "producer-service",fallback = TestInterfaceHystrix.class)*/
@FeignClient(name = "producer-service",fallbackFactory = TestFallBackFactory.class)
public interface TestInterface {

	@PostMapping(value = "/produce/hello")
	public String hello(@RequestBody String name);/*post用RequestBody,get用RequestParam(value='name')*/

}
