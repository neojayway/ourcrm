<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>客户关系管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<frameset rows="80,*" cols="*">
	<frame
		src="${pageContext.request.contextPath}/page/newPagePlan/menu/top.jsp"
		name="topFrame" id="topFrame" scrolling="NO" noresize="noresize"
		frameborder="0">
	<frameset cols="220,*" id="frmstOuter">
		<frame
			src="${pageContext.request.contextPath}/page/newPagePlan/menu/left.jsp"
			name="leftFrame" id="leftFrame" scrolling="auto" " frameborder="0"
			framespacing="1px" bordercolor="#4faad8">
		<frame src="" name="rightFrame" id="rightFrame">
	</frameset>
</frameset>
<noframes>
	<body>
	</body>
</noframes>
</html>