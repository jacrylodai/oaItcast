package com.ldp.oa.basedata.dao;

import java.io.Serializable;

import com.ldp.oa.basedata.domain.Post;
import com.ldp.oa.common.dao.BaseDao;

public interface PostDao extends BaseDao<Post>{

	public void deletePostById(Serializable id,int deleteMode);
	
}
