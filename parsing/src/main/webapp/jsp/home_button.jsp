<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Back Button</title>
<style type="text/css">
.button {
	text-align: center;
	cursor: pointer;
	padding: 1rem 3rem;
	display: inline-block;
	border-radius: 3px;
	margin: 1rem;
	text-decoration: none;
	font-family: system-ui;
	font-size: 16px;
	text-transform: uppercase;
	color: #fff !important;
	background-image: linear-gradient(-45deg, black 0, CornflowerBlue 100%);
	box-shadow: 0 3px 13px 0 rgba(14, 9, 3, 5.2), 0 11px 21px 0
		rgba(255, 166, 220, 0.004);
}
</style>
</head>
<body>
	<form action="controller" method="get" name="action"
		style="color: black; text-align: center">
		<input type="hidden" value="HOME" name="action">
		<input type="submit" value="HOME" name="action" class="button">
	</form>
</body>
</html>