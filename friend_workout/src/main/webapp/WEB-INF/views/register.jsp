<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <jsp:include page="../inc/link.html"/>  �� �ȵǴ��� �𸣰���-->
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
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="/resources/js/assets/modernizr-2.8.3.min.js" type="text/javascript"></script>
</head>

<body>
<!-- header -->
<header id="header" class="header">
  <div class="container-fluid">
    <hgroup> 
      <!-- nav -->
		<jsp:include page="../inc/nav.jsp"/> <!-- ���� �Ѿ�� view�� ���� ���� �̹Ƿ� ..�� ����� -->
      <!-- nav --> 
    </hgroup>
  </div>
</header>
<main class="main-wrapper" id="container"> 
  <!-- image Gallery -->
  <div class="wrapper">
  	<form id = "user/post" action="/user" method = "POST">
  	<div class = "row">
  		<input type = "text" name = "email" id = "email" tabindex="1"
  		placeholder = "�̸����� �Է����ּ���">
  	</div>
  	<div class = "row">
  		<input type = "text" name = "u_name" id = "u_name" tabindex="2"
  		placeholder = "�г����� �Է����ּ���">
  	</div>
  	<div class = "row">
  		<input type = "password" name = "pwd" id = "pwd" tabindex="3"
  		placeholder = "��й�ȣ�� �Է����ּ���">
  	</div>
  	<div class = "row">
  		<input type = "number" name = "age" id = "age" tabindex="4"
  		placeholder = "���̸� �Է����ּ���">
  	</div>
  	  	<div class = "row">
  	  	<label for = "sex">������ �����Ͽ��ּ���</label>
  	  	<select name = "sex" id = "sex" tabindex = "5">
  	  		<option value = "0"> ���� </option>
  	  		<option value = "1"> ���� </option>
  	  	</select>
  	</div>
  	<div class = "row">
  		<input type = "number" name = "weight" id = "weight" tabindex="6"
  		placeholder = "Ű�� �Է����ּ���">
  	</div>
  	<div class = "row">
  		<input type = "number" name = "height" id = "height" tabindex="7"
  		placeholder = "�����Ը� �Է����ּ���">
  	</div>
  	<div class = "row">
  		<input type = "submit" value = "����">
  	</div>
  	</form>
  </div>
</main>
</body>
<jsp:include page="../inc/footter.jsp"></jsp:include>
</html>