<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>客户关系管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/menu/css/top.css"
	rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0" class="top">
		<tr>
			<td class="logo">
				<div class="subNav">
					${sessionScope.userCustom.cnname}，欢迎您！今天是：2006-9-4 | 
					<a href="${pageContext.request.contextPath}/user/logout.do">注销 </a> 
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
