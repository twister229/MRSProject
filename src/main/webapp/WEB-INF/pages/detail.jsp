<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	  <meta name="decorator" content="detail" />
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>${food.foodName }</title>

    <!-- Bootstrap -->
    <link href='<c:url value="/resources/user_page/css/bootstrap.min.css"></c:url>' rel="stylesheet">
    <link href='<c:url value="/resources/user_page/css/bootstrap-theme.min.css"></c:url>' rel="stylesheet">
    <link href="<c:url value="/resources/user_page/css/font-awesome.min.css"></c:url>" rel="stylesheet">
    <link type="text/css" href="<c:url value="/resources/user_page/css/detailstyle.css"></c:url>" rel="stylesheet" >
    <link type="text/css" href="<c:url value="/resources/user_page/css/initload.css"></c:url>" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    
    <header id="home">
    <nav class="navbar navbar-inverse navbar-fixed-top nav-pattern" role="navigation">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/iCook">
             <img class="img-responsive" src="<c:url value="/resources/user_page/images/whatcook.png"></c:url>" alt="logo" width="90%">
          </a>          
        </div>
      
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav navbar-right">
              <li class="active"><a href="#home">Đầu Trang</a></li>
              <li><a href="/iCook/Admin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div>
    </nav>  
    <div class="background" style="background:url('<c:url value="/resources/user_page/images/searchbg4.jpg"></c:url>');">
	    <div class="pattrn" >
	      <div class="container container-detail">
	      <div class="row">
	       <div class="col-md-4 scroll">
	        	<div class =" style-thumbnail line-shadow">
		          	<a href="#" class="thumbnail">
		            	<img src="${food.linkImage}" alt="">
		          	</a>
	        	</div>
	        </div>
	       <div class="col-md-7  style-box description ">
	       		<input id="currentFood" type="hidden" value="${food.foodId}"/>
	          <h1>${food.foodName }</h1>
	          <p>
	            ${food.description }
	          </p>
	        </div>
	        <div class="col-md-7  style-box material ">
	          <h3>Nguyên liệu</h3>
	          <p>
	            ${foodDetail.materialDetail }
	          </p>
	        </div>
	        </div>
	        <div class="row">
	        <div id="otherFood" class="col-md-3 style-box">
	        <h2>Món ăn khác</h2>
	        </div>
	        <div class="col-md-8 col-md-offset-1 style-box tutorial ">
	          <h3>Hướng dẫn làm</h3>
	          <p>
	            ${foodDetail.tutorial }
	          </p>
	          
		      <div class="col-md-4 col-md-offset-8">
		      	<p style="font-weight: 700;">Nguồn: http://sotaynauan.com/</p>
		      </div>
	        </div>
	        </div>
	      </div>
	    </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="/resources/user_page/js/bootstrap.js"></c:url>"></script>
    <script src="<c:url value="/resources/user_page/js/otherFood.js"></c:url>"></script>
    <script src="<c:url value="/resources/user_page/js/scroll.js"></c:url>"></script>
    <script src="<c:url value="/resources/user_page/js/initload.js"></c:url>"></script>
  </body>
</html>