package kr.ac.kopo.user.service;

import kr.ac.kopo.login.vo.LoginVO;
import kr.ac.kopo.user.dao.UserDAO;
import kr.ac.kopo.user.dao.UserDAOImpl;
import kr.ac.kopo.user.vo.UserVO;

public class UserService {
	private UserDAO userDao;
	
	
	public UserService() {
		userDao = new UserDAOImpl();
	}
	public void insertUser(UserVO user) throws Exception {
		userDao.insertUser(user);
	}
	public UserVO login(LoginVO log) {
		UserVO user = userDao.selectUser(log);
		return user;
	}

}
