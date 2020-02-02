<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<style type="text/css">
body {
	background-image: url("1.jpg");
	background-size: 100%;
	background-color: #cccccc;
}

#popup h3 {
	position: fixed;
	top: 50%;
	left: 50%;
	-ms-transform: translate(-50%, -50%);
	-webkit-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
	padding: .5% 1% 1%;
	border: 0px solid rgb(100, 100, 100);
	font-size: 140%;
	font-weight: 600;
	text-align: left;
	text-shadow: -1px -1px #666;
	color: rgb(240, 240, 240);
	background: linear-gradient(-45deg, black 0, CornflowerBlue 100%);
}

#title {
	position: fixed;
	center: 0;
	padding: 10px;
	background: linear-gradient(0.25turn, white, CornflowerBlue, black, CornflowerBlue,
		white);
	color: #fff;
	width: 100%;
}
</style>
</head>
<body>
	<h1 id="title" style="text-align: center; color: red">- ERROR 500 -</h1>
	<br />
	<div id="popup" style="text-align: center">
		<br />
		<h3>
			Request from ${pageContext.errorData.requestURI} is failed 
			<br />
			Servlet name: ${pageContext.errorData.servletName} 
			<br /> 
			Status code: ${pageContext.errorData.statusCode} 
			<br /> 
			Exception: ${pageContext.exception} 
			<br /> 
			Message from exception:	${pageContext.exception.message} 
			<br />
			<%@ include file="/jsp/home_button.jsp"%>
		</h3>
	</div>
	<%@ include file="/jsp/footer.jsp"%>
</body>
</html>