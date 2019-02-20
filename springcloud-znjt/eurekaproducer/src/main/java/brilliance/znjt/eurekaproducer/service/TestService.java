package brilliance.znjt.eurekaproducer.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface TestService {

	List<Map<String, String>> getTestData();
  
} 
