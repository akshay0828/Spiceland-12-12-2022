<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>
<title>Document</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Titillium+Web:wght@200;300&display=swap')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Arimo&display=swap');

@import
	url('https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@300&display=swap')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Signika:wght@300&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Titillium Web', sans-serif;
}

/* html,
        body {
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            height: 100%;
            width: 100%;

            font-family: 'Roboto', sans-serif;
            font-weight: 400;
        } */
::selection {
	color: white;
	background: black;
	font-weight: 700;
}

.wrapper {
	display: table;
	height: 100%;
	width: 100%;
}

.container-fostrap {
	display: table-cell;
	padding: 1em;
	text-align: center;
	vertical-align: middle;
}

h1.heading {
	color: #fff;
	font-size: 1.15em;
	font-weight: 900;
	margin: 0 0 0.5em;
	color: #505050;
	text-shadow: 0px 4px 3px rgba(0, 0, 0, 0.4), 0px 8px 13px
		rgba(0, 0, 0, 0.1), 0px 18px 23px rgba(0, 0, 0, 0.1);
}

@media ( min-width : 450px) {
	h1.heading {
		font-size: 3.55em;
	}
}

@media ( min-width : 760px) {
	h1.heading {
		font-size: 3.05em;
	}
}

@media ( min-width : 900px) {
	h1.heading {
		font-size: 3.25em;
		margin: 0 0 0.3em;
	}
}

.card {
	display: block;
	width: auto;
	margin: 20px;
	line-height: 1.42857143;
	background-color: #fff;
	border-radius: 2px;
	min-width: 15rem;
	min-height: 100px;
	overflow: hidden;
	transition: 0.5s ease;
	animation: start_animation 0.5s ease 1;
	box-shadow: rgba(0, 0, 0, 0.09) 0px 2px 1px, rgba(0, 0, 0, 0.09) 0px 4px
		2px, rgba(0, 0, 0, 0.09) 0px 8px 4px, rgba(0, 0, 0, 0.09) 0px 16px 8px,
		rgba(0, 0, 0, 0.09) 0px 32px 16px;
}

.cfont {
	font-family: 'Arimo', sans-serif;
}

.card:hover {
	box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px
		6px;
}

.img-card {
	width: 80%;
	height: 225px;
	min-width: 14rem;
	border-top-left-radius: 2px;
	border-top-right-radius: 2px;
	display: flex;
	overflow: hidden;
}

.img-card img {
	margin-top: 15px;
	width: fit-content;
	height: 200px;
	object-fit: cover;
	transition: all .25s ease;
	filter: drop-shadow(0.35rem 0.35rem 0.4rem rgba(0, 0, 0, 0.5));
}

.card-content {
	padding: 15px;
	text-align: left;
}

.card-content p {
	font-family: 'M PLUS Rounded 1c', sans-serif;
}

.card-title {
	font-family: 'Signika', sans-serif;
	margin-top: 0px;
	font-weight: 600;
	font-size: 1.65em;
}

.card-title a {
	color: #000;
	text-decoration: none !important;
}

.card-read-more {
	border-top: 1px solid #D4D4D4;
}

.card-read-more a {
	text-decoration: none !important;
	padding: 10px;
	font-weight: 600;
	text-transform: uppercase
}

.navbar {
	background-color: black;
	opacity: 0.9;
	z-index: 999;
	width: 100%;
}

.navbar::before {
	content: "";
	position: absolute;
	top: 0%;
	bottom: 0%;
	left: 0;
	right: 0;
	z-index: -1;
}

.nav-item a {
	color: white;
	font-weight: 500;
	font-size: 17px;
	transition: 0.5s ease;
}

.nav-item a:hover {
	color: rgb(0, 195, 255);
	font-weight: bold;
	transition: 0.5s ease-in-out;
}

.navbar-brand {
	color: white;
	font-weight: 600;
	font-size: 20px;
}

.nav-item {
	margin-right: 20px;
}

:root { -
	-cr1: #F36E45; -
	-cr2: #fff; -
	-cr3: #000000da; -
	-cr4: #000000a1; -
	-cr5: #BEB4B1; -
	-fs1: 34px; -
	-fs2: 24px; -
	-fs3: 20px; -
	-fs4: 16px; -
	-fs5: 14px;
}
/* body {
  background: #e5e5e5;
} */
/* the same attribute */
.cr1 {
	color: var(- -cr1);
}

.c2 {
	color: var(- -cr2);
}

.cr3 {
	color: var(- -cr3);
}

.cr4 {
	color: var(- -cr4);
}

.cr5 {
	color: var(- -cr5);
}

.fs1 {
	font-size: 34px;
}

.fs2 {
	font-size: 24px;
}

.fs3 {
	font-size: 20px;
}

.fs4 {
	font-size: 16px;
}

.fs5 {
	font-size: 14px;
}
/* end the same attribute */
@font-face {
	src: url(ProductSansRegular_0.ttf);
	font-family: product;
}

* {
	padding: 0px;
	margin: 0px;
	box-sizing: border-box;
	font-family: segoe ui
}
/* body,html{width:100%;height:100%;} */
[class*="container"] {
	max-width: 1170px !important;
}

.bg-product {
	/* SET Height cho nó rồi bảo sao ko lỗi? */
	/*height: 446px;*/
	background: #d1d7f5;
	/* overflow: hidden; */
}

#sliderproduct {
	width: 100%;
}

#sliderproduct .carousel-inner {
	overflow: visible;
}

#sliderproduct .col-sm-6.image {
	background: #fff;
	box-shadow: 0px 4px 8px 0px #959595;
	position: relative;
	/* Thêm cái của nợ này vào bảo sao nó ko tràn bờ đê */
	/*top: -44px;
  padding: 100px;
  padding-top: 40px;*/
}

.item {
	padding: 20px 20px 40px 20px;
}

.col-sm-6.image .item img.img-fluid {
	/* Ai mướn thêm cái vào làm phá bố cục css của người ta.. mún trang web đẹp thì phải lựa cái ảnh đẹp đẹp vào rồi set cái độ rộng cho nó vừa là được rồi */
	/*min-width: 100%;*/
	width: 315px;
}

.col-sm-6.image h1 {
	margin-bottom: 20px;
}

.bg {
	height: 400px;
	overflow: hidden;
}

.footer {
	position: fixed;
	bottom: 0;
	padding: 15px;
	width: 100%;
	text-align: center;
	background-color: #292929;
	color: #fff;
	font-family: sans-serif;
	font-size: 14px;
}

.footer img {
	width: 26px;
	position: relative;
	top: 0px;
	left: -3px;
}

.footer a {
	color: #fff;
	font-weight: bold;
	text-decoration: none;
}

body {
	background-image:
		url('https://img.freepik.com/free-photo/shopping-cart-black-background-with-copy-space_23-2148317906.jpg?w=1380&t=st=1669885183~exp=1669885783~hmac=b0e3baf5c59c492592e01c647b2037f01c692653a176f6a8ad408e6e366c3d91');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
}

.modal {
	position: fixed;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	background-color: #cccccc;
	opacity: 0;
	visibility: hidden;
	transform: scale(1.1);
	transition: visibility 0s linear 0.25s, opacity 0.25s 0s, transform
		0.25s;
}

.modal-content {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: #eeeeee;
	padding: 1rem 1.5rem;
	width: 24rem;
	border-radius: 0.5rem;
}

.close-button {
	float: right;
	width: 1rem;
	line-height: 1.5rem;
	text-align: center;
	cursor: pointer;
	border-radius: 30px;
	background-color: #eeeeee;
}

.close-button:hover {
	background-color: #adadad;
}

.show-modal {
	opacity: 1;
	visibility: visible;
	transform: scale(1.0);
	transition: visibility 0s linear 0s, opacity 0.25s 0s, transform 0.25s;
}
</style>

<style type="text/css">
.modalDialog {
	position: fixed;
	font-family: Arial, Helvetica, sans-serif;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	background: rgba(0, 0, 0, 0.1);
	z-index: 99999;
	opacity: 0;
	-webkit-transition: opacity 400ms ease-in;
	-moz-transition: opacity 400ms ease-in;
	transition: opacity 400ms ease-in;
	pointer-events: none;
}

.modalDialog:target {
	opacity: 1;
	pointer-events: auto;
}

.modalDialog>div {
	width: 900px;
	position: relative;
	margin: 10% auto;
	padding: 5px 20px 13px 20px;
	border-radius: 10px;
	background: -moz-linear-gradient(#2edbe8, #01a6b2);
	background: -webkit-linear-gradient(#2edbe8, #01a6b2);
	background: -o-linear-gradient(#2edbe8, #01a6b2);
}

.close {
	background: #606061;
	color: #FFFFFF;
	line-height: 25px;
	position: absolute;
	right: -12px;
	text-align: center;
	top: -10px;
	width: 50px;
	text-decoration: none;
	font-weight: bold;
	-webkit-border-radius: 12px;
	-moz-border-radius: 12px;
	border-radius: 12px;
	-moz-box-shadow: 1px 1px 3px #000;
	-webkit-box-shadow: 1px 1px 3px #000;
	box-shadow: 1px 1px 3px #000;
}

.close:hover {
	background: #6ed1d8;
}

.cart {
	/*  width: 100px;  
height: 45%; 
 position: fixed;
  left: 1100px;
  bottom: 350px;
  margin-bottom: 50px;
  margin-top: 300px;
  margin-right: 370px; */
	top: 10%;
	position: fixed;
	left: 1150px;
	bottom: 350px;
	display: block;
	width: 120%;
	height: 80%;
	margin: 20px;
	line-height: 20;
	background-color: #fff;
	border-radius: 2px;
	min-width: 15rem;
	min-height: 100px;
	overflow: hidden;
	transition: 0.5s ease;
	animation: start_animation 0.5s ease 1;
	box-shadow: rgba(0, 0, 0, 0.09) 0px 2px 1px, rgba(0, 0, 0, 0.09) 0px 4px
		2px, rgba(0, 0, 0, 0.09) 0px 8px 4px, rgba(0, 0, 0, 0.09) 0px 16px 8px,
		rgba(0, 0, 0, 0.09) 0px 32px 16px;
}

/* website background image designing */
#container1 {
	position: relative;
	display: flex;
	flex-direction: column;
	align-items: center;
	width: 100vw;
	height: 63vh;
}

/*Setting the background image using before pseudo selector*/
#container1::before {
	content: '';
	 background-image: url('https://images.askmen.com/news/sports/_1516983344.gif') ;
		 background-size: cover;
		background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center center;
	width: 99vw;
	height: 59vh;
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: 'Ubuntu Mono', monospace;
	margin-right: 45px;
	font-weight: bold;
	z-index: -1;
	opacity: 1;
	border: 2px solid black;
	/* border-bottom-left-radius: 100px; */
}

#row1 {
	/*  text-align: center;
        display: flex;
        justify-content: center;
        align-items: center;
        
          position:absolute; */
	bottom: 700px;
	font-size: 160px;
	font-family: Brush Script MT;
	color: white;
	text-shadow: 0 0 4px black;
}

#welcome {
	/*  text-align: center;
        display: flex;
        justify-content: center;
        align-items: center;
        
          position:absolute; */
	bottom: 700px;
	font-size: 30px;
	font-family: Arial;
	color: white;
	text-shadow: 0 0 4px black;
}
</style>

</head>
<body>

	<form>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"> <img
					th:src="@{/images/logo.png}" src="../static/images/logo.png"
					width="auto" height="40" class="d-inline-block align-top" alt="" />
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<h4 id="welcome">Welcome ${add }</h4>
					<ul class="navbar-nav mr-auto"></ul>
					<ul class="navbar-nav">
					
					
					<form action="user/userhome/${user }" method="GET">
      <input type="text" name="text"  class="search" placeholder="Search here!" >
      <input type="submit" name="submit" class="submit"  value="Search">
    </form>
				
					
						<li class="nav-item active"><a class="nav-link"
							th:href="@{/}" href="#">Home</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="/user/updateprofile/${user}">Profile</a></li>

						<li class="nav-item active"><a class="nav-link"
							href="/user/orderTracking/${user}">Order Tracking</a></li>
						<li class="nav-item active"><a class="nav-link"
							sec:authorize="isAuthenticated()" href="/logout">Logout</a></li>

					</ul>

				</div>
			</div>
		</nav>




		<div id="container1">
			<div id="row1">
				<br> Welcome to Spice Land 
				

			</div>
		</div>
		<hr>

<div style="color: red;" align="center">
						<h3>${pempty}</h3>
						</div>
					
		<form>
		
			<center>

				<div class="container-fostrap" onload="click()">
					<div class="row">
				<div style="color: red;" align="center">
							<h3>${error}</h3>
						</div>
						<c:forEach items="${Products}" var="product">

							<div class="col-xs-12 col-sm-6 col-md-6 col-lg-4"
								data-aos="zoom-in-down">
								<div class="card">

									<div class="card-content">
										<p id="productName" name="productName">
										<h4 class="card-title">${product.productName}</h4>

										</p>

										<p id="price" name="price">
											Price of the product ${product.price}<br>
										</p>
										<p id="weight" name="weight">
											weight of the product ${product.weight}<br>
										</p>
										<p id="quantity" name="quantity">
											Quantity Available ${product.quantity}<br>
										</p>
										<p id="quantity" name="a">Seller Name:-
										${product.user.name}	<br>
										</p>
										<p>
											<!-- <img src="https://th.bing.com/th/id/OIP.RE0burbBLkrbpIPHghxAIQHaD3?pid=ImgDet&rs=1" alt="Girl in a jacket" width="250" height="100"> -->
										<center>
											<img width="200" height="150"
												src="data:image/jpeg;base64,${product.image}">
										</center>
										</p>
									</div>
									<div class="card-read-more">
										<!-- <a href="/user/products" class="btn btn-link btn-block"> Add To Cart </a> -->
										<!-- <a href="#cart" class="btn btn-link btn-block">ADD TO CART</a> -->

										<a href="/user/userhome/${user}/${product.id}">ADD TO CART</a>
										<a href="#openModal" class="btn btn-link btn-block"></a>

									</div>
								</div>
							</div>


						</c:forEach>
					</div>


				</div>
				<div class="cart">

					<a href="/user/cart/${user}"><img
						src="https://www.pngplay.com/wp-content/uploads/1/Online-Shopping-Cart-PNG-Background-Image.png"
						alt="Girl in a jacket" width="200" height="200"></a>
				</div>
			</center>
		</form>



		<style>
.cart {
	width: 220px;
	position: fixed;
	height: 270px;
	padding: 10px; //
	border: 2px solid blue;
	border-radius: 50%;
	top: 69%;
	left: 10px;
	bottom: 350px;
}
</style>
















		</div>




	</form>


	<div></div>




</body>
</html>