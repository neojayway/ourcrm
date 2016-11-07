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
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js"></script>
<script type="text/javascript">
	function getData(){
		var str = $("[name='name']").val();
		//判断文本框是否输入值，没输入就查所有
		if(str == null || str=="" || $.trim(str).length==0) str = -1;

		$.ajax({
			url:'${pageContext.request.contextPath}/province/fuzzySearchProvince/'+str,
			type:'get',
			dataType:'json',
			success:function(data){
				//移除之前的表格
				$("#PowerTable").remove();
				var $table=$("<table width='100%' border='0' cellspacing='0' cellpadding='0' id='PowerTable' class='PowerTable'>");
				var $tr11=$("<tr></tr>");
				$tr11.appendTo($table);
				var $td11=$("<td width='4%' class='listViewThS1'><input type='checkbox' name='checkall' value='' class='checkbox' onClick='CheckAll(this.checked);changeCheckCount();'></td>");
				var $td12=$("<td width='19%' class='listViewThS1'>编号</td>");
				var $td13=$("<td width='27%' class='listViewThS1'>省份名称</td>");
				var $td14=$("<td width='50%' class='listViewThS1'>拼音码</td>");
				$td11.appendTo($tr11);
				$td12.appendTo($tr11);
				$td13.appendTo($tr11);
				$td14.appendTo($tr11);
				if(data!=null){
					for (var i = 0; i < data.length; i++) {
						var id = data[i].id;
						var name = data[i].name;
						var pycode = data[i].pycode;
						var $tr21 = $("<tr>");
						$tr21.appendTo($table);
						var $td21 = $("<td><input type='checkbox' name='ids' value='"+id+"' class='checkbox' onClick='changeCheckCount();'></td>");
						$td21.appendTo($tr21);
						var $td22 = $("<td>"+id+"</td>");
						$td22.appendTo($tr21);
						var $td23 = $("<td><a href='#' onClick="+"OpenDiv('edit.jsp')"+">"+name+"</a></td>");
						$td23.appendTo($tr21);
						var $td24 = $("<td>"+pycode+"</td>");
						$td24.appendTo($tr21);
						var $tr22 = $("</tr>");
						$tr22.appendTo($table);
					}
				}else{
					var $tr12=$("<tr><td colspan=4>未查询到与  [ "+str+" ] 相关的任何信息,请重新查询！</td></tr>");
					$tr12.appendTo($table);	
				}
				$table.appendTo("#provinceTableStart");
				$("#provinceTableStart").append("</table>");
			}
		});
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
					style="width: 140px" onchange="getData(this)"/>
			</td>
			<td width="39%" nowrap>&nbsp;</td>
			<td width="23%" align="center">
				<div class="control">
					<button class='button' onMouseOver="this.className='button_over';"
						onMouseOut="this.className='button';" onClick="">
						<img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png"
							border='0' align="middle">
						&nbsp;搜索
					</button>
					<button class='button' onMouseOver="this.className='button_over';"
						onMouseOut="this.className='button';" onClick="">
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
			onMouseOut="this.className='button';" onClick="OpenDiv('add.jsp')">
			<img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png"
				border='0' align="middle">
			&nbsp;新建
		</button>
		<button class='button' onMouseOver="this.className='button_over';"
			onMouseOut="this.className='button';"
			onClick="delForm('province.do?method=delete')">
			<img src="${pageContext.request.contextPath}/ui/images//button/shanchu.png"
				border='0' align="middle">
			&nbsp;删除
		</button>
		<button class='button' onMouseOver="this.className='button_over';"
			onMouseOut="this.className='button';"
			onClick="forward('province.do?method=search')">
			<img src="${pageContext.request.contextPath}/ui/images/button/shuaxin.png"
				border='0' align="middle">
			&nbsp;刷新
		</button>
	</div>
	<!-- list -->
	<div class="border">
		<!-- 上部分页结束 -->
		<form name="ActionForm" method="post" action="">
			<span id="provinceTableStart"></span>
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				id="PowerTable" class="PowerTable">
				<!-- title -->
				<tr>
					<td width="4%" class="listViewThS1">
						<input type="checkbox" name="checkall" value="" 
							class="checkbox" 
							onClick="CheckAll(this.checked);changeCheckCount();">
					</td>
					<td width="19%" class="listViewThS1">编号</td>
					<td width="27%" class="listViewThS1">省份名称</td>
					<td width="50%" class="listViewThS1">拼音码</td>
				</tr>
				<!-- data -->
				<c:forEach var="province" varStatus="s" items="${requestScope.provinces}">
					<tr>
						<td>
							<input type="checkbox" name="ids" value="5"
								class="checkbox" onClick="changeCheckCount();">
						</td>
						<td>${province.id}</td>
						<td>
							<a href="#" onClick="OpenDiv('edit.jsp')">${province.name }</a>
						</td>
						<td>${province.pycode }</td>
					</tr>
					
				</c:forEach>
				<!-- <tr>
					<td>
						<input type="checkbox" name="ids" value="5"
							class="checkbox" onClick="changeCheckCount();">
					</td>
					<td>5</td>
					<td>
						<a href="#" onClick="OpenDiv('edit.jsp')">安徽省</a>
					</td>
					<td>ahs</td>
				</tr>

				<tr>
					<td>
						<input type="checkbox" name="ids" value="1"
							class="checkbox" onClick="changeCheckCount();">
					</td>
					<td>1</td>
					<td>
						<a href="#" onClick="OpenDiv('province.do?method=load&id=1')">
							北京市
						</a>
					</td>
					<td>bjs</td>
				</tr> -->
			</table>
		</form>
		<%-- <%@ include file="/include/page.jsp" %> --%>
	</div>
	<!--列表结束-->
</body>
</html>