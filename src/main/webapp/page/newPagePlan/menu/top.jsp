<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					${sessionScope.userCustom.cnname}，欢迎您！今天是：${sessionScope.today} | 
					<a href="${pageContext.request.contextPath}/user/logout.do">注销 </a> <br/>
					<div style="text-align: left;float:right" >
						<c:forEach items="${sessionScope.weatherList}" var="weather" varStatus="status">
							<c:if test="${status.index==0}">
								<span>今天[</span>
								<span>温度：${weather.temperature}</span>
								<span>天气类型：${weather.weatherType}</span>
								<span>风向：${weather.wind}</span>
								<span>]</span><br/>
							</c:if>
							<c:if test="${status.index==1}">
								<span>明天[</span>
								<span>温度：${weather.temperature}</span>
								<span>天气类型：${weather.weatherType}</span>
								<span>风向：${weather.wind}</span>
								<span>]</span><br/>
							</c:if>
							<c:if test="${status.index==2}">
								<span>后天[</span>
								<span>温度：${weather.temperature}</span>
								<span>天气类型：${weather.weatherType}</span>
								<span>风向：${weather.wind}</span>
								<span>]</span><br/>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
