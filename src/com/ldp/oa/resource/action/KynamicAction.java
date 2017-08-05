package com.ldp.oa.resource.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ldp.oa.common.action.BaseAction;
import com.ldp.oa.resource.actionform.KynamicForm;
import com.ldp.oa.resource.domain.Kynamic;
import com.ldp.oa.resource.service.KynamicService;
import com.ldp.oa.utils.validate.StringUtil;

@Controller("kynamicAction")
@Scope("prototype")
public class KynamicAction extends BaseAction<KynamicForm> {
	
	@Resource(name="kynamicService")
	private KynamicService kynamicService;
	
	private List<Kynamic> kynamicList;
	
	private Kynamic modifyKynamic;

	public List<Kynamic> getKynamicList() {
		return kynamicList;
	}

	public Kynamic getModifyKynamic() {
		return modifyKynamic;
	}

	public String listKynamicListByPid() throws Exception{
		
		KynamicForm model = getModel();
		Long pid = model.getPid();
		
		kynamicList = kynamicService.getKynamicListByPid(pid);
		
		return SUCCESS;
	}

	public String listKynamic() throws Exception{
		
		return LIST_SUCCESS;
	}
	
	public String saveKynamic() throws Exception{
		
		KynamicForm model = getModel();
		Kynamic kynamic = new Kynamic();
		
		BeanUtils.copyProperties(model, kynamic);
		
		Long pid = kynamic.getPid();
		Kynamic parentKynamic = kynamicService.getEntityById(pid);
		if(parentKynamic == null){
			throw new RuntimeException("父节点不存在");
		}
		
		kynamicService.saveEntity(kynamic);
		
		modifyKynamic = kynamic;
		
		return SUCCESS;
	}
	
	public String deleteKynamic() throws Exception{
		
		KynamicForm model = getModel();
		Long kynamicId = model.getKynamicId();
		
		if(kynamicId == Kynamic.ROOT_ID){
			throw new RuntimeException("不能删除根目录");
		}
		Kynamic kynamic = kynamicService.getEntityById(kynamicId);
		kynamicService.deleteKynamic(kynamic);
		return SUCCESS;
	}
	
	public String updateKynamic() throws Exception{
		
		KynamicForm model = getModel();
		Long kynamicId = model.getKynamicId();
		String kynamicName = model.getKynamicName();

		Kynamic kynamic = kynamicService.getEntityById(kynamicId);
		if(StringUtil.isEmpty(kynamicName)){
			throw new RuntimeException("名称不能为空");
		}
		kynamic.setKynamicName(kynamicName);
		
		kynamicService.updateEntity(kynamic);
		return SUCCESS;
	}
}
