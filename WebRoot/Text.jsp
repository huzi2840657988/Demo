<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*,org.apache.commons.fileupload.*"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>

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

<title>My JSP 'Text.jsp' starting page</title>

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
	<!--  -->
	<%
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		FileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload sf = new ServletFileUpload(factory);
		
		String upload = request.getSession().getServletContext().getRealPath("/upload");
		File upFile = new File(upload);
		
		if(!upFile.exists()){
			upFile.mkdir();
		}
		if(isMultipart){
			List<FileItem> list = sf.parseRequest(request);
			Iterator<FileItem> iter = list.iterator();
			while(iter.hasNext()){
				FileItem item = iter.next();
				if(item.isFormField()){//普通字段
					System.out.println(item.getString("UTF-8"));
				}else{
					File file = new File(item.getName());
					File up = new File(upload,file.getName());
					item.write(up);			
				}
			}
		}
	%>
</body>
</html>
