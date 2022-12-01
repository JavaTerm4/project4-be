<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<title>Hotels</title>

	<link
			href="css/css.css"
			rel="stylesheet">

	<!-- Template CSS -->
	<link rel="stylesheet"
		  href="css/style-starter.css">

	<link rel="stylesheet"
		  href="css/style-liberty.css">
	<script
			src="https://code.jquery.com/jquery-3.5.1.js"
			integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
			crossorigin="anonymous"></script>
</head>
<body>
<!--w3l-header-->

<header class="w3l-header-nav">
	<!--/nav-->
	<nav
			class="navbar navbar-expand-lg navbar-light fill px-lg-0 py-0 px-3">
		<div class="container">
			<a class="navbar-brand"
			   href="${pageContext.request.contextPath }/home"> <img
					src="images/hotels.png"
					alt="Your logo" style="height: 35px;" /> HOMIE HOTEL
			</a>
			<!-- if logo is image enable this
                    <a class="navbar-brand" href="#index.html">
                        <img src="image-path" alt="Your logo" title="Your logo" style="height:35px;" />
                    </a> -->
			<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
												   href="${pageContext.request.contextPath }/home">Home</a></li>
					<li class="nav-item @@about__active"><a class="nav-link"
															href="about">About</a>
					</li>
					<li class="nav-item @@services__active"><a class="nav-link"
															   href="service">Services</a>
					</li>

					<li class="nav-item dropdown @@room__active"><a
							class="nav-link"
							href="listroom">Rooms</a>
					</li>
					<li class="nav-item dropdown @@blog__active"><a
							class="nav-link"
							href="blog">Blog</a>
					</li>
					<li class="nav-item @@contact__active"><a class="nav-link"
															  href="contact">Contact</a>
					</li>

				<%
					if(session.getAttribute("khach") != null){
				%>
					<li class="dropdown user user-menu" style="margin-right: 35px;">
						<a href="#" class="dropdown-toggle customUser" style="color: #f57b51; font-weight: bold; font-size: 16px"
						   data-toggle="dropdown" aria-expanded="false"> <img
								src="hinh/iconuser.png" width="30px" height="30px" /> <span
								class="hidden-xs">Welcome ${nguoidung }</span>
						</a>

						<ul class="dropdown-menu">

							<li class="user-body" style="color: #0275d8; font-size: 15px;">
								<div class="mt-2" style="text-align: center;">
									<a class="hoverUser" style="color: #0275d8;" href="${nguoidung}">Profile</a>
								</div>
								<div class="mt-2" style="text-align: center;">
									<a class="hoverUser" style="color: #0275d8;" href="doimatkhau">Change Password</a>
								</div>

								<div class="mt-2" style="text-align: center;">
									<a class="hoverUser" style="color: #0275d8;" href="dangxuat">Log-Out</a>
								</div>
							</li>
						</ul>
					</li>

				</ul>
				<% } else { %>
				</ul>
					<a href='login' class='ml-3 book btn btn-secondary btn-style'>Login</a>
					<a href='register' class='ml-3 book btn btn-info btn-style'>Register</a>
				<% }  %>

			</div>
		</div>
	</nav>
	<!--//nav-->
</header>
<!-- //w3l-header -->
<!-- main-slider -->

<tiles:insertAttribute name="content"></tiles:insertAttribute>

<section class="w3l-footer-29-main">
	<div class="footer-29 py-5">
		<div class="container py-lg-4">
			<div class="row footer-top-29">
				<div class="col-lg-3 col-md-6 col-sm-8 footer-list-29 footer-1">
					<h6 class="footer-title-29">Contact Us</h6>
					<ul>
						<li>
							<p>
								<span class="fa fa-map-marker"></span> 590 Cach Mang Thang 8, Ward 11, District 3, Ho Chi Minh City.
							</p>
						</li>
						<li><a href="tel:+84 905187775"><span
								class="fa fa-phone"></span> +84 123 456 789</a></li>
						<li><a href="mailto:hotel@fpt.edu.vn" class="mail"><span
								class="fa fa-envelope-open-o"></span>BambuuHotel@fpt.edu.vn</a></li>
					</ul>
				</div>
				<div
						class="col-lg-2 col-md-6 col-sm-4 footer-list-29 footer-2 mt-sm-0 mt-5">

					<ul>
						<h6 class="footer-title-29">Useful Links</h6>
						<li><a href="${pageContext.request.contextPath }/home">Home</a></li>
						<li><a href="about">About Us</a></li>
						<li><a href="blog"> Blog posts</a></li>
						<li><a href="contact">Contact us</a></li>
					</ul>
				</div>
				<div
						class="col-lg-3 col-md-6 col-sm-5 footer-list-29 footer-3 mt-lg-0 mt-5">
					<h6 class="footer-title-29">Latest blog</h6>
					<div class="footer-post mb-4">
						<a href="blog-single">Work Passionately</a>
						<p class="small">
							<span class="fa fa-clock-o"></span> April 10, 2022
						</p>
					</div>
					<div class="footer-post">
						<a href="blog-single">Work Passionately without any hesitation</a>
						<p class="small">
							<span class="fa fa-clock-o"></span> April 10, 2022
						</p>
					</div>

				</div>
				<div
						class="col-lg-3 col-md-6 col-sm-5 footer-list-29 footer-3 mt-lg-0 mt-5">
					<h6 class="footer-title-29">Bank</h6>
					<div class="footer-post mb-4">
						<p class="small">Bank <strong>SACOMBANK</strong> HO CHI MINH Branch</p>
						<p class="small">Holder: HOANG HUU NGHIA</p>
						<p class="small">Account Number: 0123456789123</p>
					</div>
					<div class="footer-post">
						<p class="small">Bank <strong>SACOMBANK</strong> HO CHI MINH Branch</p>
						<p class="small">Holder: HOANG HUU NGHIA</p>
						<p class="small">Account Number: 0123456789123</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>



<!-- Template JavaScript -->
<script src="js/jquery-3.3.1.min.js"></script>

<script src="js/owl.carousel.js"></script>
<!-- script for banner slider-->
<script>
	$(document).ready(function() {
		$('.owl-one').owlCarousel({
			loop : true,
			margin : 0,
			nav : false,
			responsiveClass : true,
			autoplay : false,
			autoplayTimeout : 5000,
			autoplaySpeed : 1000,
			autoplayHoverPause : false,
			responsive : {
				0 : {
					items : 1,
					nav : false
				},
				480 : {
					items : 1,
					nav : false
				},
				667 : {
					items : 1,
					nav : true
				},
				1000 : {
					items : 1,
					nav : true
				}
			}
		})
	})
</script>
<!-- //script -->

<!-- script for owlcarousel -->
<script>
	$(document).ready(function() {
		$('.owl-testimonial').owlCarousel({
			loop : true,
			margin : 0,
			nav : true,
			responsiveClass : true,
			autoplay : false,
			autoplayTimeout : 5000,
			autoplaySpeed : 1000,
			autoplayHoverPause : false,
			responsive : {
				0 : {
					items : 1,
					nav : false
				},
				480 : {
					items : 1,
					nav : false
				},
				667 : {
					items : 1,
					nav : true
				},
				1000 : {
					items : 1,
					nav : true
				}
			}
		})
	})
</script>
<!-- //script for owlcarousel -->
<script
		src="js/jquery.magnific-popup.min.js"></script>
<script>
	$(document).ready(function() {
		$('.popup-with-zoom-anim').magnificPopup({
			type : 'inline',

			fixedContentPos : false,
			fixedBgPos : true,

			overflowY : 'auto',

			closeBtnInside : true,
			preloader : false,

			midClick : true,
			removalDelay : 300,
			mainClass : 'my-mfp-zoom-in'
		});

		$('.popup-with-move-anim').magnificPopup({
			type : 'inline',

			fixedContentPos : false,
			fixedBgPos : true,

			overflowY : 'auto',

			closeBtnInside : true,
			preloader : false,

			midClick : true,
			removalDelay : 300,
			mainClass : 'my-mfp-slide-bottom'
		});
	});
</script>


<!-- disable body scroll which navbar is in active -->
<script>
	$(function() {
		$('.navbar-toggler').click(function() {
			$('body').toggleClass('noscroll');
		})
	});
</script>
<!-- disable body scroll which navbar is in active -->

<script
		src="js/bootstrap.min.js"></script>

</body>

</html>
