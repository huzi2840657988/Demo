package com.test;

import java.util.List;
import java.util.Scanner;

import com.zl.bean.NewsComment;
import com.zl.daoImpl.NewsCommentDao;
import com.zl.util.Page;

public class Test5 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		NewsCommentDao ncDao = new NewsCommentDao();
		/*
		 * ��������ÿҳ�����ʾ������
		 */
		//��ǰҳ
		int current = 1;
		//����������
		int count = ncDao.getCount();
		System.out.println(count);
		int page = count/Page.NEWSCOUNT;
		//Ҫ�����ҳ��
		if(count%Page.NEWSCOUNT!=0){
			page+=1;
		}
		System.out.println("��ҳ��:"+page+"-������:"+count+"-��ǰҳ:"+current);
		System.out.println("��ǰҳ:");
		/*List<NewsComment> currentList =  ncDao.queryByPage(current);
		for(int i = 0;i<currentList.size();i++){
   			NewsComment item = currentList.get(i);
   			System.out.print(item.getId()+"\t");
   			System.out.print(item.getNewsId()+"\t");
   			System.out.print(item.getContent()+"\t");
   			System.out.print(item.getAuthor()+"\t");
   			System.out.print(item.getIp()+"\t");
   			System.out.print(item.getCreateDate()+"\n");
   		}
		System.out.println("--------------------------------");
		System.out.println("������Ҫ����ҳ��:");
		int pageId = input.nextInt();
		List<NewsComment> list =  ncDao.queryByPage(pageId);
		for(int i = 0;i<list.size();i++){
   			NewsComment item = list.get(i);
   			System.out.print(item.getId()+"\t");
   			System.out.print(item.getNewsId()+"\t");
   			System.out.print(item.getContent()+"\t");
   			System.out.print(item.getAuthor()+"\t");
   			System.out.print(item.getIp()+"\t");
   			System.out.print(item.getCreateDate()+"\n");
   		}*/
	}
}
