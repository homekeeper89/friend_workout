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
  <div class="container">
    <hgroup> 
      <!-- nav -->
		<jsp:include page="../inc/nav.jsp"/> <!-- 위로 넘어가서 view랑 같은 라인 이므로 ..을 사용함 -->
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
  		placeholder = "이메일을 입력해주세요">
  	</div>
  	<div class = "row">
  		<label for = "name">nickname</label><br><input type = "text" name = "u_name" id = "u_name" tabindex="2"
  		placeholder = "닉네임을 입력해주세요(English Only))">
  	</div>
  	<div class = "row">
        <label for = "pwd">비밀번호</label><br>
        <input type = "password" name = "pwd" id = "pwd" tabindex="3"
  		placeholder = "비밀번호를 입력해주세요(찾기 기능이 아직 없으니 신중하게, 운영자도 모릅니다)">
  	</div>
    <br>                
    <div class = "row">
    <label> 아래 부분은 차후 비교분석을 위해 필요한 정보이니<br>
        대략적으로 입력해주시면 감사하겠습니다.</label>                
    </div>
                    <br>
  	<div class = "row">
        <label for = "age">나이</label><br>
  		<input type = "number" name = "age" id = "age" tabindex="4"
  		placeholder = "나이를 입력해주세요">
  	</div>
  	  	<div class = "row">
  	  	<label for = "sex">성별을 선택하여주세요</label><br>
  	  	<select name = "sex" id = "sex" tabindex = "5"
                style="width:170px;height:30px">
  	  		<option value = "0"> 남자 </option>
  	  		<option value = "1"> 여자 </option>
  	  	</select>
  	</div>
  	<div class = "row">
        <label for = "weight">몸무게를 입력해주세요</label><br>
  		<input type = "number" name = "weight" id = "weight" tabindex="6"
  		placeholder = "몸무게를 입력해주세요">
  	</div>
  	<div class = "row">
        <label for = "height">키를 입력해주세요</label><br>
  		<input type = "number" name = "height" id = "height" tabindex="7"
  		placeholder = "키를 입력해주세요">
  	</div>
  	<div class = "row">
  		<input type = "submit" value = "제출">
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