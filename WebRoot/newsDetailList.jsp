<%@page import="com.zl.bean.NewsDetail"%>
<%@page import="com.zl.util.DateUtil"%>
<%@page import="com.zl.bean.NewsComment"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻</title>
<link type="text/css" rel="stylesheet" href="css/common.css" />
<style type="text/css">
</style>
<script type="text/javascript">
	function goPage() {
		var s = 1;//首页
		var e = document.getElementById("pageCount").value;//最后一页
		var pageId = document.getElementById("inputPage").value;//用户要去的页数
		if (!(pageId >= 1 && pageId <= e)) {
			alert("页数的范围为" + s + "到" + e + ",请输入正确的值");
		} else {
			location.href = "LoadData.jsp?current=" + pageId;
		}
	}
</script>
</head>
<body>
	<!--页面顶部-->
	<div id="header">
		<div class="main-top">
			<div class="logo">
				<a href=""><span>新闻大视野</span> </a>
			</div>

			<div class="nav">
				<ul class="clearfix">
					<li><a href="#">首页</a></li>
					<li><a href="#">国内</a></li>
					<li><a href="#">国际</a></li>
					<li><a href="#">娱乐</a></li>
					<li><a href="#">军事</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<div class="main-banner">
			<img src="images/banner.png" />
		</div>
		<!--管理工具栏-->
		<div class="admin-bar">
			<span class="fr">退出账户</span> 管理员：admin 2012-06-19
		</div>
	</div>
	<!--主体-->
	<div id="content" class="main-content clearfix">
		<div class="main-content-left">
			<!--新闻管理-->
			<div class="class-box">
				<div class="class-box-header">
					<h3>新闻管理</h3>
				</div>
				<div class="class-box-content">
					<ul>
						<li><a href="#">新闻管理</a></li>
						<li class="clear-bottom-line"><a href="#">最新新闻</a></li>
					</ul>
				</div>
			</div>
			<!--//-->
			<!--主题管理-->
			<div class="class-box">
				<div class="class-box-header">
					<h3>分类管理</h3>
				</div>
				<div class="class-box-content">
					<ul>
						<li><a href="#">分类管理</a></li>
						<li class="clear-bottom-line"><a href="#">删除主题</a></li>
					</ul>
				</div>
			</div>
			<!--//-->
			<!--账户管理-->
			<div class="class-box">
				<div class="class-box-header">
					<h3>用户管理</h3>
				</div>
				<div class="class-box-content">
					<ul>
						<li><a href="#">用户管理</a></li>
						<li class="clear-bottom-line"><a href="#">付费服务</a></li>
					</ul>
				</div>
			</div>
			<!--//-->
		</div>
		<div class="main-content-right">
			<!--即时新闻-->
			<div class="main-text-box">
				<div class="main-text-box-tbg">
					<div class="main-text-box-bbg">
						<form name="searchForm" id="searchForm"
							action="/news/jsp/admin/newsDetailList.jsp" method="post">
							<div>
								新闻分类： <select name="categoryId">
									<option value="0">全部</option>

									<option value='1'>国内</option>

									<option value='2'>国际</option>

									<option value='3'>娱乐</option>

									<option value='4'>军事</option>

									<option value='5'>财经</option>

									<option value='6'>天气</option>

								</select> 新闻标题<input type="text" name="title" id="title" value='' />
								<button type="submit" class="page-

btn">GO</button>
								<button type="button" onclick="location.href='newsDetailCreateSimple.jsp'" class="page-btn">增加</button>
								<input type="hidden" name="currentPageNo" value="1" /> <input
									type="hidden" name="pageSize" value="10" /> <input
									type="hidden" name="totalPageCount" value="2" />
							</div>
						</form>
						<table cellpadding="1" cellspacing="1" class="admin-list">
							<thead>
								<tr class="admin-list-head">
									<th>编号</th>
									<th>新闻标题</th>
									<th>作者</th>
									<th>时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<%
									//获取当前页的数据								
									List<NewsDetail> list = (List<NewsDetail>) request
											.getAttribute("data");
									for (int i = 0; i < list.size(); i++) {
										NewsDetail row = list.get(i);
										String content = row.getContent();
										if(row.getContent().length()>10){
											content = content.substring(0,10)+"...";
										}
										if((i+1)%2==0){
											out.print("<tr class='admin-list-head' style='FONT-WEIGHT: normal'>");
										}else{
											out.print("<tr>");
										}
										out.print("<td>" + row.getId() + "</td>");
										out.print("<td><a href='newsDetailView.jsp?id="+row.getId()+"'>"
												+ content + "</a></td>");
										out.print("<td>" + row.getAuthor() + "</td>");
										out.print("<td>" + DateUtil.parseDate(row.getCreateDate())
												+ "</td>");
										out.print("<td><a href='newsDetailCreateSimple.jsp?uid="+row.getId()+"'>修改</a> <a href='newsServer.jsp?cid=1&delId="+row.getId()+"'>删除</a></td>");
										out.print("</tr>");
									}
									//计算下一页的页号
									int next = Integer.valueOf(request.getAttribute("current")
											.toString()) + 1;
								%>
							</tbody>
						</table>
						<div class="page-bar">
							<input value="<%=request.getAttribute("pageCount")%>"
								type="hidden" id="pageCount" />
							<ul class="page-num-ul clearfix">

								<%
									Integer current = Integer.valueOf(request.getAttribute("current")
											.toString());//当前页
									Integer total = Integer.valueOf(request.getAttribute("pageCount")
											.toString()); //最后一页
									if (current > 1) {
								%>
								<a href="LoadData.jsp?current=<%=(current - 1)%>">上一页 </a>
								<a href="LoadData.jsp?current=1">第一页</a>&nbsp;&nbsp;
								<%
									}
								%>
								<li>共<%=request.getAttribute("count")%>条记录&nbsp;&nbsp; <%=request.getAttribute("current")%>/<%=request.getAttribute("pageCount")%>页</li>
								<!-- 如果是最后一页不需要显示 下一页和最后一页 -->
								<%
									if (current < total) {
								%>
								<a href="LoadData.jsp?current=<%=next%>">下一页 </a>
								<a
									href="LoadData.jsp?current=<%=request.getAttribute("pageCount")%>">最后一
									页</a>&nbsp;&nbsp;
								<%
									}
								%>
							</ul>
							<span class="page-go-form"><label>跳转至</label> <input
								type="text" name="inputPage" id="inputPage" class="page-key" />页
								<button type="button" class="page-btn" onClick="goPage();">GO</button>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--底部-->
	<div class="main-footer-box">
		24小时客户服务热线：010-68988888 常见问题解答 新闻热线：010-627488888<br />
		文明办网文明上网举报电话：010-627488888 举报邮箱：jubao@bj-aptech.com.cn<br />
		Coyright&copy;1999-2007 News China gov,All Right Reserved.<br />
		新闻中心版权所有
	</div>
</body>
</html>