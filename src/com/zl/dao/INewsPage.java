package com.zl.dao;

import java.util.List;

import com.zl.bean.NewsComment;

public interface INewsPage {
	/**
	 * ����������
	 */
	public int getCount();
	/**
	 * ��ʾָ��ҳ 
	 * pageId:ҳ��
	 */
	public List<Object> queryByPage(int pageId);
}
