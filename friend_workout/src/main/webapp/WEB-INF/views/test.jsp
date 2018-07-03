<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<!-- header end -->
	<jsp:include page="../inc/upload-modal.jsp"/>
    <main>
    <div class = "container" style="border: 20px solid green;">
        <h2> Ajax</h2>
        <ul id = "replies">
        </ul>
        <div>
        	<div>
        	Reply <input type ='text' name = "u_name" id = 'writer'>
        	</div>
        	Context <input type = "text" name = "r_content" id = "content">
        </div>
        <button id = "replyAddBtn"> ADD REPLY</button>
    </div>
    <div id = "modDiv" style = "display: none;">
    	<div class = "modal-title"></div>
    	<div>
    	<input type = "text" id = "r_content">
    	</div>
    	<div>
    	<button type = "button" id = "replyModBtn">Modify</button>
    	<button type = "button" id = "replyDelBtn">Delete</button>
    	<button type = "button" id = "closeBtn">close</button>
    	</div>
    </div>
    <ul class = "pagination">
    </ul>
    </main>
<style>
#modDiv{
width:300px;
height:100px;
background-color:gray;
position:absolute;
top:50%;
left:50%;
margin-top:-50px;
margin-left:-150px;
padding:10px;
z-index:1000;}
</style>

<!-- Image Gallery --> 
<!-- jQuery --> 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script> 
<script>window.jQuery || document.write('<script src="js/assets/jquery.min.js"><\/script>')</script> 
<script src="/resources/js/assets/plugins.js" type="text/javascript"></script> 
<script src="/resources/js/assets/bootstrap.min.js" type="text/javascript"></script> 
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script> 
<script src="/resources/js/maps.js" type="text/javascript"></script> 
<script src="/resources/js/custom.js" type="text/javascript"></script> 
<script src="/resources/js/jquery.contact.js" type="text/javascript"></script> 
<script src="/resources/js/main.js" type="text/javascript"></script> 
<script src="/resources/js/gallery/masonry.pkgd.min.js" type="text/javascript"></script> 
<script src="/resources/js/gallery/imagesloaded.pkgd.min.js" type="text/javascript"></script> 
<script src="/resources/js/gallery/jquery.infinitescroll.min.js" type="text/javascript"></script> 
<script src="/resources/js/gallery/main.js" type="text/javascript"></script> 
<script src="/resources/js/jquery.nicescroll.min.js" type="text/javascript"></script>    
<script>
$(function(){
    $("#workingout").click(function(){
        $("#upload-modal").modal();
    });
    var b_seq = 323;
    getPageList(1); // 처음 동작시 1페이지 가져오도록
    function getAllList(){
        $.getJSON("/rep/" + b_seq, function(data){
        	var str = "";
        	console.log(data.length);
        	
        	$(data).each(
        		function(){
        			str += "<li data-rseq='"+this.r_seq+"' class ='replyLi'>"
        			+ this.r_seq + ":" +this.r_content +"<button>수정</button></li>";
        		});
        	$("#replies").html(str);
        	
        });	
    }; // getAllList
    
    $("#replyAddBtn").on("click", function(){
    	var u_name = $("#writer").val();
    	var r_content = $("#content").val();
    	$.ajax({
    		type : 'post',
    		url : '/rep',
    		headers : {"Content-Type" : "application/json", 
    			"X-HTTP-Method-Override" : "POST"},
    		dataType :'text',
    		data : JSON.stringify({
    			b_seq : b_seq,
    			u_name : u_name,
    			r_content : r_content
    		}),
    		success : function(res){
    			if(res == 'SUCCESS'){
    				alert("등록")
    				getAllList(); // 등록후 목록을 불러오기 위함 	
    			}
    		}
    	})
    }) // #replyAddBtn
    
    $('#replies').on('click', '.replyLi button', function(){
    	var reply = $(this).parent();
    	var r_seq = reply.attr("data-rseq");
    	var r_content = reply.text();
    	alert(r_seq + ":" + r_content);
    	$('.modal-title').html(r_seq);
    	$('#r_content').val(r_content);
    	$('#modDiv').show('slow');
    });
    var u_name = $("#u_name").val();
    var r_content = $("#r_content").val();
    $('#replyDelBtn').on('click', function(){
    	var r_seq = $('.modal-title').html();
    	var r_content = $('#r_content').val();
    	$.ajax({
    		type : 'delete',
    		url : '/rep/' + r_seq,
    		headers :{
    			"Content-Type" : "application/json",
    			"X-HTTP-Method-Override" : "DELETE"
    		},
    		dataType :"text",
    		success :function(res){
    			console.log("res " + res);
    			if(res == 'SUCCESS'){
    				alert('삭제 완료');
    				$('#modDiv').hide('slow');
    				getAllList();
    			}
    		}
    	})
    }); // delete Btn
    
    $('#replyModBtn').on('click', function(){
    	var r_content = $('#r_content').val();
    	var r_seq = $('.modal-title').html();
    	$.ajax({
    		type:'put',
    		url:'/rep/' + r_seq,
    		headers:{
    			"Content-Type" : "application/json",
    			"X-HTTP-Method-Override" : "PUT"
    		},
    		data:JSON.stringify({r_content:r_content}),
    		success:function(res){
    			if(res == 'SUCCESS'){
    				aler("yes mod")
    				$('#modDiv').hide('slow');
    				getPageList(replyPage)// 페이징 처리를 위함
    			}
    		}   		
    	})	
    }) // mod Btn
    
    function getPageList(page){
    	$.getJSON("/rep/" + b_seq + "/" + page, function(data){
    		console.log(data.list.length);
    		var str = "";
    		
    		$(data.list).each(function(){
    			str += "<li data-rseq='" + this.r_seq + "'class = 'replyLi'>"
    			+ this.r_seq + ":" +this.r_content + "<button>MOD</button></li>";
    		});
    		$("#replies").html(str);
    		printPaging(data.pageMaker);
    	})
    } // getPageList
    
    function printPaging(pageMaker){
    	var str = "";
    	if(pageMaker.prev){
    		str += "<li><a href = '" + (pageMaker.startPage-1) +"'> << </a></li>";
    	}
    	for (var i = pageMaker.startPage, len = pageMaker.endPage; i<=len; i++){
    		var strClass = pageMaker.cri.page == i?'class=active':'';
    		str+= "<li "+strClass+"><a href = '"+i+"'>"+i+"</a></li>";
    	}
    	if(pageMaker.next){
    		str += "<li><a href ='" + (pageMaker.endPage+1)+"'> >> </a></li>";
    	}
    	$('.pagination').html(str);
    }
    // 페이지 번호 이벤트 출력
    var replyPage = 1;
    $('.pagination').on("click", "li a", function(){
    	event.preventDefault();
    	replyPage = $(this).attr("href");
    	getPageList(replyPage);
    });
    
});
</script>

</body>

</html>
