<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>操作日志查看</title>
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js"
	type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css"
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/win.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function forward(strURL) {
		window.location = strURL;
	}
	
</script>
</head>
<body>
	<div class="mtitle">
		<div class="mtitle-row">&nbsp;</div>
	</div>
	<br>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="tabForm">
		<tr>
			<th class="th_head">
				<div id="menuArrow1"
					style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">
					&nbsp;
				</div>
				<div id="menuTitle1" style="font-weight: bold">操作日志搜索</div>
			</th>
			<th class="th_head"></th>
		</tr>
		<tr>
			<td colspan="2">
				<form name="form1" method="get"
					action="${pageContext.request.contextPath}/log/selectLogByPage.do">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						name="base" id="base">
						<tr>
							<td width="38%" nowrap="nowrap">操作人名称： 
								<input name="cnname" type="text" id="name" value="${requestScope.cnname}" 
									style="width: 140px">
							</td>
							<td width="39%" nowrap="nowrap">&nbsp;</td>
							<td width="23%" align="center">
								<div class="control">
									<button type='button' class='button'
										onMouseOver="this.className='button_over';"
										onMouseOut="this.className='button';"
										onClick="document.forms[0].submit()">
										<img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png"
											border='0' align='absmiddle'>
										&nbsp;搜索
									</button>
									<button type='button' class='button'
										onMouseOver="this.className='button_over';"
										onMouseOut="this.className='button';"
										onClick="forward('${pageContext.request.contextPath}/log/selectLogByPage.do')">
										<img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png"
											border='0' align='absmiddle'>
										&nbsp;清空
									</button>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	<br>
	<h3>
		<img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png"
			border="0">
		&nbsp;日志列表
	</h3>
	<!-- list -->
	<div class="border">

		<form name="form2" method="post"
			action="${pageContext.request.contextPath}/role/deleteRoleByBatch.do">
			<input type="hidden" name="method" value="delete">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				id="PowerTable" class="PowerTable">
				<!-- title -->
				<tr>
					<td width="2%" class="listViewThS1">编号</td>
					<td width="13%" class="listViewThS1">操作人信息</td>
					<td width="3%" class="listViewThS1">操作人</td>
					<td width="10%" class="listViewThS1">操作类型</td>
					<td width="20%" class="listViewThS1">操作内容</td>
					<td width="3%" class="listViewThS1">操作结果</td>
					<td width="8%" class="listViewThS1">操作日期</td>
				</tr>
				
				<c:forEach items="${requestScope.logList}" var="log" varStatus="status">
					<tr>
						<td>
							<%-- <input type="checkbox" name="rids" value="${role.roleid }"
								class="checkbox" onClick="changeCheckCount();"> --%>
								<span>${status.index+1}</span>
						</td>
						<td>
							<span>${log.username }</span>
						</td>
						<td>
							<span>${log.cnname}</span>
						</td>
						<td>
							<span>${log.actiontype}</span>
						</td>
						<td>
							<span>${log.actioncontent}</span>
						</td>
						<td>
							<span>${log.result}</span>
						</td>
						<td>
							<span>${log.actiondate}</span>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			
			<center>
				第${requestScope.pageBean.currPage}页/共${requestScope.pageBean.totalPages}页
				<c:choose>
					<c:when test="${requestScope.pageBean.currPage<=1 }">
						首页
						上一页
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/log/selectLogByPage.do?${requestScope.pageBean.url}&currPage=1">首页</a>
						<a href="${pageContext.request.contextPath}/log/selectLogByPage.do?${requestScope.pageBean.url}&currPage=${requestScope.pageBean.currPage-1}">上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${requestScope.pageBean.currPage>=requestScope.pageBean.totalPages }">
						下一页
						尾页
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/log/selectLogByPage.do?${requestScope.pageBean.url}&currPage=${requestScope.pageBean.currPage+1}">下一页</a>
						<a href="${pageContext.request.contextPath}/log/selectLogByPage.do?${requestScope.pageBean.url}&currPage=${requestScope.pageBean.totalPages}">尾页</a>
					</c:otherwise>
				</c:choose>
			</center>
		</form>
	</div>
</body>
<script type="text/javascript">
	function changeCheckCount() {
		var count = 0;
		$("input[type='checkbox'][name*='ids']").each(function(index, data) {
			if (this.checked) {
				count++;
			}
		});
		if (count == $("input[type='checkbox'][name*='ids']").length) {
			$("#checkall").attr("checked", "checked");
		} else {
			$("#checkall").attr("checked", null);
		}
	}

	
	function checkAll() {
		/* if ($("#checkall")[0].checked) {
			$("input[type='checkbox'][name='ids']").attr("checked", "checked");
		} else {
			$("input[type='checkbox'][name='ids']").attr("checked", null);
		} */
		if ($("#checkall").attr("checked")) {
			$("input[type='checkbox'][name*='ids']").attr("checked", "checked");
		} else {
			$("input[type='checkbox'][name*='ids']").attr("checked", null);
		} 
	}
</script>
</html>