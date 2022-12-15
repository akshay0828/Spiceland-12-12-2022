<!doctype html>
<%@page import="java.sql.*"%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
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
	
<title>Add Products</title>

<style>
body {
	    background-image: url('https://cdn.wallpapersafari.com/14/13/SmgTFb.jpg'); 
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
}

.container {
	background-image:
		url('https://cropper.watch.aetnd.com/cdn.watch.aetnd.com/sites/3/2018/01/watch-desktop-hero-man-vs-master-chef-battle.jpg?w=1440');
	
	background-position: center;
	background-repeat: no-repeat;
	background-size: fixed;
}

.button-55 {
	background-color: #0078d0;
	border: 0;
	border-radius: 56px;
	color: #fff;
	cursor: pointer;
	display: inline-block;
	font-family: system-ui, -apple-system, system-ui, "Segoe UI", Roboto,
		Ubuntu, "Helvetica Neue", sans-serif;
	font-size: 18px;
	font-weight: 600;
	outline: 0;
	padding: 16px 21px;
	position: relative;
	text-align: center;
	text-decoration: none;
	transition: all .3s;
	user-select: none;
	-webkit-user-select: none;
	touch-action: manipulation;
}

.button-55:before {
	background-color: initial;
	background-image: linear-gradient(#fff 0, rgba(255, 255, 255, 0) 100%);
	border-radius: 125px;
	content: "";
	height: 50%;
	left: 4%;
	opacity: .5;
	position: absolute;
	top: 0;
	transition: all .3s;
	width: 92%;
}

.button-55:hover {
	box-shadow: rgba(255, 255, 255, .2) 0 3px 15px inset, rgba(0, 0, 0, .1)
		0 3px 5px, rgba(0, 0, 0, .1) 0 10px 13px;
	transform: scale(1.05);
}

@media ( min-width : 768px) {
	.button-55 {
		padding: 16px 48px;
	}
}
</style>
<script src="/js/main.js"></script>
</head>
<body>

	<div class="c1">
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
					<ul class="navbar-nav mr-auto"></ul>
					<ul class="navbar-nav">
						<li class="nav-item active"><a class="nav-link"
							href="/admin/adminhome/${user.id}">Home Page</a></li>
					</ul>
				</div>
			</div>
		</nav>
		
		
		<div class="container">
			<div>
				<form action="/admin/products/${user.id}" method="post" enctype = "multipart/form-data" class="add-products-form" onsubmit="return Upload()">
					<!--  <div class="row">-->
					<br> <br>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="productName" style="color: white;" hidden="hidden">User_id</label>
							<input 
						id="user_id" name="user_id" value="${user.id}" type="hidden" />
						</div>
					</div>
					<h3 style="color: white;">Add a new Product</h3>
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="productName" style="color: white;">ProductName</label>
							<input type="text" class="form-control border border-warning"
								required name="productName" min="1" placeholder="ProductName">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="price" style="color: white;">Price</label> <input
								type="number" class="form-control border border-warning"
								required name="price" min="1" placeholder="Price">
						</div>
					</div>
					<br> 
					<div class="col-sm-3">
						<div class="form-group">
							<label for="weight" style="color: white;">Weight in grams</label>
							<input type="number" class="form-control border border-warning"
								required name="weight" min="1" placeholder="Weight">
						</div>
					</div>
					<br>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="weight" style="color: white;">Available
								Quantity</label> <input type="number"
								class="form-control border border-warning" required
								name="quantity" min="1" placeholder="Quantity">
						</div>
					</div>
					

					<div class="col-sm-5">
						<br>
						<div class="form-group">
							<label for="description" style="color: white;">Product
								Description</label>
							<textarea class="form-control border border-warning" rows="2"
								name="productDescription" placeholder="Product Details"
								value="no product details"></textarea>
							<!--  <input class="form-control border border-warning" type="text" name="productDescription" placeholder="Product Details" ></input>-->

						</div>
						
						 <p style="color: white;">Product Image</p>
                <div class="custom-file">
                    <input type="file" class="custom-file-input" name="eimage" required accept="image/jpeg, image/png" id="productImage" data-max-size="2048" onchange="loadfile(event)"   /> 
                    <label class="custom-file-label border border-warning" for="productImage">Choose file</label>
                    
                 </div>
                  <center style="color: white;"> ${me}</center>
						<br><br>
						 <input type="submit" class="button-55" name="submit"> <br>
						<br><br><br>
					</div>
			</div>

			</form>
		</div>
	</div>
	</div>



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
	
<script type="text/javascript">



   var Upload = function() {
        var fileUpload = document.getElementById("productImage");
        var maxSize = fileUpload.getAttribute('data-max-size');
        
        var maxSize1 = parseFloat(maxSize);
        
/*          console.log(typeof maxSize);
         console.log(typeof maxSize1) */
         
         
        
        if (typeof (fileUpload.files) != "undefined") {
            var size = parseFloat(fileUpload.files[0].size / 1024).toFixed(2);
            var size1 = parseFloat(size);
        /*     console.log(maxSize);
            console.log(size); */
            /* console.log(typeof size1); */
            if(size1 > maxSize1){
                
                alert("Image Size is greater than 2MB  " +size + "  KB "+"  Product is not added" );
                
                return false;
            }
            
            alert("Product is added");
        } else {
            alert("This browser does not support HTML5.");
        }
    }
    




</script>

</body>
</html>