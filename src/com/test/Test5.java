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
		 * 总条数和每页最多显示多少条
		 */
		//当前页
		int current = 1;
		//计算总条数
		int count = ncDao.getCount();
		System.out.println(count);
		int page = count/Page.NEWSCOUNT;
		//要求算出页数
		if(count%Page.NEWSCOUNT!=0){
			page+=1;
		}
		System.out.println("总页数:"+page+"-总条数:"+count+"-当前页:"+current);
		System.out.println("当前页:");
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
		System.out.println("请输入要看的页数:");
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
