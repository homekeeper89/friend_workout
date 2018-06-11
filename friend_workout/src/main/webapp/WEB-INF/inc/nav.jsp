<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- logo -->
<h1>
	<a href="/" title="Working with Friend"><img src="/resources/images/logo.png" alt="Picxa" title="Picxa" /></a>
</h1>
<c:choose>
	<c:when test="${login != null}">
	<h5>Welcome ${login.u_name}</h5>
	</c:when>
</c:choose>
<!-- logo -->
<nav>
<div class="menu-expanded">
	<div class="nav-icon">
		<div id="menu" class="menu"></div>
		<p>menu</p>
	</div>
	<div class="cross">
		<span class="linee linea1"></span> <span class="linee linea2"></span>
		<span class="linee linea3"></span>
	</div>
	<div class="main-menu">
		<ul>
			<li class="active"><a href="index.html">Home</a></li>
			<li><a href="about.html">About</a></li>
			<li><a href="/users">register</a></li>
			<li><a href="/users/session">login</a></li>
			<li><a href="/files">test</a></li>
			<li><a href="contact.html">contact</a></li>
		</ul>
	</div>
</div>
</nav>
