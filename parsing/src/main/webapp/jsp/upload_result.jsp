<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>UPLOAD RESULT PAGE</title>
<style type="text/css">
body {
	background-image: url("1.jpg");
	background-size: 100%;
	background-color: #cccccc;
}

#popup form {
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
	text-align: right;
	text-shadow: -1px -1px #666;
	color: rgb(240, 240, 240);
	background: linear-gradient(-45deg, black 0, CornflowerBlue 100%);
}
#popup h5 {
	position: fixed;
	top: 80%;
	left: 50%;
	-ms-transform: translate(-50%, -50%);
	-webkit-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
	padding: .5% 1% 1%;
	border: 0px solid rgb(100, 100, 100);
	font-size: 140%;
	font-weight: 600;
	text-align: right;
	text-shadow: -1px -1px #666;
	color: rgb(240, 240, 240);
	background: linear-gradient(-45deg, black 0, CornflowerBlue 100%);
}
</style>
</head>
<body>
	<h1 style="text-align: center"><%@ include file="/jsp/title.jsp"%></h1>
	<div id="popup">
		<form action="controller" method="post" name="action"
			style="text-align: center">
			<%=request.getAttribute("result")%>
			<br /> <input type="hidden" value="${file}" name="filePath"
				style="color: white;"> <br />PLEASE CHOOSE A PARSER &emsp;
			<br /> <select name="menu" size="1" style="text-align: center">
				<option selected="selected" value="DOM">DOM parser</option>
				<option value="SAX">SAX parser</option>
				<option value="STAX">STAX parser</option>
				
			</select> <br> <br> <input type="submit" value="PARSING"
				name="action" class="button"> <br>
				<%@ include file="/jsp/back_button.jsp"%>
		</form>
	</div>

	<%@ include file="/jsp/footer.jsp"%>
</body>
</html>