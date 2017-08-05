package com.ldp.oa.resource.dao;

import com.ldp.oa.common.dao.BaseDao;
import com.ldp.oa.resource.domain.Version;

public interface VersionDao extends BaseDao<Version>{

	public void deleteVersionByKynamicId(Long kynamicId);

}
