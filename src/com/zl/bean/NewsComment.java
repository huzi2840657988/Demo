package com.zl.bean;

import java.sql.Timestamp;

/**
 * news_comment±íËùÓ³ÉäµÄjavaBean
 */
public class NewsComment {
		private Integer  id;
		private Integer newsId;
		private String content;
		private String author;
		private String ip;
		private Timestamp createDate;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getNewsId() {
			return newsId;
		}
		public void setNewsId(Integer newsId) {
			this.newsId = newsId;
		}
		public String getContent() {
			if(content!=null&&content.length()<10){
				return content;
			}else{
				return content.substring(0,10)+"...";
			}
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public Timestamp getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Timestamp createDate) {
			this.createDate = createDate;
		}
}
