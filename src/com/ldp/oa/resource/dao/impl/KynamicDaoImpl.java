package com.ldp.oa.resource.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ldp.oa.common.dao.impl.BaseDaoImpl;
import com.ldp.oa.resource.dao.KynamicDao;
import com.ldp.oa.resource.domain.Kynamic;

@Repository("kynamicDao")
public class KynamicDaoImpl extends BaseDaoImpl<Kynamic> implements KynamicDao {

	@Override
	public List<Kynamic> getKynamicListByPid(Long pid) {
		
		List<Kynamic> kynamicList = 
			hibernateTemplate.find("from Kynamic kynamic where kynamic.pid=?",pid);
		return kynamicList;
	}

}
