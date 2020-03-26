package service;

import java.sql.SQLException;

import dao.LoginDao;
import domain.User;

public class LoginService {
        LoginDao loginDao=new LoginDao();
	public User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return loginDao.login(username,password);
	}

}
