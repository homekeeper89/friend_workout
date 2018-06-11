<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3> hello</h3>
<%-- <img src = "<c:url value = "\img\9b857fc4-f716-4cd1-a48f-d2fdc223434c_photo_2018-06-10_17-11-47.jpg"/>"/> --%>
<img src = "${pageContext.request.contextPath}\G:\friend\workingout\2018\06\11\s_9b857fc4-f716-4cd1-a48f-d2fdc223434c_photo_2018-06-10_17-11-47.jpg">	
	<%-- <img src="<c:url value="\img\${s_9b857fc4-f716-4cd1-a48f-d2fdc223434c_photo_2018-06-10_17-11-47.jpg}"/>"" width="100" height="60"/> --%>

	
</body>
</html>