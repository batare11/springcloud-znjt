package brilliance.znjt.eurekaproducer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brilliance.znjt.eurekaproducer.dao.TestDao;
import brilliance.znjt.eurekaproducer.service.TestService;

@Service
public class TestServiceImpl implements TestService{
  
	private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);
	
	@Autowired
	TestDao testDao;
	
	@Override
	public List<Map<String, String>> getTestData() {
		
		List<Map<String,String>> resultData = new ArrayList<>();
		
		try {
			resultData = testDao.getTestData();
			log.info("数据库中获取的测试数据是:"+resultData.toString());
		} catch (Exception e) {
			log.info("getTestData-错误信息："+e.getMessage());
		}
		return resultData;
	}
  
} 
