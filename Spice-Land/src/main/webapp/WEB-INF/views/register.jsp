<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
</style>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	  <link rel="stylesheet" type="text/css" href="css/register.css" />
</head>

<body class="body">
	<center>
		<div class="container">
			<h1 class="form-title">Sign Up </h1>
			<form action="/register" method="post">

				<div class="main-user-info">

					<div class="user-input-box">
						<label for="fullName">Full Name</label> <input type="text"
							required id="fullName" name="name" placeholder="Enter Full Name" />
					</div>
					<div class="user-input-box">
						<label for="username">Username</label> <input type="text" required
							pattern="[A-Za-z]{3,10}"
							title="User name must be between 3-10 characters!!" id="username"
							name="username" placeholder="Enter Username" />
					</div>
					<div class="user-input-box">
						<label for="email">Email</label> <input type="email" id="email"
							required name="email" placeholder="Enter Email" />
					</div>
					<div class="user-input-box">
						<label for="phoneNumber">Phone Number</label> <input type="text"
							required id="phoneNumber" name="contact" pattern="^\d{10}$"
							title="Invalid Phone number!!" placeholder="Enter Phone Number" />
					</div>
					<div class="user-input-box">
						<label for="password">Password</label> <input type="password"
							required id="password" name="pass" placeholder="Enter Password"
							pattern="[A-Za-z0-9#@$&]{3,10}"
							title="Password must be between 3-10 characters and type only valid characters!!" />
					</div>
					<div class="user-input-box">
						<label for="confirmPassword">Confirm Password</label> <input
							type="password" id="confirmPassword" name="cnfmpass" required
							placeholder="Confirm Password" />
					</div>
					
					<!--  <h1 class="address">Address</h1>  -->
					 <br><br>
					<div class="user-input-box">
						<label for="confirmPassword">Street</label> <input type="text"
							id="address" name="street" required placeholder="Street" />
					</div>
					<div class="user-input-box">
						<label for="confirmPassword">Area</label> <input type="text"
							id="address" name="area" required placeholder="Area" />
					</div>
					<div class="user-input-box">
						<label for="confirmPassword">City</label> <input type="text"
							id="address" name="city" required placeholder="City" />
					</div>
					<div class="user-input-box">
						<label for="confirmPassword">Pincode</label> <input type="text"
							id="address" name="pincode"  pattern="^\d{6}$"  title="Invalid pincode enter 6 digit pincode!!" required placeholder="Pincode" />
					</div>
					
					
						<select id="vehicleList" name="role" required>
							
								<option value="" disabled selected>Select</option>
									<c:forEach var="v" items="${roleval}">
										<option id="aa" value="${v.name}">${v.name}</option>
									</c:forEach>
						</select>
						
						
						
						</div>

					<div class="form-submit-btn">
						<input type="submit" value="Submit and Back to Login">
					</div>
			</form>

						<div style="color: red;" align="center">
							<h3>${error}</h3>
						</div>
						
						<br />
					

			

			</form>
		</div>
	</center>
</body>
</html>



