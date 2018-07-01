<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<main class="main-wrapper" id="container">
	<div class="container">
		<form role="form" method="post">
			<input type="hidden" name="b_seq" value="${boardVO.b_seq}">
		</form>
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label> <input type="text"
					name="b_title" class="form-control" value="${boardVO.b_title}"
					readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Content</label>
				<textarea class="form-control" name="b_content" rows="3"
					readonly="readonly">${boardVO.b_content}</textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Writer</label> <input type="text"
					name="writer" class="form-control" value="${boardVO.u_name}"
					readonly="readonly">
			</div>
		</div>

		<div class="box-footer">
			<c:if test = "${boardVO.u_name==login.u_name}"> <!-- 글 작성자와 로그인한 사람이 같으면 -->
			<button type="submit" class="btn btn-warning modifyBtn">Modify</button>
			<button type="submit" class="btn btn-danger removeBtn">Remove</button>
			</c:if>
			<button type="submit" class="btn btn-primary goListBtn">Go List</button>
		</div>
	</div><!-- container -->
	<form role = "form" action = "modifyPage" method = "post">
		<input type = "hidden" name = "b_seq" value = "${boardVO.b_seq}">
		<input type = "hidden" name = "page" value = "${cri.page}">
		<input type = "hidden" name = "perPageNum" value = "${cri.perPageNum}">
	</form>
	<!-- 글에서 목록으로 넘어갈시 기존의 페이지로 가기 위함 -->
	</main>


	<jsp:include page="../inc/footter.jsp"></jsp:include>

	<!-- jQuery -->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/assets/jquery.min.js"><\/script>')
	</script>
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
		$(function() {
			$("#workingout").click(function() {
				$("#upload-modal").modal();
			});
			
			var result = '${msg}';
			// 글 작성이 완료 됬을시.
			if(result == 'SUCCESS'){ 
				alert("처리가 완료 되었습니다");
			}
			var formObj = $("form[role = 'form']");
			console.log(formObj)
			$(".modifyBtn").on("click", function(){
				formObj.attr("action", "/bbs/page");
				formObj.attr("method", "GET");
				formObj.submit();
			})// 수정 버튼 누르면 수정으로
			$(".removeBtn").on("click", function(){
				formObj.attr("action", "/bbs/pages");
				formObj.attr("method", "delete");
				formObj.submit();
			})// 삭제 버튼 누르면 삭제로
			$(".goListBtn").on("click", function(){
				formObj.attr("method", "get");
				formObj.attr("action", "/bbs");
				formObj.submit();
			})
			
		});
	</script>

</body>

</html>
