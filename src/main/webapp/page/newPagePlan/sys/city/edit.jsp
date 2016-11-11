<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>城市修改</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css"
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/popshow.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js"
	type="text/javascript"></script>
<style type="text/css">
body {
	padding: 10px;
}
</style>
<script type="text/javascript">
$(function(){
	var pid = parseInt($("#pid").val());
	$.ajax({
		url:'${pageContext.request.contextPath}/province/getAllProvinceForCity',
		type:'get',
		dataType:'json',
		success:function(data){
			//移除之前页面的下拉框
			$("#pid").remove;
			var $select = $("<select id='pid' name='pid' style='width:140px'>");
			for(var i =0;i<data.length;i++){
				var id = data[i].id;
				var name = data[i].name;
				var $option = null;
				if(id == pid){
					$option = $("<option value='"+id+"' selected>"+name+"</option>");
				}else{
					$option = $("<option value='"+id+"'>"+name+"</option>");
				}
				$option.appendTo($select);
			}
			$select.appendTo("#selectProvince");
			$("#selectProvince").append("</select>");
		}
	});
});

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
</script>
</head>

<body>
	<form name="ActionForm" method="post" action="${pageContext.request.contextPath}/city/updateCity.do">
		<br>
		<div class="control">
			<button type='button' class='button'
				onMouseOver="this.className='button_over';"
				onMouseOut="this.className='button';"
				onClick="document.ActionForm.submit();">
				<img src="${pageContext.request.contextPath}/ui/images/button/baocun.png"
					border='0' align='absmiddle'>
				&nbsp;保存
			</button>
			<button type='button' class='button'
				onMouseOver="this.className='button_over';"
				onMouseOut="this.className='button';"
				onClick="history.go(-1)">
				<img src="${pageContext.request.contextPath}/ui/images/button/guanbi.png"
					border='0' align='absmiddle'>
				&nbsp;返回
			</button>
		</div>
		<span id="selectProvince"></span>
		<input type="hidden" name="pid" id="pid" value="${requestScope.city.pid}">
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
								<td class="red">名称：</td>
								<td>
									<input name="id" id="id" type="hidden" value="${requestScope.city.id}">
									<input name="name" type="text" class="input" id="name"
										style="width: 90%" onblur="name2pinyin()"
										value="${requestScope.city.name}">
								</td>
								<td class="red">拼音码：</td>
								<td>
									<input name="pycode" type="text" id="pycode" 
										style="width: 90%" readonly="true" class="disabled"
										value="${requestScope.city.pycode}">
								</td>
							</tr>
							<tr>
								<td>邮政编码：</td>
								<td>
									<input name="postcode" type="text" class="input"
										id="postcode" style="width: 90%"
										value="${requestScope.city.postcode}">
								</td>
								<td>区号：</td>
								<td>
									<input name="areacode" type="text" class="input"
										id="areacode" style="width: 90%"
										value="${requestScope.city.areacode}">
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<br />
	</form>
</body>
</html>