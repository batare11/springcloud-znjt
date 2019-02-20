package brilliance.znjt.eurekacomsumer;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

@EnableDiscoveryClient
@SpringBootApplication
/*@SpringCloudApplication 这个注解包含了上述三个注解*/
@EnableFeignClients
/*Hystrix Dashboard start*/
@EnableHystrixDashboard
@EnableCircuitBreaker
/*Hystrix Dashboard end*/
/*@EnableEurekaClient 目前没用*/
public class EurekaConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumeApplication.class, args);
    }
    
    @Bean
    public ServletRegistrationBean getServlet() {
      HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
      ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
      registrationBean.setLoadOnStartup(1);
      registrationBean.addUrlMappings("/hystrix.stream");
      registrationBean.setName("HystrixMetricsStreamServlet");
      return registrationBean;
    }
    
}
