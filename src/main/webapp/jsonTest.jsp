<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	response.setHeader("Expires", "Sat,6 May 1995 12:00:00 GMT");
	response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setContentType("text/html;charset=UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>json测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/ui/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	
	//请求json，响应json
	function requestJson(){
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/requestJson.do",
			contentType:"application/json;charset=utf-8",
			//数据格式时json串
			data:'{"roleid":11,"rolename":"经理"}',
			success:function(data){
				alert(data.roleid);
				alert(data.rolename); 
			}
		});
	};

	//请求key/value，响应json
	function requestKey(){
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/requestKeyValue.do',
			contentType:'application/x-www-form-urlencoded; charset=UTF-8',
			data:'roleid=11&rolename=员工',
			success:function(data){
				alert(data.rolename);
			}
		});
	};
</script>
</head>

<body>
	<input type="button" onclick="requestJson()" value="请求json，响应json"/>
	<input type="button" onclick="requestKey()" value="请求key/value，响应json"/>
</body>
</html>