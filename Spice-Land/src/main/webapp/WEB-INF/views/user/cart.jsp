<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Products</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/cart.css" />

</head>
<body class="body">
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
					href="/user/userhome/${user.id}">Home Page</a></li>

			</ul>

			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="/user/userhome/${user.id}">Back to Menu</a></li>

			</ul>

		</div>
	</div>
	</nav>
	<br>
	<style>
.cart {
	width: 800px;
	color: #FF3838;
	font-size: 30px;
	height: 700px;
	padding: 50px;
	/* width: 100px;  
height: 45%;  */
	position: fixed;
	left: 1000px;
	bottom: 150px;
	margin-bottom: 50px;
	margin-top: 300px;
	margin-right: 370px;
}

.total {
	color: #3c4043;
	font-size: 20px;
}
</style>

	<div id="cart" class="cart">

		<div id="total">


			<h2 align="center">List of Products</h2>
			<h2 align="center">${error }</h2>
			<table align="center">
				<thead>
					<tr>

						<td style="text-align: center">Product Name</td>
						<td>Price</td>
						<td>Quantity</td>

						<td colspan="2">Actions</td>

					</tr>
				</thead>
				<tbody>
					<script>
		var tot=0;
		</script>
					<c:forEach items="${cartLine}" var="cart">
						<tr>

							<td>${cart.productName}</td>
							<td>${cart.price}</td>

							<td>${cart.quantity}</td>



							<!-- To calculate total price (total price = quantity of items in cart and item price   -->
							<script>
					
					
					 tot+=${cart.quantity} * ${cart.price};
					var concatElement = document.getElementById("total");
					
				
					//alert(total);
					
					</script>


							<td><a href="/user/userhome/${user.id}/${product.id}"><input
									type="submit" name="Update" value="Add more" class="button-17"></a></td>

							<!-- <td><a href="/products/prolist/${user.id}"><input type="submit"  name="Delete" value="Delete"></a></td> -->
							<td>
								<form action="/user/cart/${cart.id}/${user.id}" method="post">


									<input type="submit" value="Remove" id="Delete" name="Delete"
										class="button-17">

								</form>

							</td>






						</tr>

					</c:forEach>





				</tbody>
			</table>

			Total:
			<script>
			 concatElement.innerHTML += " " + tot;
			</script>


		</div>
		<a href="/user/payment/${user.id}"><input type="submit"
			name="Update" value="Payment & Checkout" class="button-17"></a>
	</div>

</body>
</html>
</html>