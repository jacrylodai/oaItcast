package com.ldp.oa.resource.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldp.oa.common.dao.BaseDao;
import com.ldp.oa.common.service.impl.BaseServiceImpl;
import com.ldp.oa.resource.dao.KynamicDao;
import com.ldp.oa.resource.dao.VersionDao;
import com.ldp.oa.resource.domain.Kynamic;
import com.ldp.oa.resource.service.KynamicService;
import com.ldp.oa.resource.service.VersionService;

@Service("kynamicService")
public class KynamicServiceImpl extends BaseServiceImpl<Kynamic> implements KynamicService {

	@Resource(name="kynamicDao")
	private KynamicDao kynamicDao;
	
	@Resource(name="versionService")
	private VersionService versionService;
	
	@Override
	protected BaseDao<Kynamic> getBaseDao() {
		return kynamicDao;
	}

	@Override
	public List<Kynamic> getKynamicListByPid(Long pid) {
		
		return kynamicDao.getKynamicListByPid(pid);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteKynamic(Kynamic kynamic) {

		if(kynamic.getIsParent()){
			List<Kynamic> childKynamicList = getKynamicListByPid(kynamic.getKynamicId());
			for(Kynamic childKynamic:childKynamicList){
				deleteKynamic(childKynamic);
			}
			deleteFolder(kynamic);
		}else{
			deleteNode(kynamic);
		}
	}
	
	private void deleteNode(Kynamic kynamic){
		
		if(kynamic.getIsParent()){
			throw new RuntimeException("只能删除节点");
		}
		versionService.deleteVersionByKynamicId(kynamic.getKynamicId());
		kynamicDao.deleteEntity(kynamic);
	}
	
	private void deleteFolder(Kynamic kynamic){
		if(!kynamic.getIsParent()){
			throw new RuntimeException("只能删除文件夹");
		}
		kynamicDao.deleteEntity(kynamic);
	}

}
