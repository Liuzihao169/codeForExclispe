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
	@Override//��֤����
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken usernamePasswordToken =(UsernamePasswordToken)token;
		//����û�������û���
		String username = usernamePasswordToken.getUsername();
		User user=userDao.findUserByUserName(username);
		if(user==null){
			//˵���û���������
			return null;
		}//���ݿ�������ҳ������������Ƿ�һ�£�����Լ�ȥ�Ƚϣ�
	AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
		return info;
	}
	//��Ȩ����
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//��õ�ǰ����
		User user = (User) principals.getPrimaryPrincipal();
		//�����ж��ǲ��ǹ���Աhhh�û� ����ǹ���Ա���Ͳ��ò��ֱ�Ӹ�ȫ����Ȩ�ޣ�
		List<Function> list= null;
		if(user.getUsername().equals("����")){
			DetachedCriteria criteria = DetachedCriteria.forClass(Function.class);
		 list = functionDao.findByCreaitar(criteria);
		}else{//���������ô��ͨ�� userid ��ѯ����Ӧ��Ȩ��
			list=functionDao.findFunctionByUserId(user.getId());
		}
		for (Function function : list) {
			info.addStringPermission(function.getCode());
		}
		return info;
	}
}
