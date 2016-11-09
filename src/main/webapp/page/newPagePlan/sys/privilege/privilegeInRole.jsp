<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部门人员设置</title>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/jquery-1.8.3.min.js"></script> --%>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css"
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/listbox.js" 
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/global.js"
	type="text/javascript"></script>
<script type="text/javascript">

	function check() {
		var users = dumpSelect("right");
		if (users == "") {
			alert("请至少选择一个人员!");
			return false;
		} else {
			document.ActionForm.users.value = users;
			return true;
		}
	}

	//保存时将下拉框的所有下拉项全选
	function submitSelect(){
		var lslt =  $("lslt");
		for(var i=0;i<lslt.options.length;i++){
			var option = lslt.options[i];
			option.selected = "selected";
		};
		document.ActionForm.submit();
	}

	function shutdown(){
		window.document.location = '${pageContext.request.contextPath}/role/showRoleByPage.do'
	}
	
</script>
</head>

<body>
	<form name="ActionForm" method="post" action="${pageContext.request.contextPath }/role/savePrivilegeOfRole.do"
		onSubmit="return check();">
		<input type="hidden" name="method" value="userChange"> 
		<input type="hidden" name="rid" value="${requestScope.rid }"> 
		<input type="hidden" name="privilegeStr" value="${requestScope.privilegeStr }">
		<div class="mtitle">
			<div class="mtitle-row">&nbsp;</div>
			角色权限分配
		</div>
		<br>
		<!-- if(check()) document.ActionForm.submit(); -->
		<div class="control">
			<button type='button' class='button'
				onMouseOver="this.className='button_over';"
				onMouseOut="this.className='button';"
				onClick="submitSelect()">
				<img src="${pageContext.request.contextPath}/ui/images/button/baocun.png"
					border='0' align='absmiddle'>
				&nbsp;保存
			</button>
			<button type='button' class='button'
				onMouseOver="this.className='button_over';"
				onMouseOut="this.className='button';" onClick="shutdown();">
				<img src="${pageContext.request.contextPath}/ui/images/button/guanbi.png"
					border='0' align='absmiddle'>
				&nbsp;关闭
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
								<td width="37%">当前角色拥有的权限</td>
								<td width="22%">&nbsp;</td>
								<td width="41%">所有权限</td>
							</tr>
							<tr>
								<td>
									<select name="lselect" size="1" multiple id="lslt"
										style="width: 100%; height: 250px" onDblClick="moveRight()">
										<c:forEach items="${requestScope.prililegeList }" var="privilege">
											<option value="${privilege.privilegeid }">${privilege.privilegename}</option>
										</c:forEach>
										
										<!-- <option value="12">王卓</option>
										<option value="11">牛丹丹</option>
										<option value="8">张宁</option>
										<option value="7">王楠</option>
										<option value="5">肖秋水</option>
										<option value="1">系统管理员</option> -->
									</select>
								</td>
								<td align="center">
									<button type='button' class='button'
										onMouseOver="this.className='button_over';"
										onMouseOut="this.className='button';" onClick="moveRight()">
										<img src="${pageContext.request.contextPath}/ui/images/button/youyi.png"
											border='0' align='absmiddle'>
										&nbsp;右移
									</button>
									<br />
								<br />
									<button type='button' class='button'
										onMouseOver="this.className='button_over';"
										onMouseOut="this.className='button';" onClick="moveLeft()">
										<img src="${pageContext.request.contextPath}/ui/images/button/zuoyi.png"
											border='0' align='absmiddle'>
										&nbsp;左移
									</button>
									<br />
								<br />
									<button type='button' class='button'
										onMouseOver="this.className='button_over';"
										onMouseOut="this.className='button';" onClick="moveAllRight()">
										<img src="${pageContext.request.contextPath}/ui/images/button/quanbuyy.png"
											border='0' align='absmiddle'>
										&nbsp;全部右移
									</button>
									<br />
								<br />
									<button type='button' class='button'
										onMouseOver="this.className='button_over';"
										onMouseOut="this.className='button';" onClick="moveAllLeft()">
										<img src="${pageContext.request.contextPath}/ui/images/button/quanbuzy.png"
											border='0' align='absmiddle'>
										&nbsp;全部左移
									</button>
								</td>
								<td>
									<select name="rselect" size="1" multiple id="rslt"
										style="width: 100%; height: 250px" onDblClick="moveLeft()">
										<c:forEach items="${requestScope.privilegeAllList }" var="privilege">
											<option value="${privilege.privilegeid}" onDblClick="">${privilege.privilegename}</option>
										</c:forEach>
										
										<!-- <option value="10" onDblClick="">王强</option>
										<option value="9" onDblClick="">之燕燕</option>
										<option value="6" onDblClick="">懂鹏</option>
										<option value="4" onDblClick="">朱丹</option>
										<option value="3" onDblClick="">张大勇</option>
										<option value="2" onDblClick="">王天</option> -->
									</select>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>