<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel='stylesheet' href="<%=request.getContextPath()%>/webjars/bootstrap/3.3.6/css/bootstrap.min.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/webjars/jquery/2.2.4/jquery.min.js"></script>
</head>

<body>
	<div class="container">
		<form class="form-signin" action="<%=request.getContextPath()%>/user/login" method="post">
			<h2 class="form-signin-heading"></h2>
			<label for="inputEmail" class="sr-only">User name</label>
			<input type="text" id="userName" name="userName" class="form-control" placeholder="用户名" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="password" name="password" class="form-control" placeholder="密码" required>
			<div class="checkbox">
				<label>
					<input type="checkbox" value="remember-me">
					记住用户
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">
				登录
			</button>
		</form>
	</div>
</body>

</html>
