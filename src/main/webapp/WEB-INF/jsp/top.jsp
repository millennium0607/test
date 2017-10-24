<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="container-fluid">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		<span class="sr-only">导航</span>
		<span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">heihei</a>
	</div>
	<div id="navbar" class="navbar-collapse collapse">
		<ul class="nav navbar-nav navbar-right">
			<li>
			<a href="<%=request.getContextPath()%>/manager/index">1</a>
			</li>
			<li><a href="<%=request.getContextPath()%>/player/list">2</a></li>
			<!-- 
            <li><a href="#">城市</a></li>
            <li><a href="#">科技</a></li>
            <li><a href="#">军官</a></li>
            <li><a href="#">军团</a></li>
            <li><a href="#">道具</a></li>
             -->
			<li><a href="<%=request.getContextPath()%>/mail/index">3</a></li>
			<li><a href="<%=request.getContextPath()%>/prototype/index">4</a></li>
			<li><a href="<%=request.getContextPath()%>/user/list">5</a></li>
		</ul>
	</div>
</div>
</nav>
<div class="container">
	<div class="row">
		<div class="span4">
			<c:if test="${not empty alert}">
			<div class="alert alert-${alert.style} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<strong>${alert.title}</strong> ${alert.content}
			</div>
			</c:if>
		</div>
	</div>
</div>