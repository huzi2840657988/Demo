<%@page import="com.zl.bean.NewsDetail"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.zl.daoImpl.NewsDetailDao"%>
<%@page import="java.io.*,java.util.*,org.apache.commons.fileupload.*"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>增删改</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<%
		/**
		 处理乱码
		 */
		request.setCharacterEncoding("UTF-8");
		/**
		 * 删除的值
		 */
		Integer cid = null;
		Integer delId = null;
		/**
		 修改 和 增加
		 */
		NewsDetail nd = new NewsDetail();
		/**
		 1:前台传过来的是不是multipart/form-data
		 2:获取前台传入的所有数据(带有name的input标签)
		 3:如果是普通表单操作依旧。如果不是普通表单就是file(获取流写入到路径(tomcat))
		 */
		//1:前台传过来的是不是multipart/form-data
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		//2:获取前台传入的所有数据(带有name的input标签)
		FileItemFactory factory = new DiskFileItemFactory();
		//ServletFileUpload:操作request-判断是不是Multipart。-获取request中的所有FileItem
		ServletFileUpload sfu = new ServletFileUpload(factory);
		String uploadPath = request.getSession().getServletContext()
				.getRealPath("/upload");
		//写入的文件夹
		File rootFile = new File(uploadPath);
		if (!rootFile.exists()) {
			rootFile.mkdir();
		}
		//获取需要保存的值
		if (isMultipart) {
			List<FileItem> list = sfu.parseRequest(request);
			Iterator<FileItem> iter = list.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();//接受到一个input
				//3:如果是普通表单操作依旧。如果不是普通表单就是file(获取流写入到路径(tomcat))
				/**
				item.getFieldName():获取name属性
				item.getName():获取的文件名
				 */
				if (item.isFormField()) {//true:普通表单

					if ("cid".equals(item.getFieldName())) {//操作的id
						cid = Integer.valueOf(item.getString("utf-8"));
					} else if ("delId".equals(item.getFieldName())) {//删除的id
						delId = Integer.valueOf(item.getString("utf-8"));
					}
					/*
					 * 分类 标题  作者 摘要 内容 上传图片
					 */
					else if ("categoryId".equals(item.getFieldName())) {
						nd.setCategoryId(Integer.valueOf(item
								.getString("utf-8")));
					} else if ("title".equals(item.getFieldName())) {
						nd.setTitle(item.getString("utf-8"));
					} else if ("author".equals(item.getFieldName())) {
						nd.setAuthor(item.getString("utf-8"));
					} else if ("newscontent".equals(item.getFieldName())) {
						nd.setContent(item.getString("utf-8"));
					} else if ("summary".equals(item.getFieldName())) {
						nd.setSummary(item.getString("utf-8"));
					}
					//如果是修改需要获取id
					if (cid == 2 && "id".equals(item.getFieldName())) {
						nd.setId(Integer.valueOf(item.getString("utf-8")));
					}
				} else {
					if (cid != 1) {
						//接收传入的文件
						String filePath = item.getName();
						filePath = request.getSession().getId()+System.currentTimeMillis()+filePath;
						//输出路径
						File outTarget = new File(uploadPath, filePath);
						item.write(outTarget);
						nd.setPicPath("upload/"+filePath);
					}

				}
			}
		}
		NewsDetailDao dao = new NewsDetailDao();
		/**
		 cid: 1-删除
			  2-修改
			  3-增加
		 */

		PrintWriter pw = response.getWriter();
		switch (cid) {
		case 1:
			//删除

			boolean isOk = dao.delete(delId);
			if (isOk) {
				pw.write("<script>alert('删除成功');location.href='LoadData.jsp?current=1'</script>");
			} else {
				pw.write("<script>alert('删除失败');location.href='LoadData.jsp?current=1'</script>");
			}
			break;
		case 2:
			//修改
			//获取需要保存的值

			//调用修改
			boolean isOk3 = dao.update(nd);
			if (isOk3) {
				pw.write("<script>alert('修改成功');location.href='LoadData.jsp?current=1'</script>");
			} else {
				pw.write("<script>alert('修改失败');location.href='LoadData.jsp?current=1'</script>");
			}
			break;
		case 3:
			//增加
			boolean isOk2 = dao.add2(nd);//执行添加操作
			if (isOk2) {
				pw.write("<script>alert('添加成功');location.href='LoadData.jsp?current=1'</script>");
			} else {
				pw.write("<script>alert('添加失败');location.href='LoadData.jsp?current=1'</script>");
			}
			break;
		}
	%>
</body>
</html>
