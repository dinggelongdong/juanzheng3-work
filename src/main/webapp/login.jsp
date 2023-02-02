<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>物资捐赠管理系统</title>
		<link type="text/css" rel="stylesheet" href="assets/css/login.css">
		<script type="text/javascript" src="assets/js/jquery-3.6.0.js"></script>
	</head>
	<body class="login_bj">
		<br />
		<br />
		<div class="zhuce_body">
			<br />
			<br />
			<br />
			<br />
			<h1 style="text-align: center;font-size: 40px;color: red;">物资捐赠管理系统</h1>
			<div class="zhuce_kong login_kuang">
				<div class="zc">
					<div class="bj_bai" >
						<h3>登录</h3>
						<span style="color: red" >${msg }</span>
						<form action="user_index" method="post">
							<input name="uAccount" id="uAccount" type="text" class="kuang_txt" placeholder="请输入登录账号">
							<input name="uPwd" id="uPwd" type="password" class="kuang_txt" placeholder="请输入登录密码"><br />
							<!-- <a href="#">忘记密码？</a> -->
							<input name="uRole" type="radio" value="0" />管理员&nbsp;
							<input name="uRole" type="radio" value="1" checked="checked" />普通用户
							<br /><br />
							<input name="登录" type="submit" class="btn_zhuce" value="登录" onclick="checkLogin()">
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
	
	<script type="text/javascript">
		function checkLogin() {
			var uAccount = $('#uAccount').val();
			var uPwd = $('#uPwd').val();
			if (uAccount == null || uAccount == '') {
				alert('请输入账号！');
				return false;
			} else if (uPwd == null || uPwd == '') {
				alert('请输入密码');
				return false;
			}
		}
	</script>
</html>