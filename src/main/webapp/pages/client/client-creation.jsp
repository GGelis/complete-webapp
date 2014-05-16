<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<link rel="stylesheet" href=<c:url value="/template/css/bootstrap.css"/>>
		<link rel="stylesheet" href=<c:url value="/template/css/font-awesome.min.css"/>>
		<link rel="stylesheet" href=<c:url value="/template/css/plugin.css"/>>
		<link rel="stylesheet" href=<c:url value="/template/css/font.css"/>>
		<link rel="stylesheet" href=<c:url value="/template/css/style.css"/>>
		<link rel="stylesheet" href=<c:url value="/template/css/landing.css"/>>
</head>
	<body>
		<header id="header" class="navbar bg bg-black">
		    <a href="#" class="btn btn-link pull-right m-t-mini" data-toggle="class:bg-inverse" data-target="html"><i class="icon-lightbulb icon-xlarge text-default"></i></a>
		    <a class="navbar-brand" href="#">
				<c:if test="${isUpdate == true}">
					Update Client (firstName = ${client.firstName})
				</c:if>
				<c:if test="${isUpdate == false}">
					Save New Client
				</c:if>
			</a>
 	 	</header>
		<form:form action="save.do" commandName="client" method="POST">
		
			<form:hidden name="id" path="id"/>
			
			<div>
				<form:errors path="*"/>
			</div>
			
			<form:label path="firstName">firstName</form:label>
			<form:input name="firstName" path="firstName"/>
			
			<form:label path="lastName">lastName</form:label>
			<form:input name="lastName" path="lastName"/>
			
			<form:label path="address">address</form:label>
			<form:input name="address" path="address"/>
			
			<form:label path="login">login</form:label>
			<form:input name="login" path="login"/>
			
			<form:label path="password">password</form:label>
			<form:input name="password" path="password"/>

			<input class="icon-spin" type="submit" value="Validate"/>
			
		</form:form>
	</body>
</html>


















