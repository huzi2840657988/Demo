package com.zl.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.zl.bean.NewsDetail;
import com.zl.dao.INewsPage;
import com.zl.util.Page;

/**
 * @author Administrator table news_detail
 */
public class NewsDetailDao extends BaseDao implements INewsPage {
	/**
	 * 显示指定页 pageId:页号
	 */
	public List<Object> queryByPage(int pageId) {
		List<Object> resultList = new ArrayList<Object>();
		// 创建数据库连接
		Connection con = this.getConnection();
		// 创建执行对象
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM news_detail limit ?,?";
			st = con.prepareStatement(sql);
			st.setInt(1, (pageId - 1) * Page.NEWSCOUNT);
			st.setInt(2, Page.NEWSCOUNT);
			rs = st.executeQuery();
			// 处理返回的结果集(存储了执行对象从数据库获取的数据)
			while (rs.next()) {
				NewsDetail nc = new NewsDetail();// 创建javaBean
				nc.setId(rs.getInt("id"));
				nc.setCategoryId(rs.getInt("categoryId"));
				nc.setTitle(rs.getString("title"));
				nc.setSummary(rs.getString("summary"));
				nc.setContent(rs.getString("content"));
				nc.setPicPath(rs.getString("picPath"));
				nc.setAuthor(rs.getString("author"));
				nc.setCreateDate(rs.getTimestamp("createDate"));
				nc.setModifyDate(rs.getTimestamp("modifyDate"));
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
		String sql = "SELECT COUNT(1) FROM news_detail";
		// 获取数据库连接
		Connection con = this.getConnection();
		int result = -1;
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
	public void queryAll() throws Exception {
		// 创建数据库连接
		Connection con = this.getConnection();
		// 创建执行对象
		Statement st = con.createStatement();
		String sql = "SELECT * FROM news_detail";
		ResultSet rs = st.executeQuery(sql);
		// 处理返回的结果集(存储了执行对象从数据库获取的数据)
		while (rs.next()) {
			System.out.print("id:" + rs.getInt("id"));
			System.out.println("	content:" + rs.getString("title"));
			System.out.println("  createDate-getDate:"
					+ rs.getDate("createDate"));
			System.out.println("  createDate-getTime:"
					+ rs.getTime("createDate"));
			System.out.println("  createDate-getTimestamp:"
					+ rs.getTimestamp("createDate"));
		}
		// 关闭资源
		this.close(con, st, rs);
	}
	/**
	 * 添加
	 * 
	 * @throws Exception
	 */
	public void add(Object[] param) {
		// 创建数据库连接
		Connection con = this.getConnection();
		// 创建执行对象
		String sql = "INSERT INTO `news_detail`(`categoryId`,`title`,`summary`,`content`,`author`,`createDate`,`modifyDate`)VALUES(?,?,?,?,?,?,?);";
		// PreparedStatement 和 Statement:
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				pstm.setObject(i+1, param[i]);
			}
			// pstm.setString(1, bornDate+"");不推荐使用
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int rs = 0;
		try {
			rs = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 执行添加
		if (rs > 0) {
			System.out.println("增加成功!");
		}
		this.close(con, pstm);
	}
	public boolean add2(NewsDetail nd) {
		// 创建数据库连接
		Connection con = this.getConnection();
		// 创建执行对象
		String sql = "INSERT INTO `news_detail`(`categoryId`,`title`,`author`,`summary`,`content`,`picPath`)VALUES(?,?,?,?,?,?)";
		// PreparedStatement 和 Statement:
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setObject(1,nd.getCategoryId());
			pstm.setObject(2,nd.getTitle());
			pstm.setObject(3,nd.getAuthor());
			pstm.setObject(4,nd.getSummary());
			pstm.setObject(5,nd.getContent());
			pstm.setObject(6,nd.getPicPath());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int rs = 0;
		try {
			rs = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close(con, pstm);
		// 执行添加
		if (rs > 0) {
			System.out.println("增加成功!");
			return true;
		}else{
			return false;
		}
		
	}
	public boolean update(NewsDetail nd) {
		// 创建数据库连接
		Connection con = this.getConnection();
		// 创建执行对象
		String sql = "UPDATE `news_detail` SET `categoryId`=?,`title`=?,`author`=?,`summary`=?,`content`=?,`picPath`=? where id = ?";
		// PreparedStatement 和 Statement:
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setObject(1,nd.getCategoryId());
			pstm.setObject(2,nd.getTitle());
			pstm.setObject(3,nd.getAuthor());
			pstm.setObject(4,nd.getSummary());
			pstm.setObject(5,nd.getContent());
			pstm.setObject(6,nd.getPicPath());
			pstm.setObject(7,nd.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int rs = 0;
		try {
			rs = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close(con, pstm);
		// 执行添加
		if (rs > 0) {
			System.out.println("增加成功!");
			return true;
		}else{
			return false;
		}
		
	}
	/**
	 * 根据id查询
	 * @throws Exception
	 */
	public NewsDetail queryById(int id) throws Exception {
		// 创建数据库连接
				Connection con = this.getConnection();
				// 创建执行对象
				PreparedStatement st = null;
				ResultSet rs = null;
				NewsDetail nc = new NewsDetail();// 创建javaBean
				try {
					String sql = "SELECT * FROM news_detail where id = ?";
					st = con.prepareStatement(sql);
					st.setInt(1,id);
					rs = st.executeQuery();
					// 处理返回的结果集(存储了执行对象从数据库获取的数据)
					while (rs.next()) {
						nc.setId(rs.getInt("id"));
						nc.setCategoryId(rs.getInt("categoryId"));
						nc.setTitle(rs.getString("title"));
						nc.setSummary(rs.getString("summary"));
						nc.setContent(rs.getString("content"));
						nc.setPicPath(rs.getString("picPath"));
						nc.setAuthor(rs.getString("author"));
						nc.setCreateDate(rs.getTimestamp("createDate"));
						nc.setModifyDate(rs.getTimestamp("modifyDate"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 关闭资源
				this.close(con, st, rs);
				return nc;
	}
	//删除:根据id
	public boolean delete(int id){
		Connection con = this.getConnection();
		int rs = -1;
		PreparedStatement pstm=null;
		try {
			pstm= con.prepareStatement("DELETE FROM news_detail WHERE id = ?");
			pstm.setInt(1, id);
			rs = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close(con, pstm);//关闭
		if(rs>0){
			return true;
		}else{
			return false;
		}
	}
}
