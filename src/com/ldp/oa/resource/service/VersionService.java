package com.ldp.oa.resource.service;

import com.ldp.oa.common.service.BaseService;
import com.ldp.oa.resource.domain.Version;

public interface VersionService extends BaseService<Version>{
	
	public void deleteVersionByKynamicId(Long kynamicId);

}
