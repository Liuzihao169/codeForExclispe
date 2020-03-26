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
		//一的一方已经放弃维护关系，多的一方（分区来维护关系）
		decidedzone.save(model);
		//持久化状态的数据然后再利用  持久化的数据对象的改变，能直接影响数据库里面的改变
		for (String id : subareaid) {
			Subarea subarea = subareaDao.findById(id);
			subarea.setDecidedzone(model);
		}	
	}
	public void pageQuery(PageBean pageBean) {
		decidedzone.pageQuery(pageBean);
	}
}
