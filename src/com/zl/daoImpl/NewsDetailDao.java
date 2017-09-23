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
	 * ��ʾָ��ҳ pageId:ҳ��
	 */
	public List<Object> queryByPage(int pageId) {
		List<Object> resultList = new ArrayList<Object>();
		// �������ݿ�����
		Connection con = this.getConnection();
		// ����ִ�ж���
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM news_detail limit ?,?";
			st = con.prepareStatement(sql);
			st.setInt(1, (pageId - 1) * Page.NEWSCOUNT);
			st.setInt(2, Page.NEWSCOUNT);
			rs = st.executeQuery();
			// �����صĽ����(�洢��ִ�ж�������ݿ��ȡ������)
			while (rs.next()) {
				NewsDetail nc = new NewsDetail();// ����javaBean
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
		// �ر���Դ
		this.close(con, st, rs);
		return resultList;
	}
	/**
	 * ����������
	 */
	public int getCount() {
		String sql = "SELECT COUNT(1) FROM news_detail";
		// ��ȡ���ݿ�����
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
		// �������ݿ�����
		Connection con = this.getConnection();
		// ����ִ�ж���
		Statement st = con.createStatement();
		String sql = "SELECT * FROM news_detail";
		ResultSet rs = st.executeQuery(sql);
		// �����صĽ����(�洢��ִ�ж�������ݿ��ȡ������)
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
		// �ر���Դ
		this.close(con, st, rs);
	}
	/**
	 * ���
	 * 
	 * @throws Exception
	 */
	public void add(Object[] param) {
		// �������ݿ�����
		Connection con = this.getConnection();
		// ����ִ�ж���
		String sql = "INSERT INTO `news_detail`(`categoryId`,`title`,`summary`,`content`,`author`,`createDate`,`modifyDate`)VALUES(?,?,?,?,?,?,?);";
		// PreparedStatement �� Statement:
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				pstm.setObject(i+1, param[i]);
			}
			// pstm.setString(1, bornDate+"");���Ƽ�ʹ��
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
		}// ִ�����
		if (rs > 0) {
			System.out.println("���ӳɹ�!");
		}
		this.close(con, pstm);
	}
	public boolean add2(NewsDetail nd) {
		// �������ݿ�����
		Connection con = this.getConnection();
		// ����ִ�ж���
		String sql = "INSERT INTO `news_detail`(`categoryId`,`title`,`author`,`summary`,`content`,`picPath`)VALUES(?,?,?,?,?,?)";
		// PreparedStatement �� Statement:
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
		// ִ�����
		if (rs > 0) {
			System.out.println("���ӳɹ�!");
			return true;
		}else{
			return false;
		}
		
	}
	public boolean update(NewsDetail nd) {
		// �������ݿ�����
		Connection con = this.getConnection();
		// ����ִ�ж���
		String sql = "UPDATE `news_detail` SET `categoryId`=?,`title`=?,`author`=?,`summary`=?,`content`=?,`picPath`=? where id = ?";
		// PreparedStatement �� Statement:
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
		// ִ�����
		if (rs > 0) {
			System.out.println("���ӳɹ�!");
			return true;
		}else{
			return false;
		}
		
	}
	/**
	 * ����id��ѯ
	 * @throws Exception
	 */
	public NewsDetail queryById(int id) throws Exception {
		// �������ݿ�����
				Connection con = this.getConnection();
				// ����ִ�ж���
				PreparedStatement st = null;
				ResultSet rs = null;
				NewsDetail nc = new NewsDetail();// ����javaBean
				try {
					String sql = "SELECT * FROM news_detail where id = ?";
					st = con.prepareStatement(sql);
					st.setInt(1,id);
					rs = st.executeQuery();
					// �����صĽ����(�洢��ִ�ж�������ݿ��ȡ������)
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
				// �ر���Դ
				this.close(con, st, rs);
				return nc;
	}
	//ɾ��:����id
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
		this.close(con, pstm);//�ر�
		if(rs>0){
			return true;
		}else{
			return false;
		}
	}
}
