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
	<form name="form1" method="post" action="sysUserAction_save.do" namespace="/sys">
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
								<td>推荐人：</td>
								<td>
									<input type="text" name="commendman" cssClass="input"
										id="commendman" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>移动电话：</td>
								<td>
									<input type="text" name="movetelePhone" cssClass="input"
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
								<td>家庭电话：</td>
								<td>
									<input type="text" name="telephone" cssClass="input"
										id="telephone" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>现住宅地址：</td>
								<td>
									<input type="text" name="nowAddress" cssClass="input"
										id="nowAddress" cssStyle="width:90%" />
								</td>
								<td>现住宅电话：</td>
								<td>
									<input type="text" name="nowtelePhone" cssClass="input"
										id="nowtelePhone" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>身份证号码：</td>
								<td>
									<input type="text" name="identityCode" cssClass="input"
										id="identityCode" cssStyle="width:90%" />
								</td>
								<td>社会保险号：</td>
								<td>
									<input type="text" name="insuranceCode" cssClass="input"
										id="insuranceCode" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>紧急联系人：</td>
								<td>
									<input type="text" name="instancyLinkman" cssClass="input"
										id="instancyLinkman" cssStyle="width:90%" />
								</td>
								<td>紧急联系电话：</td>
								<td>
									<input type="text" name="instancytelePhone" cssClass="input"
										id="instancytelePhone" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>起始有效期：</td>
								<td>
									<input type="text" name="beginDate" cssClass="dateClassStyle"
										id="beginDate" cssStyle="width:90%" />
								</td>
								<td>终止有效期：</td>
								<td>
									<input type="text" name="endDate" cssClass="dateClassStyle"
										id="endDate" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td class="red">操作权限组：</td>
								<td>
									<c:if test="#request.sysRoleSelect!=null">
										<select list="#request.sysRoleSelect" id='roleId'
											name="roleId" cssStyle='width:90%' listKey="id"
											listValue="name">
										</select>
									</c:if>
								</td>
								<td class="red">所属部门：</td>
								<td>
									<c:if test="#request.sysUserGroupSelect!=null">
										<select list="#request.sysUserGroupSelect" id='groupId'
											name="groupId" cssStyle='width:90%' listKey="id"
											listValue="name">
										</select>
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="red">状态：</td>
								<td>
									<input type="radio" list="#{'Y':'启用','N':'停用'}" name="status"
										id="status" listKey="key" listValue="value" value="%{'Y'}" />
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<br>
		<table width="100%" border="0" cellspacing="0" class="tabForm">
			<tr>
				<th colspan="4" align="left" class="th_head">
					<div id="menuArrow2"
						style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">
						&nbsp;
					</div>
					<div id="menuTitle2" style="font-weight: bold">详细信息</div>
				</th>
			</tr>
			<tr>
				<td>
					<div id="menu2">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="16%"></td>
								<td width="34%"></td>
								<td width="16%"></td>
								<td width="34%"></td>
							</tr>
							<tr>
								<td>性别：</td>
								<td>
									<input type="radio" list="{'男','女'}" name="sex" id="sex"
										cssClass="radio" value="%{'男'}" />
								</td>
								<td>出生日期：</td>
								<td>
									<input type="text" name="birthday" cssClass="dateClassStyle"
										id="birthday" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>职员类别：</td>
								<td>
									<input type="radio"{'全职','兼职'}" name="personnelType"
										id="personnelType" cssClass="radio" value="%{'全职'}" />
								</td>
								<td>职务：</td>
								<td>
									<input type="text" name="duty" cssClass="input" id="duty"
										cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>入职时间：</td>
								<td>
									<input type="text" name="workDate" cssClass="dateClassStyle"
										id="workDate" cssStyle="width:90%" />
								</td>
								<td>最高学历：</td>
								<td>
									<input type="text" name="highSchool" cssClass="input"
										id="highSchool" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>毕业学校：</td>
								<td>
									<input type="text" name="finishSchool" cssClass="input"
										id="finishSchool" cssStyle="width:90%" />
								</td>
								<td>毕业时间：</td>
								<td>
									<input type="text" name="finishSchoolDate" cssClass="dateClassStyle" 
										id="finishSchoolDate" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>配偶姓名：</td>
								<td>
									<input type="text" name="consortName" cssClass="input"
										id="consortName" cssStyle="width:90%" />
								</td>
								<td>子女姓名：</td>
								<td>
									<input type="text" name="youngoneName" cssClass="input"
										id="youngoneName" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>办公电话：</td>
								<td>
									<input type="text" name="officetelePhone" cssClass="input"
										id="officetelePhone" cssStyle="width:90%" />
								</td>
								<td>配偶电话：</td>
								<td>
									<input type="text" name="consorttelePhone" cssClass="input"
										id="consorttelePhone" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>业余爱好：</td>
								<td colspan="3">
									<input type="text" name="avocation"
										cssClass="input" id="avocation" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>配偶工作单位：</td>
								<td colspan="3">
									<input type="text" name="consortCompany"
										cssClass="input" id="consortCompany" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>备注：</td>
								<td colspan="3">
									<input type="text" name="remark" id="remark"
										rows="3" cssStyle="width:96%" />
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<br>
		<table width="100%" border="0" cellspacing="0" class="tabForm">
			<tr>
				<th colspan="4" align="left" class="th_head">
					<div id="menuArrow3"
						style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">
						&nbsp;
					</div>
					<div id="menuTitle3" style="font-weight: bold">职业技能</div>
				</th>
			</tr>
			<tr>
				<td>
					<div id="menu3">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="16%"></td>
								<td width="34%"></td>
								<td width="16%"></td>
								<td width="34%"></td>
							</tr>
							<tr>
								<td>偏好特长：</td>
								<td>
									<input type="text" name="strongSuit" id="strongSuit" rows="3"
										cssStyle="width:90%" />
								</td>
								<td>信息沟通：</td>
								<td>
									<input type="text" name="commUniCate" id="commUniCate"
										rows="3" cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>培训情况：</td>
								<td>
									<input type="text" name="bringup" id="bringup" rows="3"
										cssStyle="width:90%" />
								</td>
								<td>组织能力：</td>
								<td>
									<input type="text" name="organise" id="organise" rows="3"
										cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>分析能力：</td>
								<td>
									<input type="text" name="analyse" id="analyse" rows="3"
										cssStyle="width:90%" />
								</td>
								<td>计划能力：</td>
								<td>
									<input type="text" name="planing" id="planing" rows="3"
										cssStyle="width:90%" />
								</td>
							</tr>
							<tr>
								<td>人员开发：</td>
								<td>
									<input type="text" name="empolder" id="empolder" rows="3"
										cssStyle="width:90%" />
								</td>
								<td>人际关系：</td>
								<td>
									<input type="text" name="relation" id="relation" rows="3"
										cssStyle="width:90%" />
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<br>
		<table width="100%" border="0" cellspacing="0" class="tabForm">
			<tr>
				<th colspan="4" align="left" class="th_head">
					<div id="menuArrow4"
						style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">
						&nbsp;
					</div>
					<div id="menuTitle4" style="font-weight: bold">系统信息</div>
				</th>
			</tr>
			<tr>
				<td>
					<div id="menu4">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="16%"></td>
								<td width="34%"></td>
								<td width="16%"></td>
								<td width="34%"></td>
							</tr>
							<tr>
								<td>创建人：</td>
								<td>
									<input type="text" name="creator" cssClass="disabled"
										id="creator" readonly="true" />
								</td>
								<td>创建时间：</td>
								<td>
									<input type="text" name="createTime" cssClass="disabled"
										id="createTime" readonly="true" />
								</td>
							</tr>
							<tr>
								<td>修改人：</td>
								<td>
									<input type="text" name="updater" cssClass="disabled"
										id="updater" readonly="true" />
								</td>
								<td>修改时间：</td>
								<td>
									<input type="text" name="updateTime" cssClass="disabled"
										id="updateTime" readonly="true" />
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<br>
	</form>
	<script src="${pageContext.request.contextPath}/ui/js/menu.js"
		type="text/javascript"></script>
</body>
</html>