<! DOCTYPE html>  
<html lang="en" >  
<head>  
  <meta charset="UTF-8">  
  <title> Bootstrap 4 Login Form Example  
 </title>  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">  
</head>  
<style>  
body{
    background: peru;
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;

}
 body{
        background-image: url("https://www.bollywoodschingford.com/wp-content/uploads/2016/12/Bollywoods-1.jpg") ;
        background-repeat: no-repeat;
        background-attachment: fixed;
           background-position: center center; 
           background-size: cover;
      height: 100%;

  padding: 5px;
  width: 100%;
      } 


.loginbox{
    width: 400px;
    height: 500px;
   background: rgba(0, 0, 0, 0.5);
    color: white;
    margin: 150px auto;
    border-radius: 10px;
    
}
.logo{

    width: 150px;
    height:150px;
    position: relative;
    top: -70px;
    left: calc(50% - 85px);

}
h1{
    text-align: center;
    margin-top: -60px;
}

label{

    font-size: 18px;
    display: block;
    margin-left: 20px;
}

input{

    width: 90%;
    margin: 0 0 20px 20px;
}

input[type="text"],input[type="password"]{
    border: none;
    background: transparent;
    border-bottom: 1px solid #fff;
    height: 40px;
    outline: none;
    color: white;
    font-size: 16px;
}

input[type="submit"]{
    border: none;
    outline: none;
    height: 40px;
    border-radius: 20px;
    background: #fb2525;
    color: white;
    font-size: 20px;
    cursor: pointer;
}

a{
    text-decoration: none;
    color: white;
    margin-left: 20%;
    bottom: 200px;
}

input[type="submit"]:hover{
    background: blueviolet;
}

</style>  
<body> 



    <div class="loginbox">
        <img class="logo" src="https://cdn1.iconfinder.com/data/icons/large-glossy-icons/512/User_login.png">
        <h1>Update Password</h1>
        <form action="/changepassword/${userna}" method="post">
            
            <label>Password</label>
            <input type="password" placeholder="Enter Password"  id="exampleInputPassword1" name="pass" required pattern="[A-Za-z0-9#@$&]{3,10}" title="Password must be between 3-10 characters and type only valid characters!!">
            <label>Confirm Password</label>
            <input type="password" placeholder="Enter Password"  id="exampleInputPassword1" name="cnfmpass" required pattern="[A-Za-z0-9#@$&]{3,10}" title="Password must be between 3-10 characters and type only valid characters!!">
            
            <input type="submit" value="submit">
          
               
            
       </form>
       <!--  <div class="sign-up">  
                    Don't have an account? <a href="register"> Create One </a>  
                </div> -->
         <center> ${me} </center>       
    <div class="form-submit-btn">
			<form action="/login" method="get">
				<input type="submit" value="Back">
			</form>
		</div>
    </div>

</body>  
</html>  

<!-- <div class="pt-5">  
  <div class="global-container">  
    <div class="card login-form">  
    <div class="card-body">  
        <h3 class="card-title text-center"> HomeMade Spices Login Form home</h3>  
        <div class="card-text">  
            <form>  
                <div class="form-group">  
                    <label for="exampleInputEmail1"> Enter Email address </label>  
                    <input type="text" class="form-control form-control-sm" id="exampleInputEmail1" aria-describedby="emailHelp" name="username" type="text"> 
                     
                </div>  
                <div class="form-group">  
                    <label for="exampleInputPassword1">Enter Password </label>  
                    <a href="#" style="float:right;font-size:12px;"> Forgot password? </a>  
                    <input type="password" class="form-control form-control-sm" id="exampleInputPassword1" name="password" type="text">  
                </div>  
                <button type="submit" class="btn btn-primary btn-block"> Sign in </button>  
                  
                <div class="sign-up">  
                    Don't have an account? <a href="register"> Create One </a>  
                </div>  
            </form>  
        </div>  
    </div>  
</div>  
</div> 
</form> --> 






<!-- <form action="/login" method="post">
	
			UserName<input name="username" type="text" /><br/>
			Password<input name="password" type="text" /><br/>
			
			<input name="submit" value="login" type="submit">
	</form> -->