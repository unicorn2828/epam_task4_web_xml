<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<title>BeerFest</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div class="wrapper d-flex align-items-stretch">
		<nav id="sidebar">
			<div class="custom-menu">
				<button type="button" id="sidebarCollapse" class="btn btn-primary">
				</button>
			</div>
			<div class="img bg-wrap text-center py-4"
				style="background-image: url(images/beer-2.jpg);">
				<div class="user-logo">
					<div class="img"
						style="background-image: url(images/Untitled.jpg);"></div>
					<h3>Vitaly Kononov</h3>
				</div>
			</div>
			<ul class="list-unstyled components mb-5">
				<li class="active"><a href="#"><span
						class="fa fa-home mr-3"></span> Home</a></li>
				<li><a href="#"><span class="fa fa-download mr-3 notif"><small
							class="d-flex align-items-center justify-content-center">5</small></span>
						Download</a></li>
				<li><a href="#"><span class="fa fa-gift mr-3"></span> Gift
						Code</a></li>
				<li><a href="#"><span class="fa fa-trophy mr-3"></span> Top
						Review</a></li>
				<li><a href="#"><span class="fa fa-cog mr-3"></span>
						Settings</a></li>
				<li><a href="#"><span class="fa fa-support mr-3"></span>
						Support</a></li>
				<li><a href="#"><span class="fa fa-sign-out mr-3"></span>
						Sign Out</a></li>
			</ul>

		</nav>

		<!-- Page Content  -->
		<div id="content" class="p-4 p-md-5 pt-5">
			<h2 class="mb-4">BeerFest</h2>
			<p>Пиво - наше всё! Пивной фестиваль на автозаводе - заводит!
				Заведи свой автозавод!</p>
			<p>Beer is one of the oldest and most widely consumed alcoholic
				drinks in the world. It is also the third most popular drink overall
				after water and tea.</p>
			<p>It is considered that overeating and lack of muscle tone is
				the main cause of a beer belly, rather than beer consumption. It is
				more a problem of improper exercise and overconsumption of
				carbohydrates than the product itself. Several diet books quote beer
				as having an undesirably high glycemic index of 110, the same as
				maltose; however, the maltose in beer undergoes metabolism by yeast
				during fermentation so that beer consists mostly of water, hop oils
				and only trace amounts of sugars, including maltose.</p>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>