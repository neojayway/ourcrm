<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>城市资料</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/popshow.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js"></script>
<script type="text/javascript">

//判断是否需要执行首页超链接跳转
function fristPageOnclick(){
	var $linkValue = $("#fristPage").html().trim();
	var $currPage = parseInt($("#currPage").val());
	if($currPage>1){
		doSearchCity($currPage, $linkValue);
	}
}

//判断是否需要执行上一页超链接跳转
function prePageOnclick(){
	var $linkValue = $("#prePage").html().trim();
	var $currPage = parseInt($("#currPage").val());
	if($currPage>1){
		doSearchCity($currPage, $linkValue);
	}
}

//判断是否需要执行下一页超链接跳转
function nextPageOnclick(){
	var $linkValue = $("#nextPage").html().trim();
	var $currPage =parseInt( $("#currPage").val());
	var $totalPages =parseInt( $("#totalPages").html().trim());
	if($currPage<$totalPages){
		doSearchCity($currPage, $linkValue);
	}
}

//判断是否需要执行尾页超链接跳转
function lastPageOnclick(){
	var $linkValue = $("#lastPage").html().trim();
	var $currPage = parseInt($("#currPage").val());
	var $totalPages = parseInt($("#totalPages").html().trim());
	if($currPage<$totalPages){
		doSearchCity($currPage, $linkValue);
	}
}

	$(function(){
		$.ajax({
			url:'${pageContext.request.contextPath}/province/getAllProvinceForCity',
			type:'get',
			dataType:'json',
			success:function(data){
				//移除之前页面的下拉框
				$("#pid").remove;
				var $select = $("<select id='pid' name='pid' style='width:140px' onChange='doSearchCity()'>");
				for(var i =0;i<data.length;i++){
					var id = data[i].id;
					var name = data[i].name;
					var $option = null;
					if(id == 1){
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

		$.ajax({
			url:'${pageContext.request.contextPath}/city/getCitysByProvince.do?pid=1',
			type:'get',
			dataType:'json',
			success:function(data){
				$("#PowerTable").remove();
				var $cityTable=$("<table width='100%' border='0' cellspacing='0' cellpadding='0' id='PowerTable' class='PowerTable'>");
				var $tr11=$("<tr></tr>");
				$tr11.appendTo($cityTable);
		    	var $td11=$("<td width='7%' class='listViewThS1'><input type='checkbox' name='checkall' id='checkall' class='checkbox' onClick='checkAll()'>全选</td>"); 
			   	var $td12=$("<td width='33%' class='listViewThS1'>名称</td>");   
			   	var $td13=$("<td width='30%' class='listViewThS1'>拼音码</td>");
			   	var $td14=$("<td width='15%' class='listViewThS1'>邮政编码</td>");    	  	  		
		  	    var $td15=$("<td width='15%' class='listViewThS1'>区号</td>");
		  	    $td11.appendTo($tr11);
		  	    $td12.appendTo($tr11);
			  	$td13.appendTo($tr11);
			  	$td14.appendTo($tr11);
			  	$td15.appendTo($tr11);
			  	if(data.cityList.length==0){
					var $tr12=$("<tr><td colspan=5>该省份尚未添加附属城市，请尽快完善基础信息！</td></tr>");
					$tr12.appendTo($cityTable);
				}else{
				  	for(var i=0;i<data.cityList.length;i++){
						var id=data.cityList[i].id;
						var name=data.cityList[i].name;
						var pycode=data.cityList[i].pycode;
						var pid=data.cityList[i].pid;
						var postcode=data.cityList[i].postcode;
						var areacode=data.cityList[i].areacode;
						var $tr21=$("<tr>");
						$tr21.appendTo($cityTable);
						var $td21=$("<td><input type='checkbox' name='ids' value='"+id+"' class='checkbox' onClick='changeCheckCount();'></td>");
						$td21.appendTo($tr21);
						var $td22=$("<td><a href='${pageContext.request.contextPath}/city/getCityById/"+id+"'>"+name+"</a></td>");
						$td22.appendTo($tr21);
						var $td23=$("<td>"+pycode+"</td>");
						$td23.appendTo($tr21);
						var $td24=$("<td>"+postcode+"</td>");
						$td24.appendTo($tr21);
						var $td25=$("<td>"+areacode+"</td>");
						$td25.appendTo($tr21);
						var $tr22 = $("</tr>");
						$tr22.appendTo($cityTable);
					}
				}
			  	$cityTable.appendTo("#cityTable");
				$("#cityTable").append("</table>");
				$("#currPage").val(data.pageBean.currPage);
				$("#curPageSpan").html(data.pageBean.currPage);
				$("#totalPages").html(data.pageBean.totalPages);
			}
		});
	});

	//一但省份的下拉框发生改变就执行 城市查询
	function doSearchCity($currPage, $linkValue){
		//获取到下拉框中选中的value值
		 var pid=$("#pid").val();
		 var url = '${pageContext.request.contextPath}/city/getCitysByProvince.do?pid='+pid;

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
				$("#PowerTable").remove();
				var $cityTable=$("<table width='100%' border='0' cellspacing='0' cellpadding='0' id='PowerTable' class='PowerTable'>");
				var $tr11=$("<tr></tr>");
				$tr11.appendTo($cityTable);
		    	var $td11=$("<td width='7%' class='listViewThS1'><input type='checkbox' name='checkall' id='checkall' class='checkbox' onClick='checkAll()'>全选</td>"); 
			   	var $td12=$("<td width='33%' class='listViewThS1'>名称</td>");   
			   	var $td13=$("<td width='30%' class='listViewThS1'>拼音码</td>");
			   	var $td14=$("<td width='15%' class='listViewThS1'>邮政编码</td>");    	  	  		
		  	    var $td15=$("<td width='15%' class='listViewThS1'>区号</td>");
		  	    $td11.appendTo($tr11);
		  	    $td12.appendTo($tr11);
			  	$td13.appendTo($tr11);
			  	$td14.appendTo($tr11);
			  	$td15.appendTo($tr11);
			  	if(data.cityList.length==0){
					var $tr12=$("<tr><td colspan=5>该省份尚未添加附属城市，请尽快完善基础信息！</td></tr>");
					$tr12.appendTo($cityTable);
				}else{
				  	for(var i=0;i<data.cityList.length;i++){
						var id=data.cityList[i].id;
						var name=data.cityList[i].name;
						var pycode=data.cityList[i].pycode;
						var pid=data.cityList[i].pid;
						var postcode=data.cityList[i].postcode;
						var areacode=data.cityList[i].areacode;
						var $tr21=$("<tr>");
						$tr21.appendTo($cityTable);
						var $td21=$("<td><input type='checkbox' name='ids' value='"+id+"' class='checkbox' onClick='changeCheckCount();'></td>");
						$td21.appendTo($tr21);
						var $td22=$("<td><a href='${pageContext.request.contextPath}/city/getCityById/"+id+"'>"+name+"</a></td>");
						$td22.appendTo($tr21);
						var $td23=$("<td>"+pycode+"</td>");
						$td23.appendTo($tr21);
						var $td24=$("<td>"+postcode+"</td>");
						$td24.appendTo($tr21);
						var $td25=$("<td>"+areacode+"</td>");
						$td25.appendTo($tr21);
						var $tr22 = $("</tr>");
						$tr22.appendTo($cityTable);
					}
				}
			  	$cityTable.appendTo("#cityTable");
				$("#cityTable").append("</table>");
				$("#currPage").val(data.pageBean.currPage);
				$("#curPageSpan").html(data.pageBean.currPage);
				$("#totalPages").html(data.pageBean.totalPages);
			}
		});
	}

	function forward(strURL){
	    window.location=strURL;
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

	function addCity(url){
		window.location.href=url;
	}
	
</script>
</head>

<body>
	<div id="popshow" style='border:1px solid #6A82A8;width=650px;position: absolute; visibility: hidden; left: 0; top: 0; z-index: 10;'>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr style='background-color:#6A82A8;'>
			<th width='80%' height="25" align='left' 
				onMouseDown=initializedragie(popshow) style="cursor:move" 
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
	<iframe src="javascript:false" style="position:absolute; visibility:inherit; 
		top:0px; left:0px; width:100%; height:100%; z-index:-1; 
		filter='progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=0)'; frameborder='0';">
	</iframe>
	</div>
	<div class="mtitle">
		<div class="mtitle-row">&nbsp;</div>
		城市资料
	</div>
	<br>
	<h3>
		<img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" 
			border="0">
		&nbsp;城市资料搜索
	</h3>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" 
			class="tabForm" name="base" id="base">
			<tr>
		    	<td width="38%" height="45" nowrap>省份：
		    		<span id="selectProvince"></span>
				</td>
		  	    <td width="39%" nowrap>&nbsp;</td>
		  	    <td width="23%" align="center">
					<div class="control">
					</div>
				</td>
			</tr>
		</table>
	<br>
	<h3>
		<img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" 
			border="0">
		&nbsp;城市资料列表
	</h3>
	<div class="control">
		<button type='button' class='button' 
			onMouseOver="this.className='button_over';" 
			onMouseOut="this.className='button';"  
			onClick="addCity('${pageContext.request.contextPath}/page/newPagePlan/sys/city/add.jsp')">
			<img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png" 
				border='0' align='absmiddle'>
			&nbsp;新建
		</button>
		<button type='button' class='button' 
			onMouseOver="this.className='button_over';" 
			onMouseOut="this.className='button';"  
			onClick="document.ActionForm.submit();">
			<img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" 
				border='0' align='absmiddle'>
			&nbsp;删除
		</button>
	</div>
	<!-- list -->
	<div class="border">
		<form name="ActionForm" method="post" action="${pageContext.request.contextPath}/city/deleteCitys.do">
			<p id="cityTable"></p>
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
</body>
</html>