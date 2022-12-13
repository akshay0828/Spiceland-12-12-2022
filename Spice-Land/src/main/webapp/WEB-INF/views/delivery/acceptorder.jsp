<!doctype html>
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
<title>Admin Dashboard</title>
<style >
body{
	 background-image: url('https://static.vecteezy.com/system/resources/previews/000/425/737/original/delivery-man-with-box-postman-design-isolated-on-white-background-courier-in-hat-and-uniform-with-package-vector.jpg');
         background-attachment: fixed;
        background-position: center;
          background-size: cover;
        background-repeat: no-repeat;
        }
      
      .product{
        background-image: url('https://cdn1.iconfinder.com/data/icons/business-related/64/19-512.png');
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: center;
          background-size: cover;
      }
      
     .button-33 {
  appearance: none;
  background-color: #FFFFFF;
  border-radius: 40em;
  border-style: none;
  box-shadow: #ADCFFF 0 -12px 6px inset;
  box-sizing: border-box;
  color: #000000;
  cursor: pointer;
  display: inline-block;
  font-family: -apple-system,sans-serif;
  font-size: 1.2rem;
  font-weight: 700;
  letter-spacing: -.24px;
  margin: 0;
  outline: none;
  padding: 1rem 1.3rem;
  quotes: auto;
  text-align: center;
  text-decoration: none;
  transition: all .15s;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

.button-33:hover {
  background-color: #FFC229;
  box-shadow: #FF6314 0 -6px 8px inset;
  transform: scale(1.125);
}

.button-33:active {
  transform: scale(1.025);
}

@media (min-width: 768px) {
  .button-33 {
    font-size: 1.5rem;
    padding: .75rem 2rem;
  }
}
      .clipkart{
        background-image: url('https://thumbs.dreamstime.com/b/street-vendor-sels-indian-colored-spices-cartoon-caricature-street-vendor-sels-indian-colored-spices-155544506.jpg');
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: center;
          background-size: cover;
      } 
        .map{
      
 position: fixed;
  left: -500px;
  bottom: 50px;
  margin-bottom: 50px;
  margin-top: 300px;
/*   margin-left: 400px;
 */  margin-right: 200px;
/*   background-color: lightblue; */
  
  }
       
</style>

</head>

<body class="bg-dark">

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
					<!--  <li class="nav-item active"><a class="nav-link" href="/adminhome">Home
							Page</a></li>-->
					<li class="nav-item active"><a class="nav-link" href="/delivery/deliverhome/${deliver.id}">Home Page</a></li>

				</ul>

			</div>
		</div>
	</nav>
	
	
	<br>
	<br>
	<br>
	
  <!-- <div class="border2"> </div> -->
  
  <center><h2 style="color: black">Deliver Order To this Address</h2></center>
  <br>
  <br>
  <div class="container-fluid" >
		<div class="row justify-content-center">
		
			<div class="col-sm-3 pt-4">
				<div class="card border border-info" style="background-color: white;">
					<div class="card-body text-center">
						<h4 class="card-title">Customer Details</h4>
						<div><label>Customer Name:</label>${user.name}
						</div>
						<div><label>Customer Contact:</label>${user.contact}
						</div>
						
						<div><label>Customer Adress:</label>${user.street} ${user.area} ${user.city} ${user.pincode}
						</div>
						<%-- <div><label>Customer Area:</label>${user.area}
						</div>
						<div><label>Customer City:</label>${user.city}
						</div>
						<div><label>Customer Pincode:</label>${user.pincode}
						</div> --%>
						
						
						<%-- <p class="card-text">${user.name}</p>  --%>
						

					</div>
				</div>
			</div>
			<br>
			<br>
         <div class="map" style="margin-left: 30%;%">
           
            <iframe src=
"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3506.2233913121413!2d77.4051603706222!3d28.50292593193056!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x390ce626851f7009%3A0x621185133cfd1ad1!2sGeeksforGeeks!5e0!3m2!1sen!2sin!4v1585040658255!5m2!1sen!2sin"
                    
                  
  					width="400"
                    height="600"
                    frameborder="0"
                    style="border:0;"
                    allowfullscreen=""
                    aria-hidden="false"
                    tabindex="0">
            </iframe>
        </div>
  

<br><br><br><br><br>
<a href="/delivery/deliverhome/${deliver.id }"><input type="submit"  class="button-33" value="Order Delivered" class="button-17"></a>
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