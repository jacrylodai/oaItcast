package com.ldp.oa.basedata.action;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ldp.oa.basedata.actionform.UserForm;
import com.ldp.oa.basedata.domain.Department;
import com.ldp.oa.basedata.domain.Post;
import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.basedata.service.DepartmentService;
import com.ldp.oa.basedata.service.PostService;
import com.ldp.oa.basedata.service.UserService;
import com.ldp.oa.common.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<UserForm>{

	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	@Resource(name="postService")
	private PostService postService;
	
	private Boolean usernameValid;
	
	public Boolean getUsernameValid() {
		return usernameValid;
	}

	public String listUser() throws Exception{
		
		Collection<User> userList = userService.getAllEntity();
		
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.push(userList);
		
		return LIST_SUCCESS;
	}

	public String savePrepareUser() throws Exception{
		
		Collection<Department> departmentList = departmentService.getAllEntity();
		
		Collection<Post> postList = postService.getAllEntity();
		
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.getContext().put("departmentList", departmentList);
		valueStack.getContext().put("postList", postList);
		
		return SAVE_PREPARE_SUCCESS;	
	}

	public String saveUser() throws Exception{
		
		UserForm model = getModel();
		
		User user = new User();
		
		BeanUtils.copyProperties(model, user);
		
		Department department = departmentService.getEntityById(model.getDepartmentId());
		user.setDepartment(department);
		
		List<Long> postIdList = model.getPostIdList();
		Set<Post> postSet = new HashSet<Post>();
		
		for(Long postId:postIdList){
			Post post = postService.getEntityById(postId);
			postSet.add(post);
		}
		user.setPostSet(postSet);
		
		userService.saveEntity(user);
		
		return REDIRECT_TO_LIST_ACTION;
	}
	
	public String checkUserByUsername() throws Exception{
		
		UserForm model = getModel();
		String username = model.getUsername();
		
		User user = userService.getUserByUsername(username);
		
		if(user == null){
			usernameValid = true;
		}else{
			usernameValid = false;
		}
		
		return SUCCESS;
	}
	
}
