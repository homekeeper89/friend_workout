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
<!-- modal start --> 
	<jsp:include page="../inc/upload-modal.jsp"/>
<!-- modal end -->
<main class="main-wrapper" id="container">
<div class = "container" style="padding-top: 20px">
    <div class = "panel-body">
        <div class = "row">
            <div class = "col-lg-12">
                <form id = "user/post" action="/users" method = "POST">
  	<div class = "row">
  		<label for ="email">Eamil</label><br><input type = "text" name = "email" id = "email" tabindex="1"
  		placeholder = "�̸����� �Է����ּ���">
  	</div>
  	<div class = "row">
  		<label for = "name">nickname</label><br><input type = "text" name = "u_name" id = "u_name" tabindex="2"
  		placeholder = "�г����� �Է����ּ���">
  	</div>
  	<div class = "row">
        <label for = "pwd">��й�ȣ</label><br>
        <input type = "password" name = "pwd" id = "pwd" tabindex="3"
  		placeholder = "��й�ȣ�� �Է����ּ���">
  	</div>
    <br>                
    <div class = "row">
    <label> �Ʒ� �κ��� ���� �񱳺м��� ���� �ʿ��� �����̴�<br>
        �뷫������ �Է����ֽø� �����ϰڽ��ϴ�.</label>                
    </div>
                    <br>
  	<div class = "row">
        <label for = "age">����</label><br>
  		<input type = "number" name = "age" id = "age" tabindex="4"
  		placeholder = "���̸� �Է����ּ���">
  	</div>
  	  	<div class = "row">
  	  	<label for = "sex">������ �����Ͽ��ּ���</label><br>
  	  	<select name = "sex" id = "sex" tabindex = "5"
                style="width:170px;height:30px">
  	  		<option value = "0"> ���� </option>
  	  		<option value = "1"> ���� </option>
  	  	</select>
  	</div>
  	<div class = "row">
        <label for = "weight">�����Ը� �Է����ּ���</label><br>
  		<input type = "number" name = "weight" id = "weight" tabindex="6"
  		placeholder = "�����Ը� �Է����ּ���">
  	</div>
  	<div class = "row">
        <label for = "height">Ű�� �Է����ּ���</label><br>
  		<input type = "number" name = "height" id = "height" tabindex="7"
  		placeholder = "Ű�� �Է����ּ���">
  	</div>
  	<div class = "row">
  		<input type = "submit" value = "����">
  	</div>
  	</form>
            </div>
        </div>
    </div>
      </div>
    </main>
</body>
<jsp:include page="../inc/footter.jsp"></jsp:include>
</html>