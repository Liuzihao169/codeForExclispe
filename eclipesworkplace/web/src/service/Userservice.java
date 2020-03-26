package service;

import dao.Userdao;

public class Userservice {
	// TODO Auto-generated method stub
	Userdao userdao=new Userdao();
	public int CheckUsername(String username) {
	
		return userdao.CheckUsername(username);
	}

}
