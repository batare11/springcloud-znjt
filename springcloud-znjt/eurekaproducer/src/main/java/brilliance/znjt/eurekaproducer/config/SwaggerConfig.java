package brilliance.znjt.eurekaproducer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Pengxd
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket createRestApi() {
	        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("brilliance.znjt.eurekaproducer.controller"))
	            .paths(PathSelectors.any()).build();
	}
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	        .title("eurekaproducer构建RESTful APIs")
	        .description("producer-api")
	        .termsOfServiceUrl("http://192.168.66.77:8001/swagger-ui.html")
	        .version("1.0").build();
	    }
}
