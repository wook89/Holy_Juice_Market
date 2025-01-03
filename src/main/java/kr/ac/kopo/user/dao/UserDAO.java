package kr.ac.kopo.user.dao;

import kr.ac.kopo.login.vo.LoginVO;
import kr.ac.kopo.user.vo.UserVO;

public interface UserDAO{

	void insertUser(UserVO user) throws Exception;

	UserVO selectUser(LoginVO log);

	UserVO selectOneUser(int user_no);

	void updateUserInfo(UserVO user);
}
