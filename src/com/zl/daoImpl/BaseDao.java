package com.zl.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zl.util.ConfigUtil;

/**
 * 创建数据库连接 关闭数据库连接
 */
public class BaseDao {
	private static ConfigUtil cfu =ConfigUtil.getInstance();
	/**
	 * 步骤一:添加驱动
	 * static块中使用的变量名必须是static修饰
	 */
	static {
		// 通过反射将类的对象创建(程序运行时)
		try {
			Class.forName(cfu.getPropertyValue("jdbc.driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("加载驱动包出错");
		}
	}
	private static String url = cfu.getPropertyValue("jdbc.connection.url");
	private static String user = cfu.getPropertyValue("jdbc.connection.user");
	private static String password = cfu.getPropertyValue("jdbc.connection.password");

	// 创建连接
	public Connection getConnection() {
		Connection resultCon = null;
		try {
			resultCon = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultCon;
	}

	// 关闭连接
	public void close(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void close(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
