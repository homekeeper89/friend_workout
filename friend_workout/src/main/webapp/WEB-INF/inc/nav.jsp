<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- logo -->
<!-- <h1>
	<a href="/" title="Working with Friend"><img src="/resources/images/logo.png" alt="Picxa" title="Picxa" /></a>
</h1> -->
<c:choose>
	<c:when test="${login != null}">
	<h5>Welcome ${login.u_name}</h5>
	</c:when>
</c:choose>
<!-- logo -->
<nav>
 <ul class="nav nav-tabs">
     <li role="presentation" class="active"><a href="/">Home</a></li>
     <li>
      <a href="#" data-toggle="modal" data-target="#upload-modal">
        upload<!-- End of ca-content-->
    </a>
</li> <!-- Add New Iteration -->
  <li role="presentation"><a href="/info">About</a></li>
  <li role="presentation"><a href="/users">register</a></li>
    <li role="presentation"><a href="/users/session">login</a></li>
     <li role="presentation"><a href="/#">contact</a></li>
</ul>
      </nav>
