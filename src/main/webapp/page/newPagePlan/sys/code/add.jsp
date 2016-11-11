<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编码规则新建</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css"
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/win.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/popshow.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function preview() {
		var prefix = encodeURI(document.ActionForm.areaprefix.value);
		if (prefix == "") {
			alert("请输入编码前缀!");
			document.ActionForm.areaprefix.focus();
			return false;
		}
		var timeForm = document.ActionForm.areatime;
		var time = "";
		for (var i = 0; i < timeForm.length; i++) {
			var temp = timeForm[i];
			if (temp.checked) {
				time = temp.value;
			}
		}
		var glide = document.ActionForm.glidebit.value;
		
		window.location.href='${pageContext.request.contextPath}/codeRule/previewCode.do?areaprefix='
			+prefix+"&areatime="+time+"&glidebit="+glide;
	}
</script>
</head>

<body>
	<form name="ActionForm" method="post" 
		action="${pageContext.request.contextPath}/codeRule/insertCodeRule.do">
		<div class="mtitle">
			<div class="mtitle-row">&nbsp;</div>
			编码规则-新建
		</div>
		<br>
		<div class="control">
			<button type='button' class='button'
				onMouseOver="this.className='button_over';"
				onMouseOut="this.className='button';"
				onClick="document.ActionForm.submit();">
				<img src="${pageContext.request.contextPath}/ui/images/button/baocun.png"
					border='0' align='absmiddle'>
					&nbsp;保存
			</button>
			<button type='button' class='button'
				onMouseOver="this.className='button_over';"
				onMouseOut="this.className='button';" onClick="preview()">
				<img src="${pageContext.request.contextPath}/ui/images/button/yulan.png"
					border='0' align='absmiddle'>
					&nbsp;预览
			</button>
			<button type='button' class='button'
				onMouseOver="this.className='button_over';"
				onMouseOut="this.className='button';"
				onClick="history.go(-1)">
				<img src="${pageContext.request.contextPath}/ui/images/button/fanhui.png"
					border='0' align='absmiddle'>
					&nbsp;返回
			</button>
		</div>

		<table width="100%" border="0" cellspacing="0" class="tabForm">
			<tr>
				<th colspan="4" align="left" class="th_head">
					<div id="menuArrow1"
						style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">
						&nbsp;
					</div>
					<div id="menuTitle1" style="font-weight: bold">基本信息</div>
				</th>
			</tr>
			<tr>
				<td>
					<div id="menu1">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="16%"></td>
								<td width="34%"></td>
								<td width="16%"></td>
								<td width="34%"></td>
							</tr>
							<tr>
								<td class="red">模块名称：</td>
								<td>
									<input name="module" type="text" class="input"
										id="module" style="width: 90%">
								</td>
								<td class="red">数据库表名：</td>
								<td>
									<input name="tabname" type="text" class="input"
										id="tabname" style="width: 90%">
								</td>
							</tr>
							<tr>
								<td class="red">编码前缀：</td>
								<td>
									<input name="areaprefix" type="text" class="input"
										id="areaprefix" style="width: 90%">
								</td>
								<td class="red">流水位：</td>
								<td>
									<select name='glidebit' id='glidebit'
										style='width: 90%'>
										<option value=''>------</option>
										<c:if test="${applicationScope.glidebitList!=null}">
											<c:forEach var="dictionaryType" varStatus="s" items="${applicationScope.glidebitList}">
												<option value="${dictionaryType.value}">${dictionaryType.value}</option>		
											</c:forEach>
										</c:if>
									</select>
								</td>
							</tr>
							<tr>
								<td class="red">日期位：</td>
								<td colspan="3">
									<c:if test="${applicationScope.areatimeList!=null}">
										<c:forEach var="dictionaryType" varStatus="s" items="${applicationScope.areatimeList}">
											<input type='radio' name='areatime' id='areatime' 
												value='${dictionaryType.value}' class='radio'>
												${dictionaryType.value}		
										</c:forEach>
									</c:if>
									<input type='radio' name='areatime' id='areatime' 
										value='' class='radio'>无
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<br>
	</form>
</body>
</html>