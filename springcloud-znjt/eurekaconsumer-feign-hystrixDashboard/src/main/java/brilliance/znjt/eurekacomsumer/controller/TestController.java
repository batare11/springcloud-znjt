package brilliance.znjt.eurekacomsumer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import brilliance.znjt.eurekacomsumer.interfaces.TestInterface;

@RestController
@RequestMapping(value = "/consume")
public class TestController {
	
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Autowired
    private RedisTemplate redisTemplate;
	
	@Autowired
	TestInterface testInterface;

	@RequestMapping(value="/hello",produces=MediaType.APPLICATION_JSON_VALUE)
    public String hello(@RequestParam(value = "name") String name){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();
        HttpSession session = request.getSession(true);
        session.setAttribute("uid", name);
        stringRedisTemplate.opsForValue().set("userNum", name);
		return testInterface.hello(name)+":tokenid is "+session.getId();

    }
	
	@RequestMapping(value="/layout",produces=MediaType.APPLICATION_JSON_VALUE)
    public String layout(@RequestParam(value = "name") String name){
		String valueOFkey = stringRedisTemplate.opsForValue().get("userNum");
		/*stringRedisTemplate.delete("029b7a0c-8c06-4d4b-b27b-c0585851f994");*/
		stringRedisTemplate.delete("userNum");
		/*return "123";*/
		return valueOFkey;
    }
	




}
