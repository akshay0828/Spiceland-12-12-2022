<! DOCTYPE html>  
<html lang="en" >  
<head>  
  <meta charset="UTF-8">  

    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title> Bootstrap 4 Login Form Example  
 </title>  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">  
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SpiceLand</title>
    <!-- StyleSheets -->
     <link rel="stylesheet" type="text/css" href="/css/loginStyle.css" /> 
</head>  


<body> 

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    
    <div style="font-size: 3.6rem;">SpiceLand</div>
        <a href="/index"><div style="color:black;  font-size: 3.6rem;">Home</div></a>
        
      </nav>
  

    <div class="loginbox">
        <img class="logo" src="https://cdn1.iconfinder.com/data/icons/large-glossy-icons/512/User_login.png">
        <h1>Sign In  </h1>
        <form th:action="@{/login}" method="post">
            <label>Username</label>
            <input type="text" placeholder="Enter Username"  id="username"  name="username"  required pattern="[A-Za-z]{3,10}"  title="User name must be between 3-10 characters!!" >
            <label>Password</label>
            <input type="password" placeholder="Enter Password"  id="exampleInputPassword1" name="pass" required pattern="[A-Za-z0-9#@$&]{3,10}" title="Password must be between 3-10 characters and type only valid characters!!">
          <center> ${error }</center>
            <input type="submit" value="Sign In">
           
           <center><a href="forgotpassword" id="a1">Forgot Password</a></center> 
         
               
            
       </form>
       <!--  <div class="sign-up">  
                    Don't have an account? <a href="register"> Create One </a>  
                </div> -->
        <center>Don't have an account?<a href="register">Create One </a></center>
    </div>

</body>  
</html>  

