<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">
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
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

<link rel="stylesheet" href="/css/tracking.css" />
<script type="module" src="./index.js"></script>


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
					href="/user/userhome/${user.id }">Home Page</a></li>

			</ul>

			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="/user/userhome/${user.id }">Back to Menu</a></li>

			</ul>

		</div>
	</div>
	</nav>






	<iframe id="map" class="map"
		src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3506.2233913121413!2d77.4051603706222!3d28.50292593193056!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x390ce626851f7009%3A0x621185133cfd1ad1!2sGeeksforGeeks!5e0!3m2!1sen!2sin!4v1585040658255!5m2!1sen!2sin"
		width="300" height="350" frameborder="0" style="border: 0;"
		allowfullscreen="" aria-hidden="false" tabindex="0"> </iframe>



	<div id="cart" class="cart">


		<div id="total" class="total">


			<h2 align="center">Bill</h2>
			<table id="table" align="center">
				<thead>
					<tr>

						<td style="text-align: center">Product Name</td>
						<td>Price</td>
						<td>Quantity</td>



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



							<script>
					
					
					 tot+=${cart.quantity} * ${cart.price};
					var concatElement = document.getElementById("total");
					
				
					//alert(total);
					
					</script>








						</tr>

					</c:forEach>





				</tbody>
			</table>









			Total:
			<script>
			 concatElement.innerHTML += " " + tot;
			</script>


		</div>
		<br>
		<br>
		<form action="/user/pdfreport/${user.id }" method="GET">

	<button id="download-button2"  class="button-17">Download Bill </button>

</form>

	</div>
	
	


	<form action="/user/orderTracking/${user.id}" method="POST">
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<center>
			<input type="submit" name="Update" value="Order Received"
				class="button-17">
		</center>
	</form>
</body>
</html>