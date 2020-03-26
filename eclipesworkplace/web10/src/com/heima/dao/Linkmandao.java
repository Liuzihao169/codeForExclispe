package com.heima.dao;

import java.util.List;

import com.heima.domain.Customer;
import com.heima.domain.LinkMan;

public interface Linkmandao {

	Customer findCusByid(Long cus_id);

	void save(LinkMan linkman);

	List<LinkMan> findlinkmanList();

	List<LinkMan> findlinklistByname(String lkm_name);

}
