package kr.ac.kopo.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyConfig {
	
	private SqlSession session;
	
	public MyConfig() {
		String resource = "kr/ac/kopo/mybatis/mybatis-config.xml";
		try{
		InputStream inputStream = Resources.getResourceAsStream(resource);
		System.out.println("인풋스트림 : "+inputStream);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println("세션팩토리 : "+sqlSessionFactory);
		
		session = sqlSessionFactory.openSession(true);
		System.out.println("세션 : "+session);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public SqlSession getInstance() {
		return session;
	}
}
