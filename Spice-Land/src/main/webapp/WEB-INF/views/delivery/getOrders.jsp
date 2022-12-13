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
	<style>
	
	body{
	 background-image: url('https://static.vecteezy.com/system/resources/previews/000/425/737/original/delivery-man-with-box-postman-design-isolated-on-white-background-courier-in-hat-and-uniform-with-package-vector.jpg');
         background-attachment: fixed;
        background-position: center;
          background-size: cover;
        background-repeat: no-repeat;
        }
      table,
      table td {
    
        border: 3px solid #cccccc;
          background: rgba(0, 0, 0, 0.1);
      }
      td {
        height: 80px;
        width: 160px;
         font-size: 25px;
        font-weight: 500;
        text-align: center;
        vertical-align: middle;
      }
      
      .button-17 {
  align-items: center;
  appearance: none;
  background-color: #fff;
  border-radius: 24px;
  border-style: none;
  box-shadow: rgba(0, 0, 0, .2) 0 3px 5px -1px,rgba(0, 0, 0, .14) 0 6px 10px 0,rgba(0, 0, 0, .12) 0 1px 18px 0;
  box-sizing: border-box;
  color: #3c4043;
  cursor: pointer;
  display: inline-flex;
  fill: currentcolor;
  font-family: "Google Sans",Roboto,Arial,sans-serif;
  font-size: 14px;
  font-weight: 500;
  height: 48px;
  justify-content: center;
  letter-spacing: .25px;
  line-height: normal;
  max-width: 100%;
  overflow: visible;
  padding: 2px 24px;
  position: relative;
  text-align: center;
  text-transform: none;
  transition: box-shadow 280ms cubic-bezier(.4, 0, .2, 1),opacity 15ms linear 30ms,transform 270ms cubic-bezier(0, 0, .2, 1) 0ms;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  width: auto;
  will-change: transform,opacity;
  z-index: 0;
}

.button-17:hover {
  background: #F6F9FE;
  color: #174ea6;
}

.button-17:active {
  box-shadow: 0 4px 4px 0 rgb(60 64 67 / 30%), 0 8px 12px 6px rgb(60 64 67 / 15%);
  outline: none;
}

.button-17:focus {
  outline: none;
  border: 2px solid #4285f4;
}

.button-17:not(:disabled) {
  box-shadow: rgba(60, 64, 67, .3) 0 1px 3px 0, rgba(60, 64, 67, .15) 0 4px 8px 3px;
}

.button-17:not(:disabled):hover {
  box-shadow: rgba(60, 64, 67, .3) 0 2px 3px 0, rgba(60, 64, 67, .15) 0 6px 10px 4px;
}

.button-17:not(:disabled):focus {
  box-shadow: rgba(60, 64, 67, .3) 0 1px 3px 0, rgba(60, 64, 67, .15) 0 4px 8px 3px;
}

.button-17:not(:disabled):active {
  box-shadow: rgba(60, 64, 67, .3) 0 4px 4px 0, rgba(60, 64, 67, .15) 0 8px 12px 6px;
}

.button-17:disabled {
  box-shadow: rgba(60, 64, 67, .3) 0 1px 3px 0, rgba(60, 64, 67, .15) 0 4px 8px 3px;
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
						href="/delivery/deliverhome/${user.id}">Home Page</a></li>

				</ul>

			</div>
		</div>
	</nav>
	<br>
	
	<h2 align="center">List of Products</h2>
	<table align="center" >
		<thead>
			<tr>
								
				 <td>Items to deliver</td>
				<td>Customer</td>
				<td>address</td>
				<td>Seller</td>
				<td>Time</td> 
				<td > Actions </td>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Orders}" var="orders">
				<tr>
					
					
					 <td>${orders.cartIds}</td>
					 <td>${orders.user_id}</td>
					 <td>${orders.area}</td>
					  <td>${orders.adminIds}</td>
					<td>${orders.date}</td>
					
					 <form action="/delivery/getOrders/${user.id}/${orders.id}/${orders.user_id}" method="POST">
					 <td><input type="submit"  name="Accept" value="Accept" class="button-17"></a></td> 
					</form> 
				
					<%--  <td><a href="/delivery/acceptorder/${user.id }/${orders.user_id}"><input type="submit"  name="Accept" value="Accept" class="button-17"></a></td> 
					 --%>
					<%-- <form method="post"
                                action="/delivery/deliverhome/${user.id}/${orders.id}">
                                <td><input type="submit" value="Accept"
                                    id="Accept"
                                    name="Accept" class="button-17"> <!-- <i class="fa fa-ban"></i> --></td>
                            </form> --%>
					
					<!-- <td><a href="/products/prolist/${user.id}"><input type="submit"  name="Delete" value="Delete"></a></td> -->
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
</html>