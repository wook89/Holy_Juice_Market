package kr.ac.kopo.user.dao;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.login.vo.LoginVO;
import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.user.vo.UserVO;

public class UserDAOImpl implements UserDAO {
	
	private SqlSession sqlSession;
	public UserDAOImpl() {
		sqlSession = new MyConfig().getInstance();
	}

	@Override
	public void insertUser(UserVO user) throws Exception {
		System.out.println("직전 찍히냐");
		System.out.println(user.toString());
		sqlSession.insert("dao.UserDAO.insertUser",user);
		sqlSession.commit();
	}

	@Override
	public UserVO selectUser(LoginVO log) {
		sqlSession.clearCache();
		UserVO user = sqlSession.selectOne("dao.UserDAO.selectUser", log);
		return user;
	}

	@Override
	public UserVO selectOneUser(int user_no) {
		sqlSession.clearCache();
		return sqlSession.selectOne("dao.UserDAO.selectOneUser", user_no);
	}

	@Override
	public void updateUserInfo(UserVO user) {
		sqlSession.update("dao.UserDAO.updateUserInfo",user);
		sqlSession.commit();
	}
}
