package test;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import kr.ac.kopo.mybatis.MyConfig;

public class JUnitTest {
	@Test
	void test() throws Exception{
		SqlSession session = new MyConfig().getInstance();
		System.out.println(session);
		assertNotNull(session);
	}
}
