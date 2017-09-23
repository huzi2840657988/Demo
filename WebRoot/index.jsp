<%@page import="com.zl.bean.NewsComment"%>
<%@page import="com.zl.daoImpl.NewsCommentDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=request.getContextPath() %>/ckeditor/ckeditor.js"> </script>
  </head>
  
  <body>
   		<form action="Text.jsp" method="post" enctype="multipart/form-data">
   			<input name="hi">
   			<input name="file" type="file">
   			<textarea name="content" class="ckeditor"></textarea>
   			<button type="submit">提交</button>
   		</form>
  </body>
</html>
