<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE>
<html>
<head>
<script src = "https://code.jquery.com/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3> hello</h3>
<div class="textView1"></div>
<script>
 $(document).ready(function() {
	$.ajax({
	url: '/uploadajax',
	processData: false,
	contentType: false,
	type: 'POST',
	success: function(data){
		alert(data);
		var str = "";
		str = "<div>" +
		"<img src = 'displayfile?fileName=" + data + "/'>" + data + "</div>";
		$(".textView1").append(str);
		
			}
		}
	);

});
</script>
</body>
</html>