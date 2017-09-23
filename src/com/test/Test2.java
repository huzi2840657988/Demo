package com.test;

import java.util.Calendar;
import java.util.Date;

import com.zl.daoImpl.NewsDetailDao;
import com.zl.util.DateUtil;

public class Test2 {
	public static void main(String[] args) {
			NewsDetailDao dao = new NewsDetailDao();
			System.currentTimeMillis();//当前时间戳
			//获取指定日期时间戳:2016-01-03 15:36:08
			String dateString = "2016-01-03 15:36:08";
			//第一步:将前端的页面传过来的字符串日期转为java.util.Date
			Date date = DateUtil.parseString(dateString);
			//第二步:java.util.Date转为毫秒值
			System.out.println(date.getTime());
			//第三步:使用jdbc将时间戳保存到数据库
			//dao.add(date.getTime());
			//1451806568000
			Calendar cl = Calendar.getInstance();
			cl.setTimeInMillis(1451806568000l);
	}
}
