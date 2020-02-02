<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SHOW ALL PAGE</title>
<link href="css/external.css" rel="stylesheet">
</head>
<body>
	<h1 style="text-align: center"><%@ include file="/jsp/title.jsp"%></h1>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<div id="popup" style="text-align: center"><h5>
		TYPE OF PARSER:
		<%=request.getAttribute("parser")%></h5>
	</div>
	<br>
	<table>
		<tr>
			<td style="width: 5%; text-align: center;"><input type="text"
				value="#"
				style="background-color: CornflowerBlue; color: white; width: 70%; text-align: center;">
			</td>
			<td style="width: 10%; text-align: center;"><input type="text"
				value="NAME"
				style="background-color: CornflowerBlue; color: white; width: 80%; text-align: center;">
			</td>
			<td style="width: 10%; text-align: center;"><input type="text"
				value="PRECIOUSNESS"
				style="background-color: CornflowerBlue; color: white; width: 80%; text-align: center;">
			</td>
			<td style="width: 10%; text-align: center;"><input type="text"
				value="ORIGIN"
				style="background-color: CornflowerBlue; color: white; width: 80%; text-align: center;">
			</td>
			<td style="width: 20%; text-align: center;"><input type="text"
				value="DATE-TIME"
				style="background-color: CornflowerBlue; color: white; width: 80%; text-align: center;">
			</td>
			<td style="width: 10%; text-align: center;"><input type="text"
				value="VALUE"
				style="background-color: CornflowerBlue; color: white; width: 80%; text-align: center;">
			</td>
			<td style="width: 30%; text-align: center;"><input type="text"
				value="PARAMETERS"
				style="background-color: CornflowerBlue; color: white; width: 80%; text-align: center;">
			</td>
		</tr>
		<c:forEach items="${gems}" var="gem" varStatus="loop">
			<tr>
				<td style="width: 5%; text-align: center;"><input type="text"
					value="${loop.index+1}" style="width: 70%; text-align: center;"></td>
				<td style="width: 10%; text-align: center;"><input type="text"
					value="${gem.name}" style="width: 80%; text-align: center;">
				</td>
				<td style="width: 10%; text-align: center;"><input type="text"
					value="${gem.preciousness}" style="width: 80%; text-align: center;"></td>
				<td style="width: 10%; text-align: center;"><input type="text"
					value="${gem.origin}" style="width: 80%; text-align: center;">
				</td>
				<td style="width: 20%; text-align: center;"><input type="text"
					value="${gem.date}" style="width: 80%; text-align: center;">
				</td>
				<td style="width: 10%; text-align: center;"><input type="text"
					value="${gem.value}" style="width: 80%; text-align: center;">
				</td>
				<td style="width: 40%; text-align: center;"><input type="text"
					value="${gem.parameters}" style="width: 80%; text-align: center;">
				</td>
			</tr>
		</c:forEach>
	</table>
	<div style="text-align: center">
		<%@ include file="/jsp/back_button.jsp"%>
	</div>
	<%@ include file="/jsp/footer.jsp"%>
</body>
</html>