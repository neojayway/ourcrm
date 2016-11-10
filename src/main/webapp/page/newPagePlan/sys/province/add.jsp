<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>省份新建</title>
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
function name2pinyin() {
	var provinceName = $("#name").val();
	$.ajax({
		url:'${pageContext.request.contextPath}/company/doPinYin/'+provinceName,
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
	<form name="ActionForm" method="post" action="${pageContext.request.contextPath}/province/saveProvince.do">
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
								<td class="red">省份名称：</td>
								<td>
									<input name="name" type="text" class="input" id="name"
										style="width:90%" onblur="name2pinyin()">
								</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td class="red">拼音码：</td>
								<td>
									<input name="pycode" type="text" id="pycode"
										style="width: 90%" readonly="true" class="disabled" >
								</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
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