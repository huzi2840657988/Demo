package com.test;

import java.util.Date;

import com.zl.daoImpl.NewsCommentDao;
import com.zl.daoImpl.NewsDetailDao;
import com.zl.util.DateUtil;

public class Test4 {
	public static void main(String[] args) throws Exception {
		/*NewsCommentDao dao = new NewsCommentDao();
		Object[] objArray = {2, "����������ֻ��ѻ,������һֻ�򡣹��˻��,����һֻ�ǰ������.һֻ��ѻ��**��?Ϊʲô?","С��","121.22.22.333",DateUtil.parseDate(new Date())};
		int i=0;
		while(i<5000){
			dao.add(objArray);//����
			i++;
			System.out.println("��"+i+"��");
		}
		dao.queryAll();//��ѯ
*/	
		NewsDetailDao dao = new NewsDetailDao();
		Object[] objArray = {2, "ˮ䰴�","���ɴ�","���������,��ס�����ظ��ڡ��Ҿ���ʵ,��С��....������û�뵽��Сѧһ�꼶��߾ʹﵽ�������۷�.....","����",DateUtil.parseDate(new Date()),DateUtil.parseDate(new Date())};
		int i=0;
		while(i<2000){
			dao.add(objArray);//����
			i++;
			System.out.println("��"+i+"��");
		}
	}
	/**
	 *  toHos(new Dog());
	 *  Pet:
	 *  	method(){
	 *  	syso("ע��");	
	 *  	}
	 *  Dog:
	 *  	method(){
	 *  	 syso("�����ҩ");
	 *  	}
	 *  Penguin:
	 *  	method(){
	 *  	 syso("����");
	 *  	}
	 *  public void toHos(Pet pet){
	 *  	if(){
	 *  		pet.method();
	 *  	}else{
	 *  		pet.method();
	 *  }
	 *  }
	 */
}
