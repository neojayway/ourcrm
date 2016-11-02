<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	response.setHeader("Expires", "Sat,6 May 1995 12:00:00 GMT");
	response.setHeader("Cache-Control",
			"no-store,no-cache,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setContentType("text/html;charset=UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
	
</script>

<script>
	function initialize() {
		var mapProp = {
			center : new google.maps.LatLng(51.508742, -0.120850),
			zoom : 5,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("googleMap"),
				mapProp);
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>

<body>
	<div id="googleMap" style="width: 500px; height: 380px;"></div>

</body>
</html>