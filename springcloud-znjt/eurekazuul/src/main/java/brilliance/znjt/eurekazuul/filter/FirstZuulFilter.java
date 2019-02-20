package brilliance.znjt.eurekazuul.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

@Component
public class FirstZuulFilter extends ZuulFilter {

	@Override
	public Object run() {
		// 具体权限控制的业务逻辑
		return null;
	}

	@Override
	public boolean shouldFilter() {
		/*返回true的时候代表这个过滤器生效，返回false代表此过滤器不生效,可以做一定的逻辑处理*/
		return true;
	}

	@Override
	public int filterOrder() {
		/*过滤器的执行顺序,数值越小的越先执行*/
		return 0;
	}

	@Override
	public String filterType() {
		/*filterType的值有四个：pre代表请求被路由之前执行，routing代表在路由请求时调用，
		post代表在routing和error之后被调用，error请求出错是被调用*/
		System.out.println("FirstZuulFilter is called");
		return "pre";
	}

}
