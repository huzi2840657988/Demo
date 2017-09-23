package com.zl.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zl.bean.NewsComment;
import com.zl.dao.INewsPage;
import com.zl.util.DateUtil;
import com.zl.util.Page;

/**
 * 对数据表(news_comment)做增删改查操作
 * 
 * @author Administrator
 */
public class NewsCommentDao extends BaseDao implements INewsPage{
	/**
	 * 显示指定页 
	 * pageId:页号
	 */
	public List<Object> queryByPage(int pageId) {
		List<Object> resultList = new ArrayList<Object>();
		// 创建数据库连接
		Connection con = this.getConnection();
		// 创建执行对象
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			String sql = "SELECT * FROM news_comment limit ?,?";
			st = con.prepareStatement(sql);
			st.setInt(1, (pageId-1)*Page.NEWSCOUNT);
			st.setInt(2, Page.NEWSCOUNT);
			rs = st.executeQuery();
			// 处理返回的结果集(存储了执行对象从数据库获取的数据)
			while (rs.next()) {
				NewsComment nc = new NewsComment();// 创建javaBean
				nc.setId(rs.getInt("id"));
				nc.setNewsId(rs.getInt("newsId"));
				nc.setContent(rs.getString("content"));
				nc.setAuthor(rs.getString("author"));
				nc.setIp(rs.getString("ip"));
				nc.setCreateDate(rs.getTimestamp("createDate"));
				resultList.add(nc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 关闭资源
		this.close(con, st, rs);
		return resultList;
	}

	/**
	 * 计算总数量
	 */
	public int getCount() {
		String sql = "SELECT COUNT(1) FROM news_comment";
		// 获取数据库连接
		Connection con = this.getConnection();
		int result=-1;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			result = -1;
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 返回的类型应该是什么?
	 * 
	 * @throws Exception
	 */
	public List<NewsComment> queryAll() throws Exception {
		List<NewsComment> resultList = new ArrayList<NewsComment>();
		// 创建数据库连接
		Connection con = this.getConnection();
		// 创建执行对象
		Statement st = con.createStatement();
		String sql = "SELECT * FROM news_comment";
		ResultSet rs = st.executeQuery(sql);
		// 处理返回的结果集(存储了执行对象从数据库获取的数据)
		while (rs.next()) {
			NewsComment nc = new NewsComment();// 创建javaBean
			nc.setId(rs.getInt("id"));
			nc.setNewsId(rs.getInt("newsId"));
			nc.setContent(rs.getString("content"));
			nc.setAuthor(rs.getString("author"));
			nc.setIp(rs.getString("ip"));
			nc.setCreateDate(rs.getTimestamp("createDate"));
			resultList.add(nc);
		}
		// 关闭资源
		this.close(con, st, rs);
		return resultList;
	}

	/**
	 * 添加
	 * 
	 * @throws Exception
	 */
	public void add(Object[] param) throws Exception {
		// 创建数据库连接
		Connection con = this.getConnection();
		// 创建执行对象
		String sql = "INSERT INTO `news_comment`(`newsId`,`content`,`author`,`ip`,`createDate`)VALUES(?,?,?,?,?);";
		PreparedStatement pstmt = con.prepareStatement(sql);
		for (int i = 0; i < param.length; i++) {
			pstmt.setObject(i + 1, param[i]);
		}
		// 执行增加操作
		int rs = pstmt.executeUpdate();
		if (rs > 0) {
			System.out.println("增加成功!");
		}
		// 关闭资源
		this.close(con, pstmt);
	}

	public void add2(int newsId, String content, String author, String ip,
			Date createDate) throws Exception {
		// 创建数据库连接
		Connection con = this.getConnection();
		// 创建执行对象
		// Statement st = con.createStatement();
		String sql = "insert  into `news_comment`(`newsId`,`content`,`author`,`ip`,`createDate`) values (?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		System.out.println("处理?号占位符之前:" + sql);
		// 处理?号占位符
		// 把第1个问号的位置插入int类型newsId所对应的值;
		pstmt.setInt(1, newsId);
		pstmt.setString(2, content);
		pstmt.setString(3, author);
		pstmt.setString(4, ip);
		pstmt.setString(5, DateUtil.parseDate(createDate));
		System.out.println("处理?号占位符之后:" + sql);
		int rs = pstmt.executeUpdate();
		if (rs > 0) {
			System.out.println("增加成功!");
		}
		// 关闭资源
		this.close(con, pstmt);
	}

	/**
	 * @param id
	 *            :删除编号
	 * @throws Exception
	 */
	public void remove(int id) throws Exception {
		// 创建数据库连接
		Connection con = this.getConnection();
		// 创建执行对象
		Statement st = con.createStatement();
		String sql = "DELETE FROM `news_comment` WHERE id = " + id;
		// 执行删除操作
		int rs = st.executeUpdate(sql);
		if (rs > 0) {
			System.out.println("删除成功!");
		}
		// 关闭资源
		this.close(con, st);
	}

	/**
	 * 修改
	 */
	public void update(int id, int newsId, String content, String author,
			String ip, Date createDate) throws Exception {
		// 创建数据库连接
		Connection con = this.getConnection();
		// 创建执行对象
		String sql = "UPDATE `news_comment` SET `newsId` = ?,`content` = ?,`author` = ?,`ip` = ?,`createDate` = ? WHERE id = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		// 处理?号占位符
		pstm.setInt(1, id);
		pstm.setInt(2, newsId);
		pstm.setString(3, content);
		pstm.setString(4, author);
		pstm.setString(5, ip);
		pstm.setString(6, DateUtil.parseDate(new Date(2015, 11, 5)));
		int rs = pstm.executeUpdate();
		// 处理返回结果
		if (rs > 0) {
			System.out.println("修改成功!");
		}
		// 关闭资源
		this.close(con, pstm);
	}
}
