<!doctype html>
<%@page import="java.sql.*"%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
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
<link rel="stylesheet" href="/css/profileupdate.css" />
<title>Add Products</title>


</head>
<body class="body1">
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

		<center>
			<div class="container">
				<h1 class="form-title" id="update">Update Profile</h1>
				<form action="/admin/updateProfile/${user.id}" method="post">

					<div class="main-user-info">

						<div class="user-input-box">
							<label for="fullName">Full Name</label> <input type="text"
								id="fullName" name="name" value="${user.name}" />
						</div>

						<div class="user-input-box">
							<label for="email">Email</label> <input type="email" id="email"
								name="email" value="${user.email}" />
						</div>
						<div class="user-input-box">
							<label for="phoneNumber">Phone Number</label> <input type="text"
								id="phoneNumber" name="contact" pattern="^\d{10}$"
								title="Invalid Phone number!!" value="${user.contact}" />
						</div>

						<br>
						<div class="user-input-box">
							<label for="confirmPassword">Street</label> <input type="text"
								id="address" name="street" required placeholder="Street"
								value="${user.street}" />
						</div>
						<div class="user-input-box">
							<label for="confirmPassword">Area</label> <input type="text"
								id="address" name="area" required placeholder="Area"
								value="${user.area}" />
						</div>
						<div class="user-input-box">
							<label for="confirmPassword">City</label> <input type="text"
								id="address" name="city" required placeholder="City"
								value="${user.city}" />
						</div>
						<div class="user-input-box">
							<label for="confirmPassword">Pincode</label> <input type="text"
								id="address" name="pincode" pattern="^\d{6}$"
								title="Invalid pincode enter 6 digit pincode!!" required
								placeholder="Pincode" value="${user.pincode}" />
						</div>
					</div>


					<input type="hidden" name="id" value="${user.id}" /> <input
						type="hidden" name="pass" value="${user.pass}" /> <input
						type="hidden" name="role" value="${user.role}" /> 
						 <input
						type="hidden" name="username" value="${user.username}" />


					<div class="form-submit-btn">
						<input type="submit" value="Submit">
					</div>
				</form>
				<br>


			</div>

			</form>
	</div>
	</center>


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
		var loadFile = function(event) {
			var image = document.getElementById('imgPreview');
			image.src = URL.createObjectURL(event.target.files[0]);
		};
	</script>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	</div>
</body>
</html>