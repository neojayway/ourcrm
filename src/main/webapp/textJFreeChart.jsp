<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jfreechart 演示</title>
</head>
<body>
	jfreechart 演示
	<br> 请访问
	<a href="${pageContext.request.contextPath }/chart/getMajorChart.do">生成柱状图</a>
	<br>
	<img src="${chartURL}">
</body>
</html>