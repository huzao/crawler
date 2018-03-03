<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爬虫</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
</head>
<body>
<div>
	<form action="controller/beginSelectOneBarFrom" method="post">
		baseurl:<input type="text" name="baseurl" id="baseurl"> <br><br>
		name:&nbsp;&nbsp;&nbsp;<input type="text" name="name" id="name"> <br><br>
		sta:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="sta" id="sta"> <br><br>
		end:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="end" id="end"> <br><br>
		barid:&nbsp;&nbsp;&nbsp;<input type="text" name="barid" id="barid"> <br><br>
		<input type="submit" value="提交">
	</form>
</div>
<br><br><br><br><br><br>
<div>
	<form action="controller/beginOneSelect" method="post">
		baseurl:<input type="text" name="baseurl" id="baseurl"> <br><br>
		name:&nbsp;&nbsp;&nbsp;<input type="text" name="name" id="name"> <br><br>
		<input type="submit" value="提交">
	</form>
</div>
<br><br><br><br><br><br>
<div>
	<form action="testip/testOne" method="post">
		<input type="submit" value="开始">
	</form>
</div>

</body>
</html>