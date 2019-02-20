package brilliance.znjt.eurekaproducer.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/*@Configuration*/
public class DataSourceConfigure {
	
	@Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource") // application.yml中对应属性的前缀
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
	
}
