package com.test;

import java.util.Date;

import com.zl.daoImpl.NewsCommentDao;

public class Test {
	public static void main(String[] args) throws Exception  {
			NewsCommentDao dao = new NewsCommentDao();
			//���
			/*dao.add(2, 
					"��������ֻ��ѻ,������һֻ�򡣹��˻��,����һֻ�ǰ������.һֻ��ѻ��**��?Ϊʲô?","С��", 
					"121.22.22.333", 
					new Date());*/
			//ɾ��
			//dao.remove(4);
			//�޸�
			dao.update(1,2, 
					"��������ֻ��ѻ,������һֻ�򡣹��˻��,����һֻ�ǰ������.һֻ��ѻ��**��?Ϊʲô?","С��", 
					"121.22.22.333", 
					new Date());
			//���2
			/*dao.add2(2, 
					"��ײ������,******","С��", 
					"121.22.22.333", 
					new Date());*/
			//��ѯ
			dao.queryAll();
		
	}
}
