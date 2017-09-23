package com.test;

import java.util.Date;

import com.zl.daoImpl.NewsCommentDao;
import com.zl.daoImpl.NewsDetailDao;
import com.zl.util.DateUtil;

public class Test4 {
	public static void main(String[] args) throws Exception {
		/*NewsCommentDao dao = new NewsCommentDao();
		Object[] objArray = {2, "新树上有两只乌鸦,底下有一只羊。过了会儿,来了一只狼把羊吃了.一只乌鸦被**了?为什么?","小红","121.22.22.333",DateUtil.parseDate(new Date())};
		int i=0;
		while(i<5000){
			dao.add(objArray);//增加
			i++;
			System.out.println("第"+i+"次");
		}
		dao.queryAll();//查询
*/	
		NewsDetailDao dao = new NewsDetailDao();
		Object[] objArray = {2, "水浒传","大郎传","我是武大郎,家住阳谷县隔壁。家境殷实,从小变....。但是没想到在小学一年级身高就达到了人生巅峰.....","吴用",DateUtil.parseDate(new Date()),DateUtil.parseDate(new Date())};
		int i=0;
		while(i<2000){
			dao.add(objArray);//增加
			i++;
			System.out.println("第"+i+"次");
		}
	}
	/**
	 *  toHos(new Dog());
	 *  Pet:
	 *  	method(){
	 *  	syso("注射");	
	 *  	}
	 *  Dog:
	 *  	method(){
	 *  	 syso("打针吃药");
	 *  	}
	 *  Penguin:
	 *  	method(){
	 *  	 syso("疗养");
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
