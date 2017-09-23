package com.zl.dao;

import java.util.List;

import com.zl.bean.NewsComment;

public interface INewsPage {
	/**
	 * 计算总数量
	 */
	public int getCount();
	/**
	 * 显示指定页 
	 * pageId:页号
	 */
	public List<Object> queryByPage(int pageId);
}
