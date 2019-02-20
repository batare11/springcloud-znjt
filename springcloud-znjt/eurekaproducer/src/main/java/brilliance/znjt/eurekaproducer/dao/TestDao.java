package brilliance.znjt.eurekaproducer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestDao {
    
	/*@Select("select * from userinfo")*/
	List<Map<String, String>> getTestData();

}
