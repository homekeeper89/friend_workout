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
    </main>


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
    function getAllList(){
        $.getJSON("/rep/" + b_seq, function(data){
        	var str = "";
        	console.log(data.length);
        	
        	$(data).each(
        		function(){
        			str += "<li data-rseq='"+this.r_seq+"' class ='replyLi'>"
        			+ this.r_seq + ":" +this.r_content +"</li>";
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
    var u_name = $("#u_name").val();
    var r_content = $("#r_content").val();
    
});
</script>

</body>

</html>
