package com.heima.service;

import java.util.List;

import com.heima.domain.LinkMan;

public interface Linkmanservice {

	void save(LinkMan linkman);

	List<LinkMan> findLinkman();

	List<LinkMan> findlinklistByname(String lkm_name);

}
