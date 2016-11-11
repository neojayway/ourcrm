<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编码规则</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css"
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/popshow.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js"
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
	function changeCheckCount() {
		var count = 0;
		$("input[type='checkbox'][name='ids']").each(function(index, data) {
			if (this.checked) {
				count++;
			}
		});
		$("#slt_ids_count2").empty();
		$("#slt_ids_count2").append(count);

		if (count == $("input[type='checkbox'][name='ids']").length) {
			$("#checkall").attr("checked", "checked");
		} else {
			$("#checkall").attr("checked", null);
		}
	}

	function checkAll() {
		if ($("#checkall")[0].checked) {
			$("input[type='checkbox'][name='ids']").attr("checked",
					"checked");
			$("#slt_ids_count2").empty();
			$("#slt_ids_count2").append(
					$("input[type='checkbox'][name='ids']").length);
		} else {
			$("input[type='checkbox'][name='ids']").attr("checked", null);
			$("#slt_ids_count2").empty();
			$("#slt_ids_count2").append(0);
		}
	}
</script>
</head>

<body>
	<div class="mtitle">
		<div class="mtitle-row">&nbsp;</div>
		<span class="menu_selected">编码规则</span>
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
				<div id="menuTitle1" style="font-weight: bold">编码规则搜索</div>
			</th>
			<th class="th_head"></th>
		</tr>
		<tr>
			<td colspan="2">
				<form name="SearchForm" method="get" 
					action="${pageContext.request.contextPath}/codeRule/selectCodeRuleByPage.do">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						name="base" id="base">
						<tr>
							<td width="38%" nowrap>模块名称： 
								<input name="module" value="${requestScope.module}"
									type="text" id="module" style="width:140px">
							</td>
							<td width="39%" nowrap>&nbsp;</td>
							<td width="23%" align="center">
								<div class="control">
									<button type='button' class='button'
										onMouseOver="this.className='button_over';"
										onMouseOut="this.className='button';"
										onClick="document.SearchForm.submit();">
										<img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png"
											border='0' align='absmiddle'>
										&nbsp;搜索
									</button>
									<button type='button' class='button'
										onMouseOver="this.className='button_over';"
										onMouseOut="this.className='button';"
										onClick="forward('${pageContext.request.contextPath}/codeRule/selectCodeRuleByPage.do')">
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
		&nbsp;编码规则列表
	</h3>

	<div class="control">
		<button type='button' class='button'
			onMouseOver="this.className='button_over';"
			onMouseOut="this.className='button';" onClick="forward('${pageContext.request.contextPath}/page/newPagePlan/sys/code/add.jsp')">
			<img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png"
				border='0' align='absmiddle'>
			&nbsp;新建
		</button>
		<button type='button' class='button'
			onMouseOver="this.className='button_over';"
			onMouseOut="this.className='button';"
			onClick="deleteIds()">
			<img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png"
				border='0' align='absmiddle'>
			&nbsp;删除
		</button>
	</div>

	<!-- list -->
	<div class="border">
		<form name="ActionForm" method="post" action="${pageContext.request.contextPath}/codeRule/deleteCodeRule.do">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				id="PowerTable" class="PowerTable">
				<!-- title -->
				<tr>
					<td width="9%" class="listViewThS1">
						<input type="checkbox" name="checkall" id="checkall" class="checkbox"
							onClick="checkAll()">全选
					</td>
					<td width="20%" class="listViewThS1">模块名称</td>
					<td width="21%" class="listViewThS1">编码前缀</td>
					<td width="19%" class="listViewThS1">日期位</td>
					<td width="15%" class="listViewThS1">流水位</td>
					<td width="16%" class="listViewThS1">预览</td>
				</tr>
				<!-- data -->

				<c:forEach items="${requestScope.codeRuleList}" var="codeRule" varStatus="status">
					<tr>
						<td>
							<input type="checkbox" name="ids" id="ids" value="${codeRule.id }"
								class="checkbox" onClick="changeCheckCount();">
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/codeRule/getCodeRuleById.do?id=${codeRule.id }">
								${codeRule.module}
							</a>
						</td>
						<td>${codeRule.areaprefix }</td>
						<td>${codeRule.areatime }</td>
						<td>${codeRule.glidebit }</td>
						<td>${codeRule.currentcode }</td>
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
						<a href="${pageContext.request.contextPath}/codeRule/selectCodeRuleByPage.do?${requestScope.pageBean.url}&currPage=1">首页</a>
						<a href="${pageContext.request.contextPath}/codeRule/selectCodeRuleByPage.do?${requestScope.pageBean.url}&currPage=${requestScope.pageBean.currPage-1}">上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${requestScope.pageBean.currPage>=requestScope.pageBean.totalPages }">
						下一页
						尾页
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/codeRule/selectCodeRuleByPage.do?${requestScope.pageBean.url}&currPage=${requestScope.pageBean.currPage+1}">下一页</a>
						<a href="${pageContext.request.contextPath}/codeRule/selectCodeRuleByPage.do?${requestScope.pageBean.url}&currPage=${requestScope.pageBean.totalPages}">尾页</a>
					</c:otherwise>
				</c:choose>
			</center>
		</form>
	</div>

</body>
</html>