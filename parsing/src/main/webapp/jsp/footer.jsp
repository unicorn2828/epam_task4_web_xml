<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="by" scope="session" />
<fmt:setBundle basename="properties.pagecontent" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Footer</title>
<style type="text/css">
#footer {
	position: fixed;
	center: 0;
	bottom: 0;
	padding: 10px;
	background: linear-gradient(0.25turn, white, CornflowerBlue, black, CornflowerBlue,
		white);
	color: #fff;
	width: 100%;
}
</style>
</head>
<body>
	<div id="footer" style="text-align: center">	
		&copy; <fmt:message key="label.name" />
	</div>
</body>
</html>