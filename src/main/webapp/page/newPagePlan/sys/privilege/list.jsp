<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色设置</title>
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
	
	function deleteIds() {
		var flag = confirm("确定删除吗？");
		if(flag){
			document.forms[1].submit();
		}
	}
</script>
</head>
<body>
	<div class="mtitle">
		<div class="mtitle-row">&nbsp;</div>
		<span class="menu_selected">角色设置</span>
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
				<div id="menuTitle1" style="font-weight: bold">角色搜索</div>
			</th>
			<th class="th_head"></th>
		</tr>
		<tr>
			<td colspan="2">
				<form name="form1" method="get"
					action="${pageContext.request.contextPath}/role/showRoleByPage.do">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						name="base" id="base">
						<tr>
							<td width="38%" nowrap="nowrap">角色名称： 
								<input name="roleName" type="text" id="name" value="${requestScope.roleName}" 
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
										onClick="forward('${pageContext.request.contextPath}/role/showRoleByPage.do')">
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
		&nbsp;角色列表
	</h3>
	<div class="control">

		<button type='button' class='button'
			onMouseOver="this.className='button_over';"
			onMouseOut="this.className='button';"
			onClick="forward('${pageContext.request.contextPath}/page/newPagePlan/sys/privilege/add.jsp')">
			<img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png"
				border='0' align='absmiddle'>
			&nbsp;新建
		</button>


		<button type='button' class='button'
			onMouseOver="this.className='button_over';"
			onMouseOut="this.className='button';" onClick="deleteIds()">
			<img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png"
				border='0' align='absmiddle'>
			&nbsp;删除
		</button>

	</div>
	<!-- list -->
	<div class="border">

		<form name="form2" method="post"
			action="${pageContext.request.contextPath}/role/deleteRoleByBatch.do">
			<input type="hidden" name="method" value="delete">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				id="PowerTable" class="PowerTable">
				<!-- title -->
				<tr>
					<td width="5%" class="listViewThS1">
						<input type="checkbox"id="checkall" name="checkall" 
						value="-1" class="checkbox" onClick="checkAll()">
					</td>
					<td width="20%" class="listViewThS1">角色名称</td>
					<td width="20%" class="listViewThS1">操作</td>
				</tr>
				
				<c:forEach items="${requestScope.roleList}" var="role" varStatus="status">
					<tr>
						<td>
							<input type="checkbox" name="rids" value="${role.roleid }"
								class="checkbox" onClick="changeCheckCount();">
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/role/updatePre.do?rid=${role.roleid}">
								${role.rolename}
							</a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/role/showPrivilegeOfRole.do?rid=${role.roleid}">
								设置
							</a>
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
						<a href="${pageContext.request.contextPath}/role/showRoleByPage.do?${requestScope.pageBean.url}&currPage=1">首页</a>
						<a href="${pageContext.request.contextPath}/role/showRoleByPage.do?${requestScope.pageBean.url}&currPage=${requestScope.pageBean.currPage-1}">上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${requestScope.pageBean.currPage>=requestScope.pageBean.totalPages }">
						下一页
						尾页
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/role/showRoleByPage.do?${requestScope.pageBean.url}&currPage=${requestScope.pageBean.currPage+1}">下一页</a>
						<a href="${pageContext.request.contextPath}/role/showRoleByPage.do?${requestScope.pageBean.url}&currPage=${requestScope.pageBean.totalPages}">尾页</a>
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