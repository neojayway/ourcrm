<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>人员添加</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css"
	rel="stylesheet" type="text/css">

<!--处理日期 开始 -->
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css"
	type="text/css">
<!--处理日期结束  -->
</head>
<body>
	<form name="form1" method="post" action="${pageContext.request.contextPath}/user/addUser.do">
		<div class="mtitle">
			<div class="mtitle-row">&nbsp;</div>
			人员-添加
		</div>
		<br>
		<div class="control">
			<button type='button' class='button'
				onMouseOver="this.className='button_over';"
				onMouseOut="this.className='button';"
				onClick="document.forms[0].submit();">
				<img src="${pageContext.request.contextPath}/ui/images/button/baocun.png"
					border='0' align='absmiddle'>
				&nbsp;保存
			</button>
			<button type='button' class='button'
				onMouseOver="this.className='button_over';"
				onMouseOut="this.className='button';"
				onClick="forward('user.do?method=list')">
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
								<td class="red">用户名：</td>
								<td>
									<input type="text" name="name" id="name" cssStyle="width:90%" />
								</td>
								<td class="red">中文名：</td>
								<td>
									<input type="text" name="cnname" cssClass="input" id="cnname"
										cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td class="red">密码：</td>
								<td>
									<input type="password" name="password" id="password"
										cssStyle="width:90%" />
								</td>
								<td>出生日期：</td>
								<td>
									<input type="text" name="birthday" cssClass="dateClassStyle"
										id="birthday" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>移动电话：</td>
								<td>
									<input type="text" name="movetelephone" cssClass="input"
										id="movetelePhone" cssStyle="width:90%" />
								</td>
								<td>电子邮件：</td>
								<td>
									<input type="text" name="email" cssClass="input" id="email"
										cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>家庭地址：</td>
								<td>
									<input type="text" name="address" cssClass="input"
										id="address" cssStyle="width:90%" />
								</td>
								<td class="red">所属部门：</td>
								<td>
									<select name="groupid" style="width:125px;">
										<c:forEach items="${requestScope.groupList}" var="group">
											<option value="${group.groupid}">${group.groupname}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							
							<tr>
								<td>身份证号码：</td>
								<td>
									<input type="text" name="identitycode" cssClass="input"
										id="identityCode" cssStyle="width:90%" />
								</td>
								<td>性别：</td>
								<td>
									男：<input type="radio" name="sex" id="sex"
										cssClass="radio" value="" />
									女：<input type="radio" name="sex" id="sex"
									cssClass="radio" value="" />
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		
	</form>
	<script src="${pageContext.request.contextPath}/ui/js/menu.js"
		type="text/javascript"></script>
</body>
</html>