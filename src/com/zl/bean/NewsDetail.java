package com.zl.bean;

import java.sql.Timestamp;

public class NewsDetail {
	private Integer id;
	private Integer categoryId;
	private String title;
	private String summary;
	private String content;
	private String picPath;//图片地址:指的是tomcat中的路径
	private String author;//作者
	private Timestamp createDate;
	private Timestamp modifyDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		if(categoryId==null){
			return 1;
		}else{
			return categoryId;
		}
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		if(title==null){
			return "";
		}else{
			return title;
		}
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
	public String getPicPath() {
		if(picPath==null){
			return "";
		}else{
			return picPath;
		}
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getAuthor() {
		if(author==null){
			return "";
		}else{
			return author;
		}
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getSummary() {
		if(summary==null){
			return "";
		}else{
			return summary;
		}
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
}
