package com.zl.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取属性文件
 * ConfigUtil:单例模式。节省内存
 */
/**
 * 单例不能够new
 * 但是要有唯一的实例(
 * 	同一个用户
 *  所有用户
 * )
 */
public class ConfigUtil {
	//声明properties
	private Properties pt  = null;
	//声明单例对象
	private static ConfigUtil cfu = null;
	private ConfigUtil(){
		pt = new Properties();

		try {
			//输入流加载数据
			//InputStream is = new FileInputStream("src/db.properties");
			InputStream is = ConfigUtil.class.getResourceAsStream("/db.properties");
			pt.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//getInstance():
	public synchronized static ConfigUtil getInstance(){
		if(cfu==null){
			cfu = new ConfigUtil();
		}
		return cfu;
	}
	//传入key返回对应的value
	public String getPropertyValue(String key){
		return pt.getProperty(key);
	}
}
