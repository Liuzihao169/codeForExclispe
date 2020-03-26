package com.heima.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heima.bos.entity.Function;
import com.heima.bos.entity.Role;
import com.heima.dao.FunctionDao;
import com.heima.dao.RoleDao;
import com.heima.service.RoleService;
import com.heima.utils.PageBean;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private FunctionDao functionDao;
	@Override
	public void save(Role model, String functionIds) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(functionIds)){
			String[] split = functionIds.split(",");
			for (String id : split) {
				//set���ϲ�����洢��ͬ��Ԫ��
				//������ֱ�� ��һ�������״̬��function ���������ٲ�ѯһ�����ݿ�
				Function function = functionDao.findById(id);
				model.getFunctions().add(function);
			}
			roleDao.save(model);
		}
	}
	/*
	 * 
	 * �ڶ��ַ��� �ǿ���  �ȳ־û�model�������Ȼ�����ó־û�����ĸı�ᶯ̬Ӱ�����ݿ�ĸı������ Ȼ��ά����ϵ
	 */
	public void pageQuery(PageBean pageBean) {
		roleDao.pageQuery(pageBean);
	}
	public List<Role> findAll() {
		List<Role> list = roleDao.findAll();
		return list;
	}
}
