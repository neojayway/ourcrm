<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色修改</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script language="javascript">
</script>
</head>

<body>
	<form name="form1" method="post" action="${pageContext.request.contextPath}/role/updateRole.do">
		<div class="mtitle">
			<div class="mtitle-row">&nbsp;</div>
			角色修改
		</div>
		<br>
		<div class="control">
			<button type='button' class='button' 
				onMouseOver="this.className='button_over';" 
				onMouseOut="this.className='button';"  
			    onClick="document.form1.submit();">
			    <img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" 
			    	border='0' align='absmiddle'>
			    &nbsp;保存
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
				<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">
					&nbsp;
				</div>
				<div id="menuTitle1" style="font-weight:bold">角色信息</div>
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
						<td class="red">角色名称</td>
						<td>
							<input name="roleid" type="hidden" class="input"  
								style="width:90%" value="${requestScope.role.roleid}">
							<input name="rolename" type="text" class="input"  
								style="width:90%" value="${requestScope.role.rolename}">
						</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
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