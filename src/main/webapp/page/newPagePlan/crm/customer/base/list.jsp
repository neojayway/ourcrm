<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>客户拜访</title>
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
</head>

<style>
	.hover
	{
	  background-color: #cccc00;
	}
</style>

<script type="text/javascript">

	function fristPageOnclick(){
		var $page = $(this).html();
		alert($page);
	}

	function getData(){
		//var $page = $(this).html();
		
		$("a").click(
			function(){
				alert($(this).html());
		}); 
		
		//alert($page); 
		/* 
		var str = $("[name='data']").val();
		//判断文本框是否输入值，没输入就查所有
		if(str == null || str=="" || $.trim(str).length==0) str = -1;
		$.ajax({
			url:'${pageContext.request.contextPath}/company/fuzzySearchCompany.do&'+url+"&"+currPage,
			type:'get',
			dataType:'json',
			success:function(data){
				//移除之前的表格
				$("#PowerTable").remove();
				//使用JQuery创建表格   定义一个表格的开头
				var $table=$("<table width='100%' border='0' cellspacing='0' cellpadding='0' id='PowerTable' class='PowerTable'>"); 
				//定义表格的第一行
				var $tr11=$("<tr></tr>");
				$tr11.appendTo($table);
				
				//定义表格的头部样式及属性
				var $th11=$("<td width='7%' class='listViewThS1'><input type='checkbox' name='checkall' id='checkall' cssClass='checkbox' onclick='checkAll()'/>全选</td>");
				var $th12 = $("<td width=26%' class='listViewThS1'>客户名称</td>");
				var $th13 = $("<td width='10%' class='listViewThS1'>客户性质</td>");
				var $th14 = $("<td width='10%' class='listViewThS1'>客户等级</td>");
				var $th15 = $("<td width='10%' class='listViewThS1'>电话一</td>");
				var $th16 = $("<td width='10%' class='listViewThS1'>电子邮件</td>");
				var $th17 = $("<td width='12%' class='listViewThS1'>下次联系时间</td>");
				var $th18 = $("<td width='7%' class='listViewThS1'>创建人</td>");
				var $th19 = $("<td width='8%' class='listViewThS1'>省份城市</td>");
				//把表格的头部拼接到表格中
				$th11.appendTo($tr11);
				$th12.appendTo($tr11);
				$th13.appendTo($tr11);
				$th14.appendTo($tr11);
				$th15.appendTo($tr11);
				$th16.appendTo($tr11);
				$th17.appendTo($tr11);
				$th18.appendTo($tr11);
				$th19.appendTo($tr11);
				if(data!=null){
					for (var i = 0; i < data.list2.length; i++) {
						var companyId = data.list2[i].id;
						var companyName = data.list2[i].name;
						var companyTrade = data.list2[i].trade;
						var companyGrade = data.list2[i].grade;
						var companyTel1 = data.list2[i].tel1;
						var companyEmail = data.list2[i].email;
						var companyNextTouchDate = data.list2[i].nexttouchdate;
						var companyCreater = data.list2[i].creater;
						var companyProvince = data.list2[i].province;
						var companyCity = data.list2[i].city;
						var $tr21 = $("<tr>");
						$tr21.appendTo($table);
						var $td21 = $("<td><input type='checkbox' name='ids' cssClass='checkbox' onclick='changeCheckCount();' /></td>");
						$td21.appendTo($tr21);
						var $td22 = $("<td><a href='${pageContext.request.contextPath}/company/getCompantById/"+companyId+"'>"+companyName+"</a></td>");
						$td22.appendTo($tr21);
						var $td23 = $("<td>"+companyTrade+"</td>");
						$td23.appendTo($tr21);
						var $td24 = $("<td>"+companyGrade+"</td>");
						$td24.appendTo($tr21);
						var $td25 = $("<td>"+companyTel1+"</td>");
						$td25.appendTo($tr21);
						var $td26 = $("<td>"+companyEmail+"</td>");
						$td26.appendTo($tr21);
						var $td27 = $("<td>"+companyNextTouchDate+"</td>");
						$td27.appendTo($tr21);
						var $td28 = $("<td><a href=''>"+companyCreater+"</a></td>");
						$td28.appendTo($tr21);
						var $td29 = $("<td><a href=''>"+companyProvince+"省"+companyCity+"市"+"</a></td>");
						$td29.appendTo($tr21);
						var $tr22 = $("</tr>");
						$tr22.appendTo($table);
					}
						$("#curPageSpan").val(data.pageBean.currPage);
						$("#fristPage").
							attr("href","${pageContext.request.contextPath}/company/fuzzySearchCompany.do?${requestScope.pageBean.url}&currPage=1");
						$("#prePage").
							attr("href","${pageContext.request.contextPath}/company/fuzzySearchCompany.do?${requestScope.pageBean.url}&currPage=${requestScope.pageBean.currPage-1}");
						$("#nextPage").
							attr("href","${pageContext.request.contextPath}/company/fuzzySearchCompany.do?${requestScope.pageBean.url}&currPage=${requestScope.pageBean.currPage+1}");
						$("#lastPage").
							attr("href","${pageContext.request.contextPath}/company/fuzzySearchCompany.do?${requestScope.pageBean.url}&currPage=${requestScope.pageBean.totalPages}");					
				}else{
					var $tr12=$("<tr><td colspan=4>未查询到与  [ "+str+" ] 相关的任何信息,请重新查询！</td></tr>");
					$tr12.appendTo($table);
										
				}
				$table.appendTo("#createTable");
				$("#createtable").append("</table>");
			}
		});
 */	}

	function forward(strURL) {
		window.location = strURL;
	}

	//处理客户共享
	function do_share() {

		var count = 0;
		var ids = "";
		$("input[type='checkbox'][name='ids']").each(function(index, data) {
			if (this.checked) {
				count++;
				if (count == 1) {
					ids = $(this).val();
				} else {
					ids = ids + "," + $(this).val();
				}
			}
		});

		if (count == 0) {
			alert("必须有一个客户被选中!!!");
			return false;
		}

		if (count == 1) { //选中一个客户的情况下
			OpenWin(
					"${pageContext.request.contextPath}/crm/companyAction_showShareSetOne.do?id="
							+ ids, '', 500, 400)
		} else {
			//选中多个的情况下
		}
	}
</script>
<body>
	<div class="mtitle">
		<div class="mtitle-row">&nbsp;</div>
		<span id="menu_selected" class="menu_selected">客户拜访</span>
	</div>
	<div class="link_title">
		<br>&nbsp;&nbsp; 
		<a
			href="${pageContext.request.contextPath}/company/getCompanyWhereTodayNeedTouch">
			今天需要联系的客户
		</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a
			href="${pageContext.request.contextPath}/company/getCompanyWhereForgetTouch">
			已过期未联系的客户
		</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a
			href="${pageContext.request.contextPath}/company/getAllCompany">
			全部
		</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<br>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="tabForm">
		<tr>
			<th class="th_head">
				<div id="menuArrow1"
					style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
				<div id="menuTitle1" style="font-weight: bold">
					客户搜索
				</div>
			</th>
		</tr>
		<tr>
			<td colspan="2">
				<!-- 基本查询的表单--> 
				<form name="form1" method="get"
					action="/company/fuzzySearchCompany.do">
					<div class="control" align="center">
						搜索客户: <input type="text" name="data" onchange="getData(this)"
							 value="${requestScope.data}"/>
						&nbsp;
						<button type='button' class='button'
							onMouseOver="this.className='button_over';"
							onMouseOut="this.className='button';"
							onClick="document.forms[0].submit();">
							<img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png"
								border='0' align='absmiddle'>
							&nbsp;搜索
						</button>

						<button type='button' class='button'
							onMouseOver="this.className='button_over';"
							onMouseOut="this.className='button';"
							onClick="forward('${pageContext.request.contextPath}/crm/customer/base/view.jsp')">
							<img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png"
								border='0' align='absmiddle'>
							&nbsp;清空
						</button>
					</div>
				</form>
				<!-- 基本查询的表单结束 -->
			</td>
		</tr>
	</table>
	<br>
	<h3>
		<img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png"
			border="0">
		&nbsp;客户列表
	</h3>
	<span id="slt_ids_count1"></span>
	<div class="control">
		<button type='button' class='button'
			onMouseOver="this.className='button_over';"
			onMouseOut="this.className='button';"
			onClick="forward('${pageContext.request.contextPath}/company/addBefore.do')">
			<img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png"
				border='0' align='absmiddle'>
			&nbsp;新建
		</button>
		<button type='button' class='button'
			onMouseOver="this.className='button_over';"
			onMouseOut="this.className='button';" onClick="gonextTouchTime()">
			<img src="${pageContext.request.contextPath}/ui/images/button/xiacilxsj.png"
				border='0' align='absmiddle'>
			&nbsp;下次联系时间
		</button>

		<%-- <button type='button' class='button'
			onMouseOver="this.className='button_over';"
			onMouseOut="this.className='button';" onClick="goChangePerson()">
			<img src="${pageContext.request.contextPath}/ui/images/button/jinshourbg.png"
				border='0' align='absmiddle'>
			&nbsp;经手人变更
		</button> --%>
		<button type='button' class='button'
			onMouseOver="this.className='button_over';"
			onMouseOut="this.className='button';"
			onClick="document.forms[1].submit()">
			<img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png"
				border='0' align='absmiddle'>
			&nbsp;删除
		</button>
	</div>
	<div class="border">
		<form method="post" action="${pageContext.request.contextPath}/company/deleteCompanysByIds" id="deleteForm">
			<p id="createTable"></p>
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				id="PowerTable" class="PowerTable">
				<tr>
					<td width="3%" class="listViewThS1">
						<input type="checkbox" name="checkall" id="checkall" 
							cssClass="checkbox" onclick="checkAll()" />
					</td>
					<td width="30%" class="listViewThS1">客户名称</td>
					<td width="10%" class="listViewThS1">客户性质</td>
					<td width="10%" class="listViewThS1">客户等级</td>
					<td width="10%" class="listViewThS1">电话一</td>
					<td width="10%" class="listViewThS1">电子邮件</td>
					<td width="12%" class="listViewThS1">下次联系时间</td>
					<td width="7%" class="listViewThS1">创建人</td>
					<td width="8%" class="listViewThS1">省份城市</td>
				</tr>
				
				<!-- data -->
				<c:if test="${requestScope.companys != null}">
					<c:forEach var="company" varStatus="s" items="${requestScope.companys}"> 
						<tr>
							<td>
								<input type="checkbox" name="ids" cssClass="checkbox" value="${company.id }" 
									onclick="changeCheckCount();" />
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/company/getCompantById/${company.id}">
									${company.name}
								</a>
							</td>
							<td>${company.quality}</td>
							<td>${company.grade}</td>
							<td>${company.tel1}</td>
							<td>${company.email}</td>
							<td><fmt:formatDate value="${company.nexttouchdate}"/></td>
							<td><a href="">${company.creater}</a></td>
							<td>${company.province}${company.city}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${requestScope.companys.size()<=0}">
					<tr>
						<td colspan="9">
							未查询到任何相关数据！
						</td>
					</tr>
				</c:if>
			</table>
			
			<center>
				<input id="currPage" type="hidden" value="${requestScope.pageBean.currPage}"/>
				<input id="dataUrl" type="hidden" value="${requestScope.pageBean.url }"/>
				第<span id="curPageSpan">${requestScope.pageBean.currPage}</span>页/共${requestScope.pageBean.totalPages}页
				<a id="fristPage" href="javascript:void(0)" onclick="fristPageOnclick(this)">首页</a>
				<a id="prePage" href="javascript:void(0)" onclick="prePageOnclick(this)">上一页</a>
				<a id="nextPage" href="javascript:void(0)" onclick="nextPageOnclick(this)">下一页</a>
				<a id="lastPage" href="javascript:void(0)" onclick="lastPageOnclick(this)">尾页</a>
				
				<%-- 第<span id="curPageSpan">${requestScope.pageBean.currPage}</span>页/共${requestScope.pageBean.totalPages}页
				<c:choose>
					<c:when test="${requestScope.pageBean.currPage<=1 }">
						首页
						上一页
					</c:when>
					<c:otherwise>
						<a id="fristPage" href="${pageContext.request.contextPath}/company/fuzzySearchCompany.do?currPage=1" onclick="getData()">首页</a>
						<a id="prePage" href="${pageContext.request.contextPath}/company/fuzzySearchCompany.do?currPage=${requestScope.pageBean.currPage-1}">上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${requestScope.pageBean.currPage>=requestScope.pageBean.totalPages }">
						下一页
						尾页
					</c:when>
					<c:otherwise>
						<a id="nextPage" href="${pageContext.request.contextPath}/company/fuzzySearchCompany.do?currPage=${requestScope.pageBean.currPage+1}">下一页</a>
						<a id="lastPage" href="${pageContext.request.contextPath}/company/fuzzySearchCompany.do?currPage=${requestScope.pageBean.totalPages}">尾页</a>
					</c:otherwise>
				</c:choose> --%>
			</center>
			
		</form>
	</div>
	<script type="text/javascript">
		function goChangePerson() {
			var count = 0;
			var ids = "";
			$("input[type='checkbox'][name='ids']").each(function(index, data) {
				if (this.checked) {
					count++;
					if (count == 1) {
						ids = $(this).val();
					} else {
						ids = ids + "," + $(this).val();
					}
				}
			});
			if (count == 0) {
				alert("必须有一个客户被选中!!!");
				return false;
			}

			var url = "${pageContext.request.contextPath}/page/newPagePlan/crm/customer/base/changePerson.jsp?ids="
					+ ids;
			//var url = "${pageContext.request.contextPath}/crm/customer/base/changePerson.jsp";
			OpenWin(url, '', 480, 140);
		}

		//处理下次联系时间
		function gonextTouchTime() {
			var count = 0;
			var ids = "";
			//遍历所有的复选框
			$("input[type='checkbox'][name='ids']").each(function(index, data) {
				if (this.checked) { //如果复选框处于选中状态
					count++; //count加1
					if (count == 1) {
						ids = $(this).val(); //43,44,45   
					} else {
						ids = ids + "," + $(this).val();
					}
				}
				//如果没有被选中
			});

			//alert("ids  "+ids);

			if (count == 0) {
				alert("必须有一个客户被选中!!!");
				return false;
			}
			OpenWin(
					"${pageContext.request.contextPath}/page/newPagePlan/crm/customer/base/nextTouchTime.jsp?ids="
							+ ids, '', 420, 300);
		}

		function changeCheckCount() {
			var count = 0;
			$("input[type='checkbox'][name='ids']").each(function(index, data) {
				if (this.checked) {
					count++;
				}
			});
			$("#slt_ids_count2").empty();
			$("#slt_ids_count2").append(count);

			if (count == $("input[type='checkbox'][name='ids']").length) {
				$("#checkall").attr("checked", "checked");
			} else {
				$("#checkall").attr("checked", null);
			}
		}

		function checkAll() {
			if ($("#checkall")[0].checked) {
				$("input[type='checkbox'][name='ids']").attr("checked",
						"checked");
				$("#slt_ids_count2").empty();
				$("#slt_ids_count2").append(
						$("input[type='checkbox'][name='ids']").length);
			} else {
				$("input[type='checkbox'][name='ids']").attr("checked", null);
				$("#slt_ids_count2").empty();
				$("#slt_ids_count2").append(0);
			}
		}
	</script>
</body>
</html>