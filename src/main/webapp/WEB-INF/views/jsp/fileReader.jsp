<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content="IE=8" http-equiv="X-UA-Compatible"></meta>
<spring:url value="/resources/core/css/fileReader.css"
	var="fileReaderCss" />
<spring:url value="/resources/core/css/dataTable.css" var="datatableCss" />
<link href="${fileReaderCss}" rel="stylesheet" />
<link href="${datatableCss}" rel="stylesheet" />
<spring:url value="/resources/core/js/jquery.js" var="jqueryJs" />
<spring:url value="/resources/core/js/jquery.dataTables.js"
	var="jqueryDatableJs" />
<spring:url value="/resources/core/js/jquery-ui.js" var="jqueryUIJs" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<spring:url value="/resources/core/js/fileReader.js" var="fileReaderJs" />


<title>File Reader Count by Pradeep</title>
</head>

<body>

	<h2 align="center">FILE READER</h2>
	<h4>Please select file name from Drop Down and click show table
		data</h4>

	<select size="0" name="SelectFile" id="selFile">
		<option value="0">Select File Name</option>
	</select>
	<input type="submit" value="ShowTable" id="ShowTable">
	<br>
	<div id="div"></div>
	<br>
	<h4>File Details with Count</h4>
	<table id="fileReaderTable" class="dataGrid display">
		<thead>
			<tr>
				<th>Category</th>
				<th>Count</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<br>
	<h4>File Contents</h4>
	<table id="fileContentTable" class="dataGrid display">
		<thead>
			<tr>
				<th>Valid category and sub-category</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<script src="${jqueryJs}"></script>
	<script src="${jqueryUIJs}"></script>
	<script src="${jqueryDatableJs}"></script>
	<script src="${fileReaderJs}"></script>

</body>
</html>