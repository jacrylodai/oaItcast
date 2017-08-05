package com.ldp.oa.resource.domain;

import java.io.Serializable;
import java.util.Date;

public class Version implements Serializable{

	private Long versionId;
	
	private Long versionCode;
	
	private Date updateTime;
	
	private String title;
	
	private String content;
	
	private Kynamic kynamic;

	public Long getVersionId() {
		return versionId;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}

	public Long getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(Long versionCode) {
		this.versionCode = versionCode;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Kynamic getKynamic() {
		return kynamic;
	}

	public void setKynamic(Kynamic kynamic) {
		this.kynamic = kynamic;
	}
	
}
