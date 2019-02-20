package brilliance.znjt.eurekaproducer;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
public class EurekaProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProduceApplication.class, args);
    }
}
