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

//判断是否需要执行首页超链接跳转
function fristPageOnclick(){
	var $linkValue = $("#fristPage").html().trim();
	var $currPage = parseInt($("#currPage").val());
	if($currPage>1){
		getData($currPage, $linkValue);
	}
}

//判断是否需要执行上一页超链接跳转
function prePageOnclick(){
	var $linkValue = $("#prePage").html().trim();
	var $currPage = parseInt($("#currPage").val());
	if($currPage>1){
		getData($currPage, $linkValue);
	}
}

//判断是否需要执行下一页超链接跳转
function nextPageOnclick(){
	var $linkValue = $("#nextPage").html().trim();
	var $currPage =parseInt( $("#currPage").val());
	var $totalPages =parseInt( $("#totalPages").html().trim());
	if($currPage<$totalPages){
		getData($currPage, $linkValue);
	}
}

//判断是否需要执行尾页超链接跳转
function lastPageOnclick(){
	var $linkValue = $("#lastPage").html().trim();
	var $currPage = parseInt($("#currPage").val());
	var $totalPages = parseInt($("#totalPages").html().trim());
	if($currPage<$totalPages){
		getData($currPage, $linkValue);
	}
}

	function getData($currPage, $linkValue){

		var str = $("[name='data']").val();
		
		//判断文本框是否输入值，没输入就查所有
		if(str == null || str=="" || $.trim(str).length==0) str = -1;
		var url='${pageContext.request.contextPath}/company/fuzzySearchCompany.do?data='+str;

		if($currPage!=null){
			var $totalPages = $("#totalPages").html();

			if($linkValue=='首页') $currPage = 1;
			if($linkValue=='上一页') $currPage--;
			if($linkValue=='下一页') $currPage++;
			if($linkValue=='尾页') $currPage = $totalPages;
			url+='&currPage='+$currPage;			
		}
				
		$.ajax({
			url:url,
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
				var $th11=$("<td width='7%' class='listViewThS1'><input type='checkbox' name='checkall' id='checkall' class='checkbox' onclick='checkAll()'/>全选</td>");
				var $th12 = $("<td width=26%' class='listViewThS1'>客户名称</td>");
				var $th13 = $("<td width='10%' class='listViewThS1'>客户性质</td>");
				var $th14 = $("<td width='10%' class='listViewThS1'>客户等级</td>");
				var $th15 = $("<td width='10%' class='listViewThS1'>电话一</td>");
				var $th16 = $("<td width='10%' class='listViewThS1'>电子邮件</td>");
				var $th17 = $("<td width='10%' class='listViewThS1'>下次联系时间</td>");
				var $th18 = $("<td width='7%' class='listViewThS1'>创建人</td>");
				var $th19 = $("<td width='10%' class='listViewThS1'>省份城市</td>");
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
						var $td21 = $("<td><input type='checkbox' name='ids' class='checkbox' onclick='changeCheckCount();' value='"+companyId+"'/></td>");
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
						var $td28 = $("<td><a href='#'>"+companyCreater+"</a></td>");
						$td28.appendTo($tr21);
						var $td29 = $("<td><a href='#'>"+companyProvince+"省"+companyCity+"市"+"</a></td>");
						$td29.appendTo($tr21);
						var $tr22 = $("</tr>");
						$tr22.appendTo($table);
					}
						$("#currPage").val(data.pageBean.currPage);
						$("#curPageSpan").html(data.pageBean.currPage);
						$("#totalPages").html(data.pageBean.totalPages);
				}else{
					var $tr12=$("<tr><td colspan=4>未查询到与  [ "+str+" ] 相关的任何信息,请重新查询！</td></tr>");
					$tr12.appendTo($table);
										
				}
				$table.appendTo("#createTable");
				$("#createtable").append("</table>");
			}
		});
	}

	function forward(strURL) {
		window.location = strURL;
	}

	function getAllData(url){
		window.location.href=url;
	}
	
</script>
<body>
	<div class="mtitle">
		<div class="mtitle-row">&nbsp;</div>
		<span id="menu_selected" class="menu_selected">客户拜访</span>
	</div>
	<div class="link_title">
		<br>&nbsp;&nbsp; 
		<a id="getCompanyWhereTodayNeedTouch" onclick=""
			href="${pageContext.request.contextPath}/company/getCompanyWhereTodayNeedTouch.do">
			今天需要联系的客户
		</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a id="getCompanyWhereForgetTouch" onclick=""
			href="${pageContext.request.contextPath}/company/getCompanyWhereForgetTouch.do">
			已过期未联系的客户
		</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a
			href="${pageContext.request.contextPath}/company/selectCompanyByPage.do">
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
					action="${pageContext.request.contextPath}/company/fuzzySearchCompany.do">
					<div class="control" align="center">
						搜索客户: <input type="text" name="data" onchange="getData()"
							 value="${requestScope.data}"/>
						&nbsp;
						<button type='button' class='button'
							onMouseOver="this.className='button_over';"
							onMouseOut="this.className='button';"
							onClick="getData()">
							<img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png"
								border='0' align='absmiddle'>
							&nbsp;搜索
						</button>

						<button type='button' class='button'
							onClick="getAllData('${pageContext.request.contextPath}/company/selectCompanyByPage.do')">
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
							class="checkbox" onclick="checkAll()" />
					</td>
					<td width="30%" class="listViewThS1">客户名称</td>
					<td width="10%" class="listViewThS1">客户性质</td>
					<td width="10%" class="listViewThS1">客户等级</td>
					<td width="10%" class="listViewThS1">电话一</td>
					<td width="10%" class="listViewThS1">电子邮件</td>
					<td width="10%" class="listViewThS1">下次联系时间</td>
					<td width="7%" class="listViewThS1">创建人</td>
					<td width="10%" class="listViewThS1">省份城市</td>
				</tr>
				
				<!-- data -->
				<c:if test="${requestScope.companys != null}">
					<c:forEach var="company" varStatus="s" items="${requestScope.companys}"> 
						<tr>
							<td>
								<input type="checkbox" name="ids" class="checkbox" value="${company.id}" 
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
				<input id="currPage" name="currPage" type="hidden" value="${requestScope.pageBean.currPage}"/>
				<input id="dataUrl" name="url" type="hidden" value="${requestScope.pageBean.url }"/>
				第<span id="curPageSpan">${requestScope.pageBean.currPage}</span>页/共<span id="totalPages">${requestScope.pageBean.totalPages}</span>页
				<a id="fristPage" href="javascript:void(0)" onclick="fristPageOnclick(this)">首页</a>
				<a id="prePage" href="javascript:void(0)" onclick="prePageOnclick(this)">上一页</a>
				<a id="nextPage" href="javascript:void(0)" onclick="nextPageOnclick(this)">下一页</a>
				<a id="lastPage" href="javascript:void(0)" onclick="lastPageOnclick(this)">尾页</a>
			</center>
			
		</form>
	</div>
	<script type="text/javascript">
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
			OpenWin("${pageContext.request.contextPath}/company/doUpdateNextTouchDateBefore.do?ids="
				+ids, '', 420, 300);
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