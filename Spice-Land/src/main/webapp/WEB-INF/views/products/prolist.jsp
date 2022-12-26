<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/addProducts.css" />
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
<link rel="stylesheet" href="/css/prolist.css" />
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
					href="/admin/adminhome/${user.id}">Home Page</a></li>

			</ul>

		</div>
	</div>
	</nav>


	<h2 align="center">List of Products</h2>
	<table align="center">
		<thead>
			<tr>
				<td style="text-align: center">Product Name</td>
				<td>Price</td>
				<td>Weight</td>
				<td>productDescription</td>
				<td>Quantity</td>
				<td>Image</td>
				<td colspan="2">Actions</td>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Products}" var="product">
				<tr>
					<td>${product.productName}</td>
					<td>${product.price}</td>
					<td>${product.weight}</td>
					<td>${product.productDescription}</td>
					<td>${product.quantity}</td>
					<td><img width="200" height="150"
						src="data:image/jpeg;base64,${product.image}"></td>
					



					<td><a href="/products/updateproduct/${product.id}"><input
							type="submit" name="Update" value="Update" class="button-17"></a></td>

					
					<form method="post"  action="/products/prolist/${product.id}/${user.id}">
						<td><input type="submit" value="Delete" id="Delete"
							name="Delete" class="button-17"> <!-- <i class="fa fa-ban"></i> --></td>
					</form>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>
</html>