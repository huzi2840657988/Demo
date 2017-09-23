package com.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest3 {
	public static void main(String[] args) throws Exception {
		//创建属性对象
		Properties pt = new Properties();
		//在流中加载
		InputStream is = new FileInputStream("src/db.properties");
		pt.load(is);
		is.close();//关闭流
		System.out.println(pt.getProperty("jdbc.driver"));
		System.out.println(pt.getProperty("jdbc.connection.url"));
		System.out.println(pt.getProperty("jdbc.connection.user"));
		System.out.println(pt.getProperty("jdbc.connection.password"));
	}
}
