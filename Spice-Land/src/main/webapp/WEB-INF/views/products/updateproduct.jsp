<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<title>Update Products</title>
<style>
body {
	background-image:
		url('https://cdn.wallpapersafari.com/14/13/SmgTFb.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
}

.container {
	background-image:
		url('https://www.24mantra.com/wp-content/uploads/2020/11/824x465-155.png');
	'
	background-repeat: no-repeat;
	background-size: cover;
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
</head>
<body>
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
					href="/products/prolist/${product.user}">Back</a></li>


			</ul>

		</div>
	</div>
	</nav>

	<form action="/products/updateproduct/${product.id}" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="id" value="${product.id }" />

		<div class="jumbotron container border border-info">
			<h3 style="color: white;">Update Existing Product</h3>
			<br>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="weight" style="color: white;" hidden="hidden">User_id</label>
					<input type="hidden" class="form-control border border-warning"
						name="userid" value="${product.user}">
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="price" style="color: white;">Product Name</label> <input
						type="text" class="form-control border border-warning"
						name="productName" value="${product.productName}">
				</div>
			</div>

			<div class="col-sm-3">
				<div class="form-group">
					<label for="price" style="color: white;">Price</label> <input
						type="number" class="form-control border border-warning"
						name="price"  min="1" value="${product.price}">
				</div>

			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="weight" style="color: white;">Weight in grams</label> <input
						type="number" class="form-control border border-warning"
						name="weight"  min="1"value="${product.weight}">
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="weight" style="color: white;">Available
						Quantity</label> <input type="number"
						class="form-control border border-warning" name="quantity"
						min="1" value="${product.quantity}">
				</div>


			</div>

			<div class="col-sm-5">
				<br>
				<div class="form-group">
					<label for="description" style="color: white;">Product
						Description</label>
					<!--   <textarea class="form-control border border-warning" rows="4" name="productDescription"  value="${product.quantity}"></textarea>-->
					<input class="form-control border border-warning" type="text"
						name="productDescription" value="${ product.productDescription}"></input>

					<!-- </div>
					<p style = "color:white;">Product Image</p>
                <div class="custom-file">
                    <input type="file" class="custom-file-input" name="eimage" accept="image/jpeg, image/png" id="productImage" onchange="loadfile(event)" /> 
                    
                    <label class="custom-file-label border border-warning" for="productImage">Choose file</label>
                 </div> 
             -->
					<table>
						<tr>
							<td>
								<div>
									<input type="submit" class="button-55" name="submit"
										value="Save" />
							</td>
							</div>
							<!-- <td>
		<input type="submit" class="button-55"  name="submit" value="Cancel" />
		</td> -->
						</tr>
					</table>
				</div>

			</div>
	</form>


	</div>

	</form>
</html>