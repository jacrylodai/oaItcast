package com.ldp.oa.basedata.dao.impl;

import java.io.Serializable;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.ldp.oa.basedata.dao.PostDao;
import com.ldp.oa.basedata.domain.Post;
import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.common.dao.impl.BaseDaoImpl;
import com.ldp.oa.utils.proj.DeleteMode;

@Repository(value="postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {

	@Override
	public void deletePostById(Serializable id, int deleteMode) {

		Post post = getEntityById(id);
		
		switch (deleteMode) {
		case DeleteMode.DELETE_MODE_NORMAL:
			
			hibernateTemplate.delete(post);
			break;

		case DeleteMode.DELETE_MODE_PRE_DETACH:
			
			Set<User> userSet = post.getUserSet();
			for(User user:userSet){
				Set<Post> postSet = user.getPostSet();
				postSet.remove(post);
				hibernateTemplate.save(user);
			}
			
			hibernateTemplate.delete(post);
			break;

		case DeleteMode.DELETE_MODE_CASCADE:
			//do not support
			break;

		default:
			break;
		}
	}

}
