package brilliance.znjt.eurekacomsumer;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
/*@SpringCloudApplication 这个注解包含了上述三个注解*/
public class EurekaConsumeApplication {
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
	    return new RestTemplate();
	}

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumeApplication.class, args);
    }
}
