package com.ldp.oa.basedata.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldp.oa.basedata.dao.PostDao;
import com.ldp.oa.basedata.domain.Post;
import com.ldp.oa.basedata.service.PostService;
import com.ldp.oa.common.dao.BaseDao;
import com.ldp.oa.common.service.impl.BaseServiceImpl;
import com.ldp.oa.utils.proj.DeleteMode;

@Service(value="postService")
public class PostServiceImpl extends BaseServiceImpl<Post> implements PostService {

	@Resource(name="postDao")
	private PostDao postDao;
	
	@Override
	protected BaseDao<Post> getBaseDao() {
		return postDao;
	}
	
	@Override
	@Transactional(readOnly=false)
	public void deleteEntityById(Serializable id) {
		postDao.deletePostById(id, DeleteMode.DELETE_MODE_PRE_DETACH);
	}

}
