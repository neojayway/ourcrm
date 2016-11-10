<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<title>省份资料</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css"
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/popshow.js"
	type="text/javascript"></script>
<script type="text/javascript" 
	src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js"></script>
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
		var str = $("[name='name']").val();
		//判断文本框是否输入值，没输入就查所有
		if(str == null || str=="" || $.trim(str).length==0) str = -1;
		var url='${pageContext.request.contextPath}/province/fuzzySearchProvince.do?data='+str;

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
				var $table=$("<table width='100%' border='0' cellspacing='0' cellpadding='0' id='PowerTable' class='PowerTable'>");
				var $tr11=$("<tr></tr>");
				$tr11.appendTo($table);
				var $td11=$("<td width='6%' class='listViewThS1'><input type='checkbox' name='checkall' id='checkall' class='checkbox' onClick='checkAll()'>全选</td>");
				var $td12=$("<td width='17%' class='listViewThS1'>编号</td>");
				var $td13=$("<td width='27%' class='listViewThS1'>省份名称</td>");
				var $td14=$("<td width='50%' class='listViewThS1'>拼音码</td>");
				$td11.appendTo($tr11);
				$td12.appendTo($tr11);
				$td13.appendTo($tr11);
				$td14.appendTo($tr11);
				if(data!=null){
					for (var i = 0; i < data.provinceList.length; i++) {
						var id = data.provinceList[i].id;
						var name = data.provinceList[i].name;
						var pycode = data.provinceList[i].pycode;
						var $tr21 = $("<tr>");
						$tr21.appendTo($table);
						var $td21 = $("<td><input type='checkbox' value='"+id+"' name='ids' value='"+id+"' class='checkbox' onClick='changeCheckCount();'></td>");
						$td21.appendTo($tr21);
						var $td22 = $("<td>"+id+"</td>");
						$td22.appendTo($tr21);
						var $td23 = $("<td><a href='${pageContext.request.contextPath}/province/getProvinceById/"+id+"'>"+name+"</a></td>");
						$td23.appendTo($tr21);
						var $td24 = $("<td>"+pycode+"</td>");
						$td24.appendTo($tr21);
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
				$table.appendTo("#provinceTableStart");
				$("#provinceTableStart").append("</table>");
			}
		});
	}

	function getAllData(url){
		window.location.href=url;
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

	function addProvince(url){
		window.location.href=url;
	}
	
</script>
</head>

<body>
	<!-- 处理弹出窗口 -->
	<div id="popshow"
		style='border: 1px solid #6A82A8; width =650px; position: absolute; 
		visibility: hidden; left: 0; top: 0; z-index: 10;'>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr style='background-color: #6A82A8;'>
				<th width='80%' height="25" align='left'
					onMouseDown=initializedragie(popshow) style="cursor: move"
					onselectstart="return false">
					<font color='#FFFFFF'>&nbsp;详细信息</font>
				</th>
				<td align='right' onselectstart="return false">
					<a href='#' onClick="close_window();"> 
						<img src="${pageContext.request.contextPath}/ui/images/xpclose.jpg"
							width="20" height="20" border="0" onClick="" align="absmiddle">
					</a>
				</td>
			</tr>
			<tr>
				<td colspan="2" onselectstart="return false">
					<div id='gedit'></div>
				</td>
			</tr>
		</table>
		<iframe src="javascript:false"
			style="position: absolute; visibility: inherit; top: 0px; left: 0px; 
			width: 100%; height: 100%; z-index: -1; 
			filter ='progid: DXImageTransform.Microsoft.Alpha(style=0, opacity=0) '; frameborder=' 0';">
		</iframe>
	</div>
	<!-- 处理弹出窗口结束 -->

	<!-- 查询开始 -->
	<div class="mtitle">
		<div class="mtitle-row">&nbsp;</div>
		省份资料
	</div>
	<br>
	<h3>
		<img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png"
			border="0">
		&nbsp;省份资料搜索
	</h3>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="tabForm" id="base">
		<tr>
			<td width="38%" height="45" nowrap>省份名称：
				<input name="name" type="text" id="name" value="" 
					style="width: 140px" onchange="getData()"/>
			</td>
			<td width="39%" nowrap>&nbsp;</td>
			<td width="23%" align="center">
				<div class="control">
					<button class='button' onMouseOver="this.className='button_over';"
						onMouseOut="this.className='button';" onClick="getData()">
						<img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png"
							border='0' align="middle">
						&nbsp;搜索
					</button>
					<button class='button' onMouseOver="this.className='button_over';"
						onMouseOut="this.className='button';" onClick="getAllData('${pageContext.request.contextPath}/province/selectProvinceByPage.do')">
						<img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png"
							border='0' align="middle">
						&nbsp;清空
					</button>
				</div>
			</td>
		</tr>
	</table>
	<!-- 查询结束 -->
	<br>
	<!--列表开始 -->
	<h3>
		<img src="${pageContext.request.contextPath}/ui/images/khlb.png"
			border="0">
		&nbsp;省份资料列表
	</h3>
	<div class="control">
		<button class='button' onmouseover="this.className='button_over';"
			onMouseOut="this.className='button';" 
			onClick="addProvince('${pageContext.request.contextPath}/page/newPagePlan/sys/province/add.jsp')">
			<img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png"
				border='0' align="middle">
			&nbsp;新建
		</button>
		<button class='button' onMouseOver="this.className='button_over';"
			onMouseOut="this.className='button';"
			onClick="document.ActionForm.submit();">
			<img src="${pageContext.request.contextPath}/ui/images//button/shanchu.png"
				border='0' align="middle">
			&nbsp;删除
		</button>
	</div>
	<!-- list -->
	<div class="border">
		<!-- 上部分页结束 -->
		<form name="ActionForm" method="post" action="${pageContext.request.contextPath}/province/deleteProvincesByIds.do">
			<span id="provinceTableStart"></span>
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				id="PowerTable" class="PowerTable">
				<!-- title -->
				<tr>
					<td width="6%" class="listViewThS1">
						<input type="checkbox" name='checkall' id='checkall'
							class="checkbox" onClick="checkAll()">全选
					</td>
					<td width="17%" class="listViewThS1">编号</td>
					<td width="27%" class="listViewThS1">省份名称</td>
					<td width="50%" class="listViewThS1">拼音码</td>
				</tr>
				<!-- data -->
				<c:forEach var="province" varStatus="s" items="${requestScope.provinceList}">
					<tr>
						<td>
							<input type="checkbox" name="ids" id="ids" value="${province.id}"
								class="checkbox" onClick="changeCheckCount();">
						</td>
						<td>${province.id}</td>
						<td>
							<a href="${pageContext.request.contextPath}/province/getProvinceById/${province.id}">${province.name }</a>
						</td>
						<td>${province.pycode }</td>
					</tr>
				</c:forEach>
			</table>
		</form>
		<center>
			<input id="currPage" name="currPage" type="hidden" value="${requestScope.pageBean.currPage}"/>
			<input id="dataUrl" name="url" type="hidden" value="${requestScope.pageBean.url }"/>
			第<span id="curPageSpan">${requestScope.pageBean.currPage}</span>页/共<span id="totalPages">${requestScope.pageBean.totalPages}</span>页
			<a id="fristPage" href="javascript:void(0)" onclick="fristPageOnclick(this)">首页</a>
			<a id="prePage" href="javascript:void(0)" onclick="prePageOnclick(this)">上一页</a>
			<a id="nextPage" href="javascript:void(0)" onclick="nextPageOnclick(this)">下一页</a>
			<a id="lastPage" href="javascript:void(0)" onclick="lastPageOnclick(this)">尾页</a>
		</center>
	</div>
	<!--列表结束-->
</body>
</html>