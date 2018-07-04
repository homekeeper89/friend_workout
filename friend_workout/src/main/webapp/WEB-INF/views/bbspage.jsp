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
	<!-- 댓글 작성을 위한 div -->
	<div class = "container">
	<div class = "row">
		<div class = "col-md-12">
			<div class = "box box-success">
				<div class = "box-header">
					<h3 class = "box-title">댓글남기기</h3>
				</div>
				<div class = "box-body">
					<label for = "repWriter">작성자</label>
					<input class = "form-control" type = "text" placeholder="USER Id"
					id = "repWriter" value = "${login.u_name}">
					<label for = "repContent">댓글 내용</label>
					<input class ="form-control" type = "text"
					placeholder = "REPLY TEXT" id = "repContent">
				</div>
				<div class = "box-footer">
					<button type = "submit" class = "btn btn-primary" id = "replyAddBtn">
					댓글 남기기
					</button>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!--  ^ 댓글 작성을 위한 div -->
	<div class = "container">
	<!-- 페이징 처리를 위함 -->
	<ul class = "timeline">
	<li class = "time-label" id = "repliesDiv"><span class = "bg-green">ReplyList</span></li>
	</ul>
	<div class = "text-center">
		<ul id = "pagination" class = "pagination pagination-sm no-margin">
			
		</ul>
	</div>
	</div>
	</main>
<!--  modal 은 무조건 위치 고정을 위해 제일 아래에 기입하자-->
	<div id = "modifyModal" class = "modal modal-primary fade" role = "dialog">
		<div class = "modal-dialog">
			<div class = "modal-content">
				<div class = "modal-header">
					<button type = "button" class = "close" data-dismiss = "modal">&times;</button>
					<h4 class = "modal-title"></h4>
				</div>
				<div class = "modal-body" data-req>
					<input type = "hidden" id = "replyuser" class = "form-control">
					<p><input type = "text" id = "replytext" class = "form-control"></p>
				</div>
				<div class = "modal-footer">
					<button type = "button" class = "btn btn-info" id = "replyModBtn">Mod</button>
					<button type = "button" class = "btn btn-danger" id = "replyDelBtn">delete</button>
					<button type = "button" class = "btn btn-default" data-dismiss="modal">Close</button>					
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../inc/footter.jsp"></jsp:include>

	<!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
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

	<script id = "template" type = "text/x-handlebars-template">
	{{#each .}}
	<li class = "replyLi" data-req = {{r_seq}}>
		<div class = "timeline-item">
                <div class = "row">
                <div class = "col-xs-4">
                <span class = "time">
				<i class = "fa fa-clock-o"></i>{{prettifyDate r_regdate}} </span>    
                </div>
                </div>
                <div class ="row">
                <div class = "col-xs-4">
                 <h5>작성자 : <a class = "timeline-header">{{u_name}}</a></h5>
                </div>
                    <div class = "col-xs-6">
                <div class = "timeline-body"><h3><i class = "fa fa-comments bg-blue"></i>{{r_content}}</h3></div>
                    <div class = "row">
                <div class = "col-xs-8"></div>
				<div class = "timeline-footer">
					<a class ="btn btn-primary btn-xs"
					data-toggle = "modal" data-target="#modifyModal">Modify</a>
                </div>
                </div>
                    </div>
				</div>
			</div>
	</li>
	{{/each}}
	</script>
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
			Handlebars.registerHelper("prettifyDate", function(timeValue){
				var dateObj = new Date(timeValue);
				var year = dateObj.getFullYear();
				var month = dateObj.getMonth() + 1;
				var date = dateObj.getDate();
				return year + "/"+month+"/"+date;
			});
			var printData = function(replyArr, target, templateObj){
				var template = Handlebars.compile(templateObj.html());
				var html = template(replyArr);
				$('.replyLi').remove();
				target.after(html);
			}
			var b_seq = ${boardVO.b_seq};
			var replyPage = 1;
			function getPage(pageInfo){
				$.getJSON(pageInfo, function(data){
					printData(data.list, $("#repliesDiv"), $('#template'));
					printPaging(data.pageMaker, $(".pagination"));
					$("#modifyModal").modal("hide");
				})
			}
			
			var printPaging = function(pageMaker, target){
				var str = "";
				if(pageMaker.prev){
					str += "<li><a href ='"+(pageMaker.startPage-1)+"'> << </a></li>";
				}
				for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++){
					var strClass = pageMaker.cri.page==i?'class=active':'';
					str+="<li "+strClass+"><a href ='"+i+"'>"+i+"</a></li>";
				}
				if(pageMaker.next){
					str+="<li><a href = '"+(pageMaker.endPage+1)+"'> >> </a></li>";
				}
				target.html(str);	
			}
			$("#repliesDiv").on("click", function(){
				if($(".timeline li").size() > 1){
					return;
				}
				getPage("/rep/" + b_seq + "/1");
			})
			
			$('.pagination').on('click', 'li a', function(){
				event.preventDefault();
				replyPage = $(this).attr("href");
				getPage("/rep/"+b_seq+"/"+replyPage);
			})
			$("#replyAddBtn").on("click", function(){
				if($("#repWriter").val() == "" || $("#repContent").val() == ""){
					alert("로그인이 필요하거나 글 내용이 존재하지 않습니다.")
					return;
				}
				var replyObj = $("#repWriter");
				var replytextObj = $("#repContent");
				var replyer = replyObj.val(); // 작성자 값 가져옴
				var repText = replytextObj.val(); // 작성글 가져옴
				$.ajax({
					type : 'post',
					url : '/rep/',
					headers :{
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override":"POST"},
					dataType :"text",
					data : JSON.stringify({b_seq:b_seq, u_name:replyer, r_content:repText}),
					success : function(res){
						console.log("res : " + res);
						if(res == 'SUCCESS'){
							alert("등록되었습니다")
							replyPage = 1;
							getPage("/rep/"+b_seq+"/"+replyPage);
							replyObj.val("");
							replytextObj.val();
						}
					}
					
				});
			});
			
			$(".timeline").on("click", ".replyLi", function(event){
				var reply = $(this);
				if ("${login.u_name}" != reply.find(".timeline-header").text()){
					alert("수정권한이 없습니다");
					return ;
				}
				$("#replytext").val(reply.find(".timeline-body").text());
				$(".modal-title").html(reply.attr("data-req"));
			})
			
			$("#replyModBtn").on("click", function(){
				var r_seq = $(".modal-title").html();
				var replytext = $("#replytext").val();
				$.ajax({
					type : 'put',
					url:'/rep/'+r_seq,
					headers:{
						"Content-Type":"application/json",
						"X-HTTP-Method-Override":"PUT"},
					data:JSON.stringify({r_content:replytext}),
					dataType:'text',
					success:function(res){
						console.log("res" + res);
						if(res == 'SUCCESS'){
							alert("수정")	
							getPage("/rep/"+ b_seq+"/"+replyPage);
						}
					}
				})
			});
			
		$("#replyDelBtn").on("click", function(){
			var r_seq = $('.modal-title').html();
			var replytext = $("#replytext").val();
			$.ajax({
				type:'delete',
				url:'/rep/'+r_seq,
				headers:{
					"Content-type":"application/json",
					"X-HTTP-Method-Override":"DELETE"
				},
				dataType:'text',
				success:function(res){
					console.log("res : " + res);
					if(res == 'SUCCESS'){
						alert("삭제")
						getPage('/rep/'+b_seq+"/"+replyPage);
					}
				}
				
			})
		})
			
		});
	</script>
</body>
</html>
