<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编码预览</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<table width="100%" height="180" border="0" cellspacing="0"
		cellpadding="0">
		<tr>
			<td align="center">
				<table width="380" border="0" align="center"
					cellpadding="0" cellspacing="0" class="error">
					<tr>
						<th align="left">编码预览</th>
					</tr>
					<tr>
						<td height="60">
							<li>
								<font color="#FF0000">${requestScope.code}</font>
							</li>
						</td>
					</tr>
					<tr>
						<td style="text-align: center">
							<button type='button' class='button'
								onMouseOver="this.className='button_over';"
								onMouseOut="this.className='button';" 
								onClick="history.go(-1)">
								<img src="${pageContext.request.contextPath}/ui/def/images/button/guanbi.png" 
								border='0' align='absmiddle'>
								&nbsp;返回
							</button>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>