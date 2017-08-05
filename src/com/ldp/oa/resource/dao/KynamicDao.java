package com.ldp.oa.resource.dao;

import java.util.List;

import com.ldp.oa.common.dao.BaseDao;
import com.ldp.oa.resource.domain.Kynamic;

public interface KynamicDao extends BaseDao<Kynamic> {

	public List<Kynamic> getKynamicListByPid(Long pid);

}
