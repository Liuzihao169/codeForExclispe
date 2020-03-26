package com.heima.dao.mapper;

import java.util.List;

import com.heima.bean.QueryVo;
import com.heima.bean.User;

public interface UserMapper {
	public User findbyid(Integer id);
    //方法不能重载
	public void setuser(User u);
	public List<User> findbylikeQueryVo(QueryVo vo);
	public List<User> findbyIds(QueryVo vo);
	public List<User>findbySexandUsername(User user);
	public List<User> findbyIds( Integer[]ids);
	public List<User> findbyIds(List<Integer> idsList);
   //查询user的时候附带查询 orderlist
	public List <User>findUsers();
}
