package mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 팩터리 빌더에서 sql 세션 가져오기  
public class Config {
    private SqlSession sqlSession;

    public Config() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream 
            	= Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory 
            	= new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            System.out.println(sqlSession);
           
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    public SqlSession getSqlSession() {
       return sqlSession;
    }
}