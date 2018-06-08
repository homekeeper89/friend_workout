<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <jsp:include page="../inc/link.html"/>  왜 안되는지 모르겠음-->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<title>:: Working Out! , Compete with friend</title>
<!-- Normalize -->
<link rel="stylesheet" href="/resources/css/assets/normalize.css" type="text/css">
<!-- Bootstrap -->
<link href="/resources/css/assets/bootstrap.min.css" rel="stylesheet" type="text/css">
<!-- Font-awesome.min -->
<link href="/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- Effet -->
<link rel="stylesheet" href="/resources/css/gallery/foundation.min.css"  type="text/css">
<link rel="stylesheet" type="text/css" href="/resources/css/gallery/set1.css" />
<!-- Main Style -->
<link rel="stylesheet" href="/resources/css/main.css" type="text/css">
<!-- Responsive Style -->
<link href="/resources/css/responsive.css" rel="stylesheet" type="text/css">
<script src="/resources/js/assets/modernizr-2.8.3.min.js" type="text/javascript"></script>
</head>

<body>
<!-- header -->
<header id="header" class="header">
  <div class="container-fluid">
    <hgroup> 
      <!-- nav -->
		<jsp:include page="../inc/nav.jsp"/> <!-- 위로 넘어가서 view랑 같은 라인 이므로 ..을 사용함 -->
      <!-- nav --> 
    </hgroup>
  </div>
</header>
<main class="main-wrapper" id="container"> 
	<form action = "/users/sessions" method = "post">
		<div class = "form-group has-feedback">
			<input type = "text" name = "email" class = "form-control"
			placeholder = "USER EMAIL"/>
			<span class = "glyphicon glyphicon-envelope form-control-feedback"></span>
		</div>
		<div class = "form-group has-feedback">
			<input type = "password" name = "pwd" class = "form-control"
			placeholder = "USER PASSWORD"/>
			<span class = "glyphicon glyphicon-envelope form-control-feedback"></span>
		</div>
		<div class = "row">
			<div class = "col-xs-8">
				<div class = "checkbox icheck">
					<label>
						<input type = "checkbox" name = "useCookie"> Remember Me
					</label>
				</div>
			</div>
			<div class = "col-xs-4">
				<button type = "submit" class = "btn btn-primary btn-block btn-flat">
					Sign in
				</button>
			</div>
		</div>
	</form>
</main>
</body>
<jsp:include page="../inc/footter.jsp"></jsp:include>
</html>