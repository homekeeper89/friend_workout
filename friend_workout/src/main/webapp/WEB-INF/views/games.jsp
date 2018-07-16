<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- <jsp:include page="../inc/link.html"/>  왜 안되는지 모르겠음-->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<title>:: Working Out! , Compete with friend</title>
<!-- Normalize -->
<link rel="stylesheet" href="/resources/css/assets/normalize.css"
	type="text/css">
<!-- Bootstrap -->
<link href="/resources/css/assets/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<!-- Font-awesome.min -->
<link href="/resources/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<!-- Effet -->
<link rel="stylesheet" href="/resources/css/gallery/foundation.min.css"
	type="text/css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/gallery/set1.css" />
<!-- Main Style -->
<link rel="stylesheet" href="/resources/css/main.css" type="text/css">
<!-- Responsive Style -->
<link href="/resources/css/responsive.css" rel="stylesheet"
	type="text/css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="/resources/js/assets/modernizr-2.8.3.min.js"
	type="text/javascript"></script>
</head>
<body>
	<!-- header -->
	<header id="header" class="header">
		<div class="container">
			<hgroup>
				<!-- nav -->
				<jsp:include page="../inc/nav.jsp" />
				<!-- 위로 넘어가서 view랑 같은 라인 이므로 ..을 사용함 -->
				<!-- nav -->
			</hgroup>
		</div>
	</header>
	<!-- header end -->
	<jsp:include page="../inc/upload-modal.jsp" />
	<main>
	<div class="container">
		<div class="row">
			<canvas id="myCanvas" height="320" width="480"></canvas>
			<div class="container">
				<table id="leaderBoard" border="1" style="border-color: aqua">
					<tr>
						<th>순위</th>
						<th>닉네임</th>
						<th>점수</th>
					</tr>
				</table>
			</div>

		</div>
		<div class="container">
			<div class="row">
				<input id="str_btn" type="button" value="Start" /> <input
					id="rec_btn" type="button" style="display: none" value="Record" />
				<input id="ret_btn" type="button" style="display: none"
					value="Reset" />
			</div>
		</div>
		<div id="record">
			점수 : <input type="text" id="score" value=""> 닉네임 : <input
				type="text" id="name" value="">
		</div>
	</div>
	</main>


	<!-- Image Gallery -->
	<!-- jQuery -->
	<script type="text/javascript" src="/resources/js/bricks.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="js/assets/jquery.min.js"><\/script>')</script>
	<script src="/resources/js/assets/plugins.js" type="text/javascript"></script>
	<script src="/resources/js/assets/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
	<script src="/resources/js/maps.js" type="text/javascript"></script>
	<script src="/resources/js/custom.js" type="text/javascript"></script>
	<script src="/resources/js/jquery.contact.js" type="text/javascript"></script>
	<script src="/resources/js/main.js" type="text/javascript"></script>
	<script src="/resources/js/gallery/masonry.pkgd.min.js"
		type="text/javascript"></script>
	<script src="/resources/js/gallery/imagesloaded.pkgd.min.js"
		type="text/javascript"></script>
	<script src="/resources/js/gallery/jquery.infinitescroll.min.js"
		type="text/javascript"></script>
	<script src="/resources/js/gallery/main.js" type="text/javascript"></script>
	<script src="/resources/js/jquery.nicescroll.min.js"
		type="text/javascript"></script>
	<script>
$(function(){
    $("#workingout").click(function(){
        $("#upload-modal").modal();
    });
    var sta_btn = document.getElementById("str_btn"); sta_btn.addEventListener("click",function(){
        draw();
    });
    var ret_btn = document.getElementById("ret_btn");
    ret_btn.addEventListener("click", function(){
        alert("점수도 리셋 됩니다!")
        window.location.reload();
    })
    var rec_btn = document.getElementById("rec_btn");
    rec_btn.addEventListener("click", function(){
        if(document.getElementById("name").value == ""){
            alert("이름을 입력해주세요!!")
            return ;
        }
        var leader = document.getElementById("leaderBoard").firstChild;
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        var name = document.createTextNode(document.getElementById("name").value);
        var score = document.createTextNode(document.getElementById("score").value);
        td.appendChild(name);
        tr.appendChild(td);
        document.getElementById("leaderBoard").insertBefore(tr, leader.firstChild);
    });
    
});
</script>

</body>

</html>
