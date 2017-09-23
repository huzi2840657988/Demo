<%@page import="com.zl.bean.NewsDetail"%>
<%@page import="com.zl.daoImpl.NewsDetailDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>My JSP 'adminNewsView.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
  <%
  	NewsDetailDao dao = new NewsDetailDao();
	Integer id = Integer.valueOf(request.getParameter("id"));
	NewsDetail news = dao.queryById(id);
  %>
<div class="main-text-box-tbg">
	<div class="main-text-box-bbg">
		<div class="article-box">
			<h1><%=news.getTitle() %></h1>
			<div class="source-bar">发布者：<%=news.getAuthor() %> 分类：新闻信息  更新时间：<%=news.getCreateDate() %>" </div>
			<div class="article-content">
				<span class="article-summary"><b>摘要：<%=news.getSummary() %></b></span>
				<% if(news.getPicPath() == null || news.getPicPath().equals("")){ %>
				新闻图片：暂无<br/>
				<%}else{%>
				<img src="<%=request.getContextPath() %>/<%=news.getPicPath() %>"/><br/>
				<%} %>
				<%=news.getContent() %>
			</div>
		</div>
	</div>
</div>
  	
  	
  	<div align="center">
  		<button type="button" class="page-btn" name="return" onclick="javascript:location.href='LoadData.jsp?current=1'">返回</button>
  	</div>
  </body>
</html>
