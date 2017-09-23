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
 * �����ݱ�(news_comment)����ɾ�Ĳ����
 * 
 * @author Administrator
 */
public class NewsCommentDao extends BaseDao implements INewsPage{
	/**
	 * ��ʾָ��ҳ 
	 * pageId:ҳ��
	 */
	public List<Object> queryByPage(int pageId) {
		List<Object> resultList = new ArrayList<Object>();
		// �������ݿ�����
		Connection con = this.getConnection();
		// ����ִ�ж���
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			String sql = "SELECT * FROM news_comment limit ?,?";
			st = con.prepareStatement(sql);
			st.setInt(1, (pageId-1)*Page.NEWSCOUNT);
			st.setInt(2, Page.NEWSCOUNT);
			rs = st.executeQuery();
			// �����صĽ����(�洢��ִ�ж�������ݿ��ȡ������)
			while (rs.next()) {
				NewsComment nc = new NewsComment();// ����javaBean
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
		// �ر���Դ
		this.close(con, st, rs);
		return resultList;
	}

	/**
	 * ����������
	 */
	public int getCount() {
		String sql = "SELECT COUNT(1) FROM news_comment";
		// ��ȡ���ݿ�����
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
	 * ���ص�����Ӧ����ʲô?
	 * 
	 * @throws Exception
	 */
	public List<NewsComment> queryAll() throws Exception {
		List<NewsComment> resultList = new ArrayList<NewsComment>();
		// �������ݿ�����
		Connection con = this.getConnection();
		// ����ִ�ж���
		Statement st = con.createStatement();
		String sql = "SELECT * FROM news_comment";
		ResultSet rs = st.executeQuery(sql);
		// �����صĽ����(�洢��ִ�ж�������ݿ��ȡ������)
		while (rs.next()) {
			NewsComment nc = new NewsComment();// ����javaBean
			nc.setId(rs.getInt("id"));
			nc.setNewsId(rs.getInt("newsId"));
			nc.setContent(rs.getString("content"));
			nc.setAuthor(rs.getString("author"));
			nc.setIp(rs.getString("ip"));
			nc.setCreateDate(rs.getTimestamp("createDate"));
			resultList.add(nc);
		}
		// �ر���Դ
		this.close(con, st, rs);
		return resultList;
	}

	/**
	 * ���
	 * 
	 * @throws Exception
	 */
	public void add(Object[] param) throws Exception {
		// �������ݿ�����
		Connection con = this.getConnection();
		// ����ִ�ж���
		String sql = "INSERT INTO `news_comment`(`newsId`,`content`,`author`,`ip`,`createDate`)VALUES(?,?,?,?,?);";
		PreparedStatement pstmt = con.prepareStatement(sql);
		for (int i = 0; i < param.length; i++) {
			pstmt.setObject(i + 1, param[i]);
		}
		// ִ�����Ӳ���
		int rs = pstmt.executeUpdate();
		if (rs > 0) {
			System.out.println("���ӳɹ�!");
		}
		// �ر���Դ
		this.close(con, pstmt);
	}

	public void add2(int newsId, String content, String author, String ip,
			Date createDate) throws Exception {
		// �������ݿ�����
		Connection con = this.getConnection();
		// ����ִ�ж���
		// Statement st = con.createStatement();
		String sql = "insert  into `news_comment`(`newsId`,`content`,`author`,`ip`,`createDate`) values (?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		System.out.println("����?��ռλ��֮ǰ:" + sql);
		// ����?��ռλ��
		// �ѵ�1���ʺŵ�λ�ò���int����newsId����Ӧ��ֵ;
		pstmt.setInt(1, newsId);
		pstmt.setString(2, content);
		pstmt.setString(3, author);
		pstmt.setString(4, ip);
		pstmt.setString(5, DateUtil.parseDate(createDate));
		System.out.println("����?��ռλ��֮��:" + sql);
		int rs = pstmt.executeUpdate();
		if (rs > 0) {
			System.out.println("���ӳɹ�!");
		}
		// �ر���Դ
		this.close(con, pstmt);
	}

	/**
	 * @param id
	 *            :ɾ�����
	 * @throws Exception
	 */
	public void remove(int id) throws Exception {
		// �������ݿ�����
		Connection con = this.getConnection();
		// ����ִ�ж���
		Statement st = con.createStatement();
		String sql = "DELETE FROM `news_comment` WHERE id = " + id;
		// ִ��ɾ������
		int rs = st.executeUpdate(sql);
		if (rs > 0) {
			System.out.println("ɾ���ɹ�!");
		}
		// �ر���Դ
		this.close(con, st);
	}

	/**
	 * �޸�
	 */
	public void update(int id, int newsId, String content, String author,
			String ip, Date createDate) throws Exception {
		// �������ݿ�����
		Connection con = this.getConnection();
		// ����ִ�ж���
		String sql = "UPDATE `news_comment` SET `newsId` = ?,`content` = ?,`author` = ?,`ip` = ?,`createDate` = ? WHERE id = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		// ����?��ռλ��
		pstm.setInt(1, id);
		pstm.setInt(2, newsId);
		pstm.setString(3, content);
		pstm.setString(4, author);
		pstm.setString(5, ip);
		pstm.setString(6, DateUtil.parseDate(new Date(2015, 11, 5)));
		int rs = pstm.executeUpdate();
		// �����ؽ��
		if (rs > 0) {
			System.out.println("�޸ĳɹ�!");
		}
		// �ر���Դ
		this.close(con, pstm);
	}
}
