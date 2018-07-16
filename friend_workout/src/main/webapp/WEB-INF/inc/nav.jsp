<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-121715522-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'UA-121715522-1');
</script><!-- 구글 애널리스틱스 사용하기 위해 추가함 -->
<c:choose>
	<c:when test="${login != null}">
	<h4 class="display-3" align="Left"><strong style="color: navy; font-size: 1.5em;">오늘은 운동 하셨나요 ? ${login.u_name}님 :D </strong></h4>
	</c:when>
</c:choose>
<!-- logo -->
<nav>
<ul class="nav nav-tabs">
	<li role="presentation" class="active"><a href="/">Home</a></li>
	<li><a href="#" data-toggle="modal" data-target="#upload-modal">
			upload<!-- End of ca-content-->
	</a></li>
	<!-- Add New Iteration -->
	<li role="presentation"><a href="/info">About</a></li>
	<li role="presentation"><a href="/users">register</a></li>
	<c:choose>
		<c:when test="${login != null}">
		<li role="presentation"><a href="/users/sessionout">logout</a></li>
		</c:when>
		<c:when test="${login == null}">
		<li role="presentation"><a href="/users/session">login</a></li>
		</c:when>
	</c:choose>
	<li role="presentation"><a href="/mail">contact</a></li>
	<li role="presentation"><a href="/bbs">Board</a></li>
	<li role="presentation"><a href="/games">Mini-game</a></li>
</ul>
</nav>
