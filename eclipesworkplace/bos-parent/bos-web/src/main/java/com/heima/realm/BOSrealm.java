package com.heima.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.heima.bos.entity.Function;
import com.heima.bos.entity.User;
import com.heima.dao.FunctionDao;
import com.heima.dao.UserDao;

public class BOSrealm extends AuthorizingRealm{
	@Autowired
	private UserDao userDao;
	@Autowired
	private FunctionDao functionDao;
	@Override//认证管理
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken usernamePasswordToken =(UsernamePasswordToken)token;
		//获得用户输入的用户名
		String username = usernamePasswordToken.getUsername();
		User user=userDao.findUserByUserName(username);
		if(user==null){
			//说明用户名不存在
			return null;
		}//数据库密码与页面输入的密码是否一致（框架自己去比较）
	AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
		return info;
	}
	//授权管理
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//获得当前对象
		User user = (User) principals.getPrimaryPrincipal();
		//首先判断是不是管理员hhh用户 如果是管理员，就不用查表直接给全部的权限；
		List<Function> list= null;
		if(user.getUsername().equals("刘钊")){
			DetachedCriteria criteria = DetachedCriteria.forClass(Function.class);
		 list = functionDao.findByCreaitar(criteria);
		}else{//如果不是那么就通过 userid 查询所对应的权限
			list=functionDao.findFunctionByUserId(user.getId());
		}
		for (Function function : list) {
			info.addStringPermission(function.getCode());
		}
		return info;
	}
}
