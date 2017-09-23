<%@page import="com.zl.daoImpl.NewsDetailDao"%>
<%@page import="com.zl.bean.NewsDetail"%>
<%@page import="com.zl.daoImpl.NewsCommentDao"%>
<%@page import="com.zl.bean.NewsComment"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'LoadData.jsp' starting page</title>

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
		NewsDetailDao ncDao = new NewsDetailDao();
		
		//保存到request
		/**
		获取数据-	页面数据 总页数 当前页 总条数 
		*/
		int count = ncDao.getCount();//总条数
		int current = 1;//当前页
		String  paramCurrent =  request.getParameter("current");
		//如果为null是第一次进来。赋值1.否则是点下一页进来。paramCurrent值直接给current
		if(paramCurrent!=null){
			current = Integer.valueOf(paramCurrent);
		}
		int pageCount = count/com.zl.util.Page.NEWSCOUNT;//总页数
		if(count%com.zl.util.Page.NEWSCOUNT!=0){
			pageCount+=1;
		}
		/**
		 保存数据-
		*/
		//加载第一页的数据
		List<Object> list = ncDao.queryByPage(current);
		request.setAttribute("data", list);//页面数据
		request.setAttribute("pageCount", pageCount);//总页数
		request.setAttribute("current", current);//当前页
		request.setAttribute("count", count);//总页数
		//发送请求到newsDetailList.jsp
		request.getRequestDispatcher("newsDetailList.jsp").forward(request, response);
	%>
</body>
</html>
