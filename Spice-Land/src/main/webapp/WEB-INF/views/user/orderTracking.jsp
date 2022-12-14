<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
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

    <link rel="stylesheet" type="text/css" href="./style.css" />
    <script type="module" src="./index.js"></script>
<style media="screen">
 body{
         background-image: url('https://img.freepik.com/free-photo/shopping-cart-black-background-with-copy-space_23-2148317906.jpg?w=1380&t=st=1669885183~exp=1669885783~hmac=b0e3baf5c59c492592e01c647b2037f01c692653a176f6a8ad408e6e366c3d91') ;
        
        
        background-attachment: fixed;
           background-position: center center; 
           background-size: cover;
      height: 100%;

  padding: 5px;
  width: 100%;
      } 
      
      .border{
      position: fixed;
       width:260px;
    height:330px;
    background:blue;
     left: 500px;
  bottom: 130px;
  margin-bottom: 20px;
  margin-top: 250px;
  margin-right: 200px;
  background-color: white;
      } 
      
         .glow-on-hover{
      position: fixed;
       width:560px;
    height:680px;
    /* background:blue; */
     left: 1400px;
  bottom: 180px;
  margin-bottom: 20px;
  margin-top: 250px;
  margin-right: 200px;
  /* background-color: white; */
      } 
 
      
        .map{
      
 position: fixed;
  left: 600px;
  bottom: 450px;
  margin-bottom: 50px;
  margin-top: 300px;
/*   margin-left: 400px;
 */  margin-right: 200px;
/*   background-color: lightblue; */
  
  }
  
  .Track{
  width:400px;
   position: fixed;
/*    border:80px;
 */  left: 49px;
  bottom: 13px;
  margin-bottom: 780px;
  margin-top: 100px;
/*   margin-left: 400px;
 */  margin-right: 100px;
  /* color: white; */
  background-color: grey;
  /* margin: 2px; */
  font-size: 25px;
  font-family: fantasy;
  }

      
      *{
  padding: 0;
  margin: 0;
  text-decoration: none;
  list-style: none;
  box-sizing: border-box;
}
body{
  font-family: montserrat;
}
/* nav{
  background: #E9DEDE;
  height: 80px;	Q
  width: 100%;
} */
/* label.logo{
  color: silver-grey;
  font-size: 35px;
  line-height: 80px;
  padding: 0 100px;
  font-weight: bold;
} */
/* nav ul{
  float: right;
  margin-right: 20px;
}
nav ul li{
  display: inline-block;
  line-height: 80px;
  margin: 0 5px;
}
nav ul li a{
  color: #fff;
  font-size: 17px;
  padding: 7px 13px;
  border-radius: 3px;
  text-transform: uppercase;
} */
a.active,a:hover{
  background: #fff;
  transition: .5s;
  color: #022f69;
}
.checkbtn{
  font-size: 30px;
  color: #fff;
  float: right;
  line-height: 80px;
  margin-right: 40px;
  cursor: pointer;
  display: none;
}
#check{
  display: none;
}
@media (max-width: 968px){
  label.logo{
    font-size: 30px;
    padding-left: 50px;
  }
  nav ul li a{
    font-size: 16px;
  }
}
@media (max-width: 875px){
  .checkbtn{
    display: block;
  }
 /*  nav ul{
    position: fixed;
    width: 100%;
    height: 100vh;
    background: #27282c;
    top: 80px;
    left: -100%;
    text-align: center;
    transition: all .5s;
  }
  nav ul li{
    display: block;
    margin: 50px 0;
    line-height: 30px;
  }
  nav ul li a{
    font-size: 20px;
  } */
  a:hover, a.active{
    background: none;
    color: #E9DEDE;
  }
  #check:checked ~ ul{
    left: 0;
  }

}


.glow-on-hover {
    width: 320px;
    height: 200px;
    border: none;
    outline: none;
    color: #fff;
    background: #111;
    cursor: pointer;
    position: relative;
    z-index: 0;
    border-radius: 30px;
    font-size: 55px;
}

.glow-on-hover:before {
    content: '';
    background: linear-gradient(45deg, #ff0000, #ff7300, #fffb00, #48ff00, #00ffd5, #002bff, #7a00ff, #ff00c8, #ff0000);
    position: absolute;
    top: -2px;
    left:-2px;
    background-size: 400%;
    z-index: -1;
    filter: blur(5px);
    width: calc(100% + 4px);
    height: calc(100% + 4px);
    animation: glowing 20s linear infinite;
    opacity: 0;
    transition: opacity .3s ease-in-out;
    border-radius: 10px;
}

.glow-on-hover:active {
    color: #000
}

.glow-on-hover:active:after {
    background: transparent;
}

.glow-on-hover:hover:before {
    opacity: 1;
}

.glow-on-hover:after {
    z-index: -1;
    content: '';
    position: absolute;
    width: 100%;
    height: 100%;
    background: #111;
    left: 0;
    top: 0;
    border-radius: 90px;
}

@keyframes glowing {
    0% { background-position: 0 0; }
    50% { background-position: 400% 0; }
    100% { background-position: 0 0; }
}
  table,
      table td {
       color: white;
        border: 3px solid #cccccc;
      }
      td {
        height: 80px;
        width: 160px;
        color: white;
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
		<style>
        .cart {
            width: 600px;
       
    box-shadow: 0 0 10px rgba(0, 0, 0, .3);
           
            background-size: cover;
            height: 500px;
            padding: 50px;
           
            
             /* width: 100px;  
height: 45%;  */
 position: fixed;
  left: 1200px;
  bottom: 200px;
  margin-bottom: 50px;
  margin-top: 300px;
  margin-right: 370px; 
        }     
      



 
      </style>
      
      
      <style>
        .cart {
            .cart {
            width: 1000px;
             color: #FF3838;
             
            font-size: 30px;
            height: 700px;
            padding: 50px;
            
            
             /* width: 100px;  
height: 45%;  */
 position: fixed;
  left: 1200px;
  bottom: 150px;
  margin-bottom: 50px;
  margin-top: 300px;
  margin-right: 370px; 
        }
        }
        
        

.total{
        color: red;
         font-size: 20px;
         
        }
    </style>
      
      
      
</head>
<body>


 

<!-- <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
      <i class="fas fa-bars"></i>
    </label>
    <label class="logo">Menu</label>
    <ul>
      <li><a class="active" href="#">Home</a></li>
      <li><a href="#">Profile</a></li>
      <li><a href="#">History</a></li>
      <li><a href="#">Contact</a></li>
      <li><a href="#">Log  Out</a></li>
    </ul>
  </nav> -->
  
  
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
  
  
 

         
           
            <iframe id="map" class="map" src=
"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3506.2233913121413!2d77.4051603706222!3d28.50292593193056!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x390ce626851f7009%3A0x621185133cfd1ad1!2sGeeksforGeeks!5e0!3m2!1sen!2sin!4v1585040658255!5m2!1sen!2sin"
                    
                  
  					width="300"
                    height="350"
                    frameborder="0"
                    style="border:0;"
                
                    allowfullscreen=""
                    aria-hidden="false"
                    tabindex="0">
            </iframe>
      
  
   
<div id="cart" class="cart">


<div id="total" class="total">


	<h2 align="center">Bill </h2>
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
<br><br>
<button id="download-button"  class="button-17">Download Bill</button>
</div>
<!-- To convert the bill of the order in csv from  -->
<script type="text/javascript">

	function downloadCSVFile(csv, filename) {
	    var csv_file, download_link;

	    csv_file = new Blob([csv], {type: "text/csv"});

	    download_link = document.createElement("a");

	    download_link.download = filename;

	    download_link.href = window.URL.createObjectURL(csv_file);

	    download_link.style.display = "none";

	    document.body.appendChild(download_link);

	    download_link.click();
	}

		document.getElementById("download-button").addEventListener("click", function () {
		    var html = document.querySelector("table").outerHTML;
			htmlToCSV(html, "SpiceLand_bill.csv");
		});


		function htmlToCSV(html, filename) {
			var data = [];
			var rows = document.querySelectorAll("table tr");
					
			for (var i = 0; i < rows.length; i++) {
				var row = [], cols = rows[i].querySelectorAll("td, th");
						
				 for (var j = 0; j < cols.length; j++) {
				        row.push(cols[j].innerText);
		                 }
				        
				data.push(row.join(","));		
			}

			//to remove table heading
			//data.shift()

			downloadCSVFile(data.join("\n"), filename);
		}

	</script>

<form action="/user/orderTracking/${user.id}" method="POST">
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<center><input type="submit"  name="Update" value="Order Received" class="button-17"></center>
</form>
</body>
</html>