<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>

<html class="no-js">
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
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="/resources/js/assets/modernizr-2.8.3.min.js" type="text/javascript"></script>
</head>

<body>
<!-- header -->
<header id="header" class="header">
  <div class="container-fluid">
    <hgroup> 
      <!-- nav -->
		<jsp:include page="../inc/nav.jsp"/> <!-- 위로 넘어가서 view랑 같은 라인 이므로 ..을 사용함 -->
      <!-- nav --> 
    </hgroup>
  </div>
</header>

<!-- header -->

<main class="main-wrapper" id="container"> 
  <!-- image Gallery -->
  <div class="wrapper">
    <div class="">
      <ul class="small-block-grid-2 medium-block-grid-3 large-block-grid-5 masonry">
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/01.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/02.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/03.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/04.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/05.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/06.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/07.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/08.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/09.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/10.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/11.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/12.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/13.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/14.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/16.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
        <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/17.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
         <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/18.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
         <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/19.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
         <li class="masonry-item grid">
          <figure class="effect-sarah"> <img src="/resources/images/gallery/20.jpg" alt="" />
            <figcaption>
              <h2>Photo <span>Title</span></h2>
              <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
              <a href="details.html">View more</a> </figcaption>
          </figure>
        </li>
      </ul>
    </div>
  </div>
</main>

<!-- Image Gallery --> 

<jsp:include page="../inc/footter.jsp"></jsp:include>

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
</body>

</html>
