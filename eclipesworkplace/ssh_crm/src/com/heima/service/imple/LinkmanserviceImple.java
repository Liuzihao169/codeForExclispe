package com.heima.service.imple;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.dao.Linkmandao;
import com.heima.domain.LinkMan;
import com.heima.service.Linkmanservice;
import com.heima.utils.PageBean;

public class LinkmanserviceImple implements Linkmanservice {
	private Linkmandao linkmandao;
	
	@Override
	public PageBean getpagebean(DetachedCriteria criteria, Integer currentCount, Integer currentPage) {
		Integer totalCount = linkmandao.findcountByname(criteria);
		PageBean pb=new PageBean(currentPage, currentCount, totalCount);
		List<LinkMan> findlist = linkmandao.findlist(criteria, pb.getIndex(),pb.getCurrentCount());
		pb.setList(findlist);
		return pb ;
	}
	@Override
	public void saveOrUpdate(LinkMan lm) {
		linkmandao.saveOrUpdate(lm);
	}
	public void setLinkmandao(Linkmandao linkmandao) {
		this.linkmandao = linkmandao;
	}
	@Override
	public LinkMan getById(Long lkm_id) {
		// TODO Auto-generated method stub
		return linkmandao.getByid(lkm_id) ;
	}
	
}
