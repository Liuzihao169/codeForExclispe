package com.heima.service;

import com.heima.domain.User;

public interface Userservice {
	User getUserByCodepassword(User u);
	void save(User u);
}
