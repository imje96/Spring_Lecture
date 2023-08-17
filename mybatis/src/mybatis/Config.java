package mybatis;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Config {
	private SqlSession sqlSession;
	
	public Config() {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream 
				= Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory 
				= new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession 
				= sqlSessionFactory.openSession();
			
		} catch (Exception e) {
		}
	}
}
