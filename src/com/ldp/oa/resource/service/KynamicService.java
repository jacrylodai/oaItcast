package com.ldp.oa.resource.service;

import java.util.List;

import com.ldp.oa.common.service.BaseService;
import com.ldp.oa.resource.domain.Kynamic;

public interface KynamicService extends BaseService<Kynamic>{

	public List<Kynamic> getKynamicListByPid(Long pid);

	public void deleteKynamic(Kynamic kynamic);

}
