package com.test;

import java.util.Calendar;
import java.util.Date;

import com.zl.daoImpl.NewsDetailDao;
import com.zl.util.DateUtil;

public class Test2 {
	public static void main(String[] args) {
			NewsDetailDao dao = new NewsDetailDao();
			System.currentTimeMillis();//��ǰʱ���
			//��ȡָ������ʱ���:2016-01-03 15:36:08
			String dateString = "2016-01-03 15:36:08";
			//��һ��:��ǰ�˵�ҳ�洫�������ַ�������תΪjava.util.Date
			Date date = DateUtil.parseString(dateString);
			//�ڶ���:java.util.DateתΪ����ֵ
			System.out.println(date.getTime());
			//������:ʹ��jdbc��ʱ������浽���ݿ�
			//dao.add(date.getTime());
			//1451806568000
			Calendar cl = Calendar.getInstance();
			cl.setTimeInMillis(1451806568000l);
	}
}
