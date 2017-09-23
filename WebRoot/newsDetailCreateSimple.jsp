<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.zl.bean.NewsDetail"%>
<%@page import="com.zl.daoImpl.NewsDetailDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
	<head>
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/ckeditor/ckeditor.js"> </script>
		<script>
			//此处为表单验证部分，请同学们课下自己完善
		</script>
	</head>
<body>
<%
	/**
		如果uid等于null是增加。不等于null是修改。
	*/
	NewsDetailDao dao = new NewsDetailDao();
	Integer uid = Integer.valueOf(request.getParameter("uid")==null?"-1":request.getParameter("uid"));
	int cid = 3;//默认是增加
	if(uid!=-1){
		cid = 2;//修改
	}
	NewsDetail nd = null;
	if(uid!=null){
	 	 nd = dao.queryById(uid);//如果是修改先查询要修改的内容根据id
	}
 %>
<form name ="dataFrm" id="dataFrm" action="newsServer.jsp" method="post" enctype="multipart/form-data">
	<input name="cid" value="<%=cid%>" type="hidden"/>
	<% if(cid==2){%>
	<input name="id" value="<%=nd.getId()%>" type="hidden"/>
	<% } %>
	<table  width="100%" border="0" cellspacing="5" cellpadding="0">
		<thead>
			<tr><td align="center" colspan="2" class="text_tabledetail2">增加新闻</td></tr>
		</thead>
		<tbody>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">分类</td>
				<td style="text-align:left;">
				<!-- 列出所有的新闻分类 -->
					<select name="categoryId">
	        			<option value="1" <%if(nd.getCategoryId()==1){%>selected="selected"<%}%>>国内</option>
	        			<option value="2" <%if(nd.getCategoryId()==2){%>selected="selected"<%}%>>国际</option>
	        			<option value="3" <%if(nd.getCategoryId()==3){%>selected="selected"<%}%>>娱乐</option>
	        			<option value="4" <%if(nd.getCategoryId()==4){%>selected="selected"<%}%>>军事</option>
	        			<option value="5" <%if(nd.getCategoryId()==5){%>selected="selected"<%}%>>财经</option>
	        			<option value="6" <%if(nd.getCategoryId()==6){%>selected="selected"<%}%>>天气</option>
	        		</select>
				</td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">标题</td>
				<td style="text-align:left;"><input type="text" name="title" value="<%=nd.getTitle()%>"/></td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">作者</td>
				<td style="text-align:left;"><input type="text" name="author" value="<%=nd.getAuthor()%>"/></td>
			</tr>
			
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">摘要</td>
				<td style="text-align:left;"><textarea  class="ckeditor" id="summary" name="summary" rows="8" cols="50"><%=nd.getSummary()%></textarea></td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">内容</td>
				<td style="text-align:left;">
				<div id="xToolbar"></div>
				<textarea class="ckeditor" id="newscontent" name="newscontent" rows="8" cols="30"><%=nd.getContent()==null?"":nd.getContent()%></textarea></td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">上传图片 </td>
				<td style="text-align:left;"><input type="file" name="picPath"/></td>
			</tr>
			<tr>
				<td style="text-align:center;" colspan="2">
					<button type="submit" class="page-btn" name="save">保存</button>
					<button type="button" class="page-btn" name="return" onclick="javascript:location.href='newsDetailList.jsp'">返回</button>
				</td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>