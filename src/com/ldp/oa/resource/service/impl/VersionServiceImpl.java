package com.ldp.oa.resource.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldp.oa.common.dao.BaseDao;
import com.ldp.oa.common.service.impl.BaseServiceImpl;
import com.ldp.oa.resource.dao.VersionDao;
import com.ldp.oa.resource.domain.Version;
import com.ldp.oa.resource.service.VersionService;

@Service("versionService")
public class VersionServiceImpl extends BaseServiceImpl<Version> implements VersionService{

	@Resource(name="versionDao")
	private VersionDao versionDao;
	
	@Override
	protected BaseDao<Version> getBaseDao() {
		return versionDao;
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteVersionByKynamicId(Long kynamicId) {
		
		versionDao.deleteVersionByKynamicId(kynamicId);
	}

}
