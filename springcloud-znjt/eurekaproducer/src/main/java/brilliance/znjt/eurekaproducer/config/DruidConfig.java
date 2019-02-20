package brilliance.znjt.eurekaproducer.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {
	/**
     * 配置Druid的属性，和DataSource进行绑定，前缀设置为：spring.datasource
     * 不配置的话，很多初始化的属性是没有绑定的
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource druid() {
        return new DruidDataSource();
    }
    
    /**
     * 配置druid监控
     * 配置一个管理后台的servlet
     * 访问地址：http://localhost:8080/druid/
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet());
        bean.setServlet(new StatViewServlet());
        bean.addUrlMappings("/druid/*");
        //添加初始化参数：initParams
        Map<String, String> initParameters = new HashMap<String, String>();
        //登录查看信息的账号密码.
        initParameters.put("loginUsername", "admin");//属性见：com.alibaba.druid.support.http.ResourceServlet
        initParameters.put("loginPassword", "123456");
        //白名单
        initParameters.put("allow", "");//默认允许所有,可设置本地,即"127.0.0.1"
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        initParameters.put("deny", "");
        //是否能够重置数据.
        initParameters.put("resetEnable", "false");
        bean.setInitParameters(initParameters);
        return bean;
    }
    
    /**
     * 配置一个web监控的filter
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> filterBean = new FilterRegistrationBean<WebStatFilter>();
        filterBean.setFilter(new WebStatFilter());
        //添加过滤规则.
        filterBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        Map<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("exclusions", /*"*.js,*.css,/druid/*"*/"*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");//属性见：com.alibaba.druid.support.http.WebStatFilter
        filterBean.setInitParameters(initParameters);
        return filterBean;
    }
}
