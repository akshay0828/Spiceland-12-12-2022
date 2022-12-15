<! DOCTYPE html>  
<html lang="en" >  
<head>  
  <meta charset="UTF-8">  
  <title> Bootstrap 4 Login Form Example  
 </title>  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">  
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SpiceLand</title>
    <!-- StyleSheets -->
    <link rel="stylesheet" href="/css/styles.css" />
</head>  
<style>  

 body{
        background-image: url("https://i.pinimg.com/originals/b1/83/67/b18367603d1f83fc01c8b9128b4c1ba3.jpg") ;
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
#a1{
    text-decoration: none;
    color: white;
    margin-left: 5%;
    bottom: 200px;
}
input[type="submit"]:hover{
    background: green;
}

</style>  
<body> 

<header class="header">
    <div style="font-size: 3.6rem;">SpiceLand</div>
      <!-- <span class="yellow">roo</span> -->

      <nav class="navbar">
        <a href="/index"><div style="color:black;  font-size: 3.6rem;">Home</div></a>
        
      </nav>
    </header>

    <div class="loginbox">
        <img class="logo" src="https://cdn1.iconfinder.com/data/icons/large-glossy-icons/512/User_login.png">
        <h1>Sign In</h1>
        <form th:action="@{/login}" method="post">
            <label>Username</label>
            <input type="text" placeholder="Enter Username"  id="exampleInputEmail1"  name="username"  required pattern="[A-Za-z]{3,10}"  title="User name must be between 3-10 characters!!" >
            <label>Password</label>
            <input type="password" placeholder="Enter Password"  id="exampleInputPassword1" name="pass" required pattern="[A-Za-z0-9#@$&]{3,10}" title="Password must be between 3-10 characters and type only valid characters!!">
           <center> ${mess} </center>
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

