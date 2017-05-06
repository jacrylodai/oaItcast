package com.ldp.oa.basedata.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ldp.oa.basedata.domain.Post;
import com.ldp.oa.basedata.service.PostService;
import com.ldp.oa.common.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

@Controller(value="postAction")
@Scope(value="prototype")
public class PostAction extends BaseAction<Post> {
	
	@Resource(name="postService")
	private PostService postService;

	public String listPost() throws Exception{
		
		Collection<Post> postList = postService.getAllEntity();

		ValueStack valueStack = ServletActionContext.getContext().getValueStack();
		valueStack.getContext().put("postList", postList);
		
		return LIST_SUCCESS;
	}

	public String savePreparePost() throws Exception{
		
		return SAVE_PREPARE_SUCCESS;
	}
	
	public String savePost() throws Exception{

		Post model = getModel();
		Post post = new Post();
		
		BeanUtils.copyProperties(model, post);
		
		postService.saveEntity(post);
		
		return REDIRECT_TO_LIST_ACTION;
	}

	public String updatePreparePost() throws Exception{
		
		Post model = getModel();
		
		Post post = postService.getEntityById(model.getPostId());

		ValueStack valueStack = ServletActionContext.getContext().getValueStack();
		valueStack.push(post);
		
		return UPDATE_PREPARE_SUCCESS;
	}

	public String updatePost() throws Exception{
		
		Post model = getModel();
		Post post = postService.getEntityById(model.getPostId());
		
		BeanUtils.copyProperties(model, post);
		
		postService.updateEntity(post);
		
		return REDIRECT_TO_LIST_ACTION;
	}
	
	public String deletePost() throws Exception{
		
		Post model = getModel();
		
		postService.deleteEntityById(model.getPostId());
		
		return REDIRECT_TO_LIST_ACTION;
	}
	
}
