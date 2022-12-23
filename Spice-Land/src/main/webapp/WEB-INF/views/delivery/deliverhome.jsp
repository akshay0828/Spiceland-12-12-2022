<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="/css/diliveryhome.css" />
<title>Admin Dashboard</title>

</head>

<body class="body">
	<form action="/delivery/getOrders/${user.id }/" method="get">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"> <img
					src="../static/images/logo.png" width="auto" height="40"
					class="d-inline-block align-top" alt="" />
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
							href="/delivery/updateprofile/${user.id}">Update Profile</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="/logout">Logout</a></li>

					</ul>

				</div>
			</div>
		</nav>


		<div id="add" class="jumbotron text-center">

			<h1 class="display-4">Welcome Back,${user.name}</h1>
			<hr>
			<p></p>
		</div>
		</div>
		<br> <br> <br>

		<!-- <div class="border2"> </div> -->


		<div class="container-fluid">
			<div class="row justify-content-center">

				<div class="col-sm-3 pt-4">
					<div class="card border border-info"
						style="background-color: white;">
						<div class="card-body text-center">
							<h4 class="card-title">Order Details</h4>
							<img
								src="https://th.bing.com/th/id/R.0fef9a6d9d1fd5ec9535f0abbb74c3d2?rik=pmcVuEGM7%2fSa6w&riu=http%3a%2f%2fwww.gameusedandautographedcards.com%2fwp-content%2fuploads%2f2014%2f01%2fOrders.gif&ehk=XCw%2fQD7mXYGUACmF%2blMunhF0wPCw382kh5shWDo1xeo%3d&risl=&pid=ImgRaw&r=0"
								width="100" height="100">
							<h3>Choose which location you want to deliver</h3>

							<div class="dropdown-content">
								<select id="address" name="address"
									style="color: rgb(129, 8, 89); background-color: rgb(219, 233, 231); width: 105px; height: 30px; font-size: 20px;"
									required>

									<option value="" disabled selected>Select</option>
									<c:forEach var="v" items="${address}">
										<option id="aa" value="${v}">${v}</option>
									</c:forEach>
								</select>
							</div>
							<a href="/delivery/getOrders/${user.id }/"><button
									class="button-33" onclick="click()">get orders</button></a>


						</div>
					</div>
				</div>


				<script type="text/javascript">
					function click() {
						/* var loc=document.getElementById("address"); */

					}
				</script>





				<div class="Track">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Track
					Your Path</div>


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
	</form>
</body>
</html>