package com.heima.service;

import com.heima.bos.entity.Decidedzone;
import com.heima.utils.PageBean;

public interface DecidedzoneService {

	void save(Decidedzone model, String[] subareaid);

	void pageQuery(PageBean pageBean);

}
