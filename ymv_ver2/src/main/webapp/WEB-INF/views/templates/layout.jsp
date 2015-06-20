<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tiles Layout</title>
<script type="text/javascript" src="${initParam.root}resources/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${initParam.root}css/home.css" />
<%-- <link rel="stylesheet" type="text/css" href="${initParam.root}css/one.css" /> --%>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="http://bootswatch.com/cerulean/bootstrap.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
<div id="container">
	<div id="header"><tiles:insertAttribute name="header" /></div>
	<div id="left"><tiles:insertAttribute name="left" /></div>
	<div id="main"><tiles:insertAttribute name="main" /></div>
	<div id="footer"><tiles:insertAttribute name="footer" /></div>
</div>
</body>
</html>


