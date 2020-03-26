package com.heima.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.heima.bos.entity.Decidedzone;
import com.heima.bos.entity.Subarea;
import com.heima.dao.DecidedzoneDao;
import com.heima.dao.SubareaDao;
import com.heima.service.DecidedzoneService;
import com.heima.utils.PageBean;
@Service
@Transactional
public class DecidedzoneServiceImpl implements DecidedzoneService {
	@Autowired
	private DecidedzoneDao decidedzone;
	@Autowired
	private SubareaDao subareaDao;
	public void save(Decidedzone model, String[] subareaid) {
		//һ��һ���Ѿ�����ά����ϵ�����һ����������ά����ϵ��
		decidedzone.save(model);
		//�־û�״̬������Ȼ��������  �־û������ݶ���ĸı䣬��ֱ��Ӱ�����ݿ�����ĸı�
		for (String id : subareaid) {
			Subarea subarea = subareaDao.findById(id);
			subarea.setDecidedzone(model);
		}	
	}
	public void pageQuery(PageBean pageBean) {
		decidedzone.pageQuery(pageBean);
	}
}
