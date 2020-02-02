<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home Page</title>
<style type="text/css">
body {
	background-image: url("/img/1.jpg");
	background-size: 100%;
	background-color: #cccccc;
}
</style>
</head>
<body>
	<h1 style="text-align: center"><%@ include file="/jsp/title.jsp"%></h1>
	<div id="popup">
		<form action="controller" method="post" enctype="multipart/form-data"
			style="text-align: center">PLEASE CHOOSE A FILE
			<br />
			<br />
			<input type=file name="file" accept="application/xml"
				required="required" title="no file"
				style="text-align: background:white" />
				<br />
				<br /> 
			<input type="submit" value="UPLOAD" name="action" class="button">
		</form>
	</div>
	<%@ include file="/jsp/footer.jsp"%>
</body>
</html>