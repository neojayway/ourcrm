<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户资料修改</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css"
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/win.js"
	type="text/javascript"></script>

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

<script type="text/javascript">
function name2pinyin() {
	var companyName = $("#name").val();
	$.ajax({
		url:'${pageContext.request.contextPath}/company/doPinYin.do?companyName='+companyName,
		type:'get',
		dataType:'text',
		success:function(data){
			$("[name='pycode']").val("");
			$("[name='pycode']").val(data);
		}
	});
}

function showCity() {
	var pid = $("#province").val();
	$.ajax({
		url:'${pageContext.request.contextPath}/company/doGetCitysByPid.do?pid='+pid,
		type:'get',
		dataType:'json',
		success:function(data){
			$("#city").remove();
			var $citySelect = $("<select name='city' id='city' style='width: 90%'>");
			var $cityOption1 = $("<option value=''>------</option>");
			$cityOption1.appendTo($citySelect);
			if(data==null){
				var $cityOption2 = $("<option value=''>无附属城市！</option>");
				$cityOption2.appendTo($citySelect);
			}else{
				for(var i = 0;i<data.length;i++){
					var cityId = data[i].id;
					var cityName = data[i].name;
					if(cityId = 1){
						var $cityOption = $("<option value='"+cityName+"' selected='selected'>"+cityName+"</option>");
						$cityOption.appendTo($citySelect);
					}else{
						var $cityOption = $("<option value='"+cityName+"'>"+cityName+"</option>");
						$cityOption.appendTo($citySelect);
					}
				}
			}
		$citySelect.appendTo("#citySelect");
		$("#citySelect").append("</select>");
		}
	});
}
function Date_of_Today() {
	var now = new Date();
	var year = now.getYear();
	var mm = now.getMonth() + 1;
	var dd = now.getDate();
	if (mm < 10)
		mm = "0" + mm;
	if (dd < 10)
		dd = "0" + dd;

	return year + "-" + mm + "-" + dd;
}

function check() {
	var nextTouchDate = $("#nextTouchDate").val();
	if ($.trim(nextTouchDate) == "") {
		alert("下次联系时间不能为空");
		$("#nextTouchDate").focus();
		return false;
	}
	var curDate = Date_of_Today();

	if (nextTouchDate < curDate) {
		alert("下次联系时间必须大于系统的当前时间");
		$("#nextTouchDate").focus();
	}
	return true;
} 
</script>

</head>
<body>
	<form name="companyForm" method="post" 
		action="${pageContext.request.contextPath}/company/updateAfter.do">
		<div class="mtitle">
			<div class="mtitle-row">&nbsp;</div>
			客户-编辑
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
				onClick="history.go(-1)">
				<img src="${pageContext.request.contextPath}/ui/images/button/fanhui.png"
					border='0' align='absmiddle'>
				&nbsp;返回
			</button>
		</div>
		<table width="100%" border="0" cellspacing="0" class="tabForm">
			<tr>
				<th colspan="4" class="th_head">
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
							<input type="hidden" name="id" value="${requestScope.company.id}"/>
							<tr>
								<td width="16%" class="red">客户编码：</td>
								<td width="34%">
									<input type="text" id="code" name="code"
										style="width:90%" 
										value="${requestScope.company.code }"/>
								</td>
								<td width="16%" class="red">客户名称：</td>
								<td width="34%">
									<input type="text" id="name" name="name" value="${requestScope.company.name}"
										style="width:90%" onblur="name2pinyin()" />
								</td>
							</tr>
							<tr>
								<td>拼音码：</td>
								<td>
									<input type="text" id="pycode" name="pycode" value="${requestScope.company.pycode}"
										style="width:90%" readonly="true" class="disabled" />
								</td>
								<td>客户等级：</td>
								<td>
									<select name="grade" id="grade" style="width:90%">
										<option value="">--------</option>
										<c:if test="${applicationScope.gradeList!=null}">
											<c:forEach var="dictionaryType" varStatus="s" items="${applicationScope.gradeList}">
												<c:choose>
													<c:when test="${requestScope.company.grade == dictionaryType.value}">
														<option value="${dictionaryType.value}" selected="selected">${dictionaryType.value}</option>
													</c:when>
													<c:otherwise>
														<option value="${dictionaryType.value}">${dictionaryType.value}</option>		
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
									</select>
								</td>
							</tr>
							<tr>
								<td>区域名称：</td>
								<td>
									<select name="regionname" id="regionname" style="width:90%">
										<option value="">--------</option>
										<c:if test="${applicationScope.regionNameList!=null}">
											<c:forEach var="dictionaryType" varStatus="s" items="${applicationScope.regionNameList}">
												<c:choose>
													<c:when test="${requestScope.company.regionname == dictionaryType.value}">
														<option value="${dictionaryType.value}" selected="selected">${dictionaryType.value}</option>
													</c:when>
													<c:otherwise>
														<option value="${dictionaryType.value}">${dictionaryType.value}</option>													
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
									</select>
								</td>
								<td>客户来源：</td>
								<td>
									<select name="source" style="width: 90%">
										<option value="">--------</option>
										<c:if test="${applicationScope.sourceList!=null}">
											<c:forEach var="dictionaryType" varStatus="s" items="${applicationScope.sourceList}">
												<c:choose>
													<c:when test="${requestScope.company.source == dictionaryType.value}">
														<option value="${dictionaryType.value}" selected="selected">${dictionaryType.value}</option>
													</c:when>
													<c:otherwise>
														<option value="${dictionaryType.value}">${dictionaryType.value}</option>		
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
									</select>
								</td>
							</tr>
							<tr>
								<td>所属行业：</td>
								<td>
									<select id='trade' name='trade' style='width: 90%'>
										<option value=''>------</option>
										<c:if test="${applicationScope.tradeList!=null}">
											<c:forEach var="dictionaryType" varStatus="s" items="${applicationScope.tradeList}">
												<c:choose>
													<c:when test="${requestScope.company.trade == dictionaryType.value}">
														<option value="${dictionaryType.value}" selected="selected">${dictionaryType.value}</option>
													</c:when>
													<c:otherwise>
														<option value="${dictionaryType.value}">${dictionaryType.value}</option>		
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
									</select>
								</td>
								<td>公司规模：</td>
								<td>
									<select id='scale' name='scale' style='width: 90%'>
										<option value=''>------</option>
										<c:if test="${applicationScope.scaleList!=null}">
											<c:forEach var="dictionaryType" varStatus="s" items="${applicationScope.scaleList}">
												<c:choose>
													<c:when test="${requestScope.company.scale == dictionaryType.value}">
														<option value="${dictionaryType.value}" selected="selected">${dictionaryType.value}</option>
													</c:when>
													<c:otherwise>
														<option value="${dictionaryType.value}">${dictionaryType.value}</option>		
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
									</select>
								</td>
							</tr>
							<tr>
								<td>省份：</td>
								<td>
									<select name="province" id="province" style='width: 90%' onchange="showCity(this)">
										<option value=''>------</option>
										<c:if test="${requestScope.allProvince!=null}">
											<c:forEach var="province" varStatus="s" items="${requestScope.allProvince}">
												<c:choose>
													<c:when test="${requestScope.company.province == province.name}">
														<option value="${province.id}" selected="selected">${province.name}</option>
													</c:when>
													<c:otherwise>
														<option value="${province.id}">${province.name}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
									</select>
								</td>
								<td>城市：</td>
								<td>
									<span id="citySelect"></span>
									<select name="city" id="city" style='width: 90%' >
										<option value=''>------</option>
										<c:if test="${requestScope.cityList!=null}">
											<c:forEach var="city" varStatus="s" items="${requestScope.cityList}">
												<c:choose>
													<c:when test="${requestScope.company.city == city.name}">
														<option value="${city.name}" selected="selected">${city.name}</option>
													</c:when>
													<c:otherwise>
														<option value="${city.name}">${city.name}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
									</select>
								</td>
							</tr>
							<tr>
								<td>邮政编码：</td>
								<td>
									<input type="text" name="postcode" id="postcode"
										style="width:90%" value="${requestScope.company.postcode}"/>
								</td>
							</tr>
							<tr>
								<td>联系地址：</td>
								<td colspan="3">
									<input type="text" name="address" id="address"
										style="width:96%" value="${requestScope.company.address}"/>
								</td>
							</tr>
							<tr>
								<td>电子邮件：</td>
								<td>
									<input type="text" name="email" id="email"
										style="width:96%" value="${requestScope.company.email}"/>
								</td>
								<td>公司网站：</td>
								<td>
									<input type="text" name="web" id="web" style="width:90%" 
										value="${requestScope.company.web}"/>
								</td>
							</tr>
							<tr>
								<td>电话一：</td>
								<td>
									<input type="text" name="tel1" id="tel1" style="width:90%" 
										value="${requestScope.company.tel1}"/>
								</td>
								<td>传真：</td>
								<td>
									<input type="text" name="fax" id="fax" style="width:90%" 
										value="${requestScope.company.fax}"/>
								</td>
							</tr>
							<tr>
								<td>手机：</td>
								<td>
									<input type="text" name="mobile" id="mobile"
										style="width:90%" value="${requestScope.company.mobile}"/>
								</td>
								<td>电话二：</td>
								<td>
									<input type="text" name="tel2" id="tel2" style="width:90%" 
										value="${requestScope.company.tel2}"/>
								</td>
							</tr>
							<tr>
								<td>下次联系时间:</td>
								<td>
									<input type="text" name="nexttouchdate" id="nexttouchdate"
										style="width:90%" class="dateClassStyle" 
										value='<fmt:formatDate value="${requestScope.company.nexttouchdate}"/>'/>
								</td>
								<td>客户性质：</td>
								<td>
									<select id='quality' name='quality' style='width: 90%'>
										<option value=''>------</option>
										<c:if test="${applicationScope.qualityList!=null}">
											<c:forEach var="dictionaryType" varStatus="s" items="${applicationScope.qualityList}">
												<c:choose>
													<c:when test="${requestScope.company.quality == dictionaryType.value}">
														<option value="${dictionaryType.value}" selected="selected">${dictionaryType.value}</option>
													</c:when>
													<c:otherwise>
														<option value="${dictionaryType.value}">${dictionaryType.value}</option>		
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
									</select>
								</td>
							</tr>
							<tr>
								<td valign="top">备注：</td>
								<td colspan="3">
									<textarea name="remark" rows="4"
										id="remark" style="width:96%" >
										${requestScope.company.remark}
									</textarea>
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
				<th colspan="4" class="th_head">
					<div id="menuArrow2"
						style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">
						&nbsp;
					</div>
					<div id="menuTitle2" style="font-weight: bold">企业信息</div>
				</th>
			</tr>
			<tr>
				<td>
					<div id="menu2">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="16%">经营范围：</td>
								<td width="34%">
									<select id='dealin' name='dealin' style='width: 90%'>
										<option value=''>------</option>
										<c:if test="${applicationScope.busineScopeList!=null}">
											<c:forEach var="dictionaryType" varStatus="s" items="${applicationScope.busineScopeList}">
												<c:choose>
													<c:when test="${requestScope.company.dealin == dictionaryType.value}">
														<option value="${dictionaryType.value}" selected="selected">${dictionaryType.value}</option>
													</c:when>
													<c:otherwise>
														<option value="${dictionaryType.value}">${dictionaryType.value}</option>		
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
									</select>
								</td>
								<td width="16%">企业性质：</td>
								<td width="34%">
									<select id='kind' name='kind' style='width: 90%'>
										<option value=''>------</option>
										<c:if test="${applicationScope.kindList!=null}">
											<c:forEach var="dictionaryType" varStatus="s" items="${applicationScope.kindList}">
												<c:choose>
													<c:when test="${requestScope.company.kind == dictionaryType.value}">
														<option value="${dictionaryType.value}" selected="selected">${dictionaryType.value}</option>
													</c:when>
													<c:otherwise>
														<option value="${dictionaryType.value}">${dictionaryType.value}</option>		
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
									</select>
								</td>
							</tr>
							<tr>
								<td>法人代表：</td>
								<td>
									<input type="text" name="artificialperson"
										id="artificialperson" style="width:90%" 
										value="${requestScope.company.artificialperson}"/>
								</td>
								<td>注册资金：</td>
								<td>
									<input type="text" name="registemoney" id="registemoney"
										style="width:90%" value="${requestScope.company.registemoney}"/>
								</td>
							</tr>
							<tr>
								<td>开户银行：</td>
								<td>
									<input type="text" name="bank" id="bank" style="width:90%" 
										value="${requestScope.company.bank}"/>
								</td>
								<td>银行账户：</td>
								<td>
									<input type="text" name="account" id="account"
										style="width:90%" value="${requestScope.company.account}"/>
								</td>
							</tr>
							<tr>
								<td>公司税号：</td>
								<td>
									<input type="text" name="taxcode" id="taxcode"
										style="width:90%" value="${requestScope.company.taxcode}"/>
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
		<table width="100%" border="0" cellspacing="0" class="tabForm">
			<tr>
				<th colspan="4" class="th_head">
					<div id="menuArrow3"
						style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
					<div id="menuTitle3" style="font-weight: bold">其他信息</div>
				</th>
			</tr>
			<tr>
				<td>
					<div id="menu3">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="16%">创建人：</td>
								<td width="34%">
									<input type="text" name="creater" id="creater"
										style="width:90%" class="disabled" value="${requestScope.company.creater}"/>
								</td>
								<td width="16%">创建日期：</td>
								<td width="34%">
									<input type="text" name="createtime"
										id="createtime" style="width:90%" class="disabled" 
										value="${requestScope.company.createtime}"/>
								</td>
							</tr>
							<tr>
								<td>修改人：</td>
								<td>
									<input type="text" name="updater" id="updater"
										style="width:90%" class="disabled" 
										value="${requestScope.company.updater}"/>
								</td>
								<td>修改日期：</td>
								<td>
									<input type="text" name="updatetime" id="updatetime"
										style="width:90%" class="disabled" 
										value="${requestScope.company.updatetime}"/>
								</td>
							</tr>
							<tr>
								<td>所属人：</td>
								<td>
									<input type="text" name="dispenseperson" 
										id="dispenseperson" style="width:90%" 
										class="disabled" value="${requestScope.company.dispenseperson}"/> 
									<!-- 保存的是所属人的id -->
									<input type="hidden" name="owneruser" value="${requestScope.company.owneruser}"/> 
									<!-- 变更的日期 --> 
									<input type="hidden" name="dispensedate" value="${requestScope.company.dispensedate}"/>
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
<script src="${pageContext.request.contextPath}/ui/js/menu.js"
	type="text/javascript"></script>
</html>