package com.test;

import java.util.Date;

import com.zl.daoImpl.NewsCommentDao;

public class Test {
	public static void main(String[] args) throws Exception  {
			NewsCommentDao dao = new NewsCommentDao();
			//添加
			/*dao.add(2, 
					"树上有两只乌鸦,底下有一只羊。过了会儿,来了一只狼把羊吃了.一只乌鸦被**了?为什么?","小红", 
					"121.22.22.333", 
					new Date());*/
			//删除
			//dao.remove(4);
			//修改
			dao.update(1,2, 
					"树上有两只乌鸦,底下有一只羊。过了会儿,来了一只狼把羊吃了.一只乌鸦被**了?为什么?","小红", 
					"121.22.22.333", 
					new Date());
			//添加2
			/*dao.add2(2, 
					"猪撞树上了,******","小红", 
					"121.22.22.333", 
					new Date());*/
			//查询
			dao.queryAll();
		
	}
}
