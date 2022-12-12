<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
    integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Products</title>

</head>

<style>
@import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');

* {
    box-sizing: border-box;
}

body {
      background-image: url('https://img.freepik.com/free-photo/shopping-cart-black-background-with-copy-space_23-2148317906.jpg?w=1380&t=st=1669885183~exp=1669885783~hmac=b0e3baf5c59c492592e01c647b2037f01c692653a176f6a8ad408e6e366c3d91') ;
   background-repeat: no-repeat;
   background-size: cover;
   background-attachment: fixed;
           background-position: center center; 
    font-family: 'Montserrat', sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    overflow: hidden;
    margin: 0;
}


.panel-container {
    background-color: rgb(249, 225, 225,0.3);
    box-shadow: 0 0 10px rgb(249, 225, 225,0.3);
    border-radius: 4px;
    font-color:#FFFFFF;
    font-size: 250%;
    display: flex;
    right:100px;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 30px;
    max-width: 900px;
   height: 600px;
}

.panel-container strong {
    line-height: 50px;
}

.ratings-container {
    display: flex;
    margin: 20px 0;
}

.rating {
    flex: 1;
    cursor: pointer;
    padding: 20px;
    margin: 10px 5px;
}

.rating:hover,
.rating.active {
    border-radius: 4px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.rating small {
    color: #DADADA;
    display: inline-block;
    margin: 10px 0 0;
}

.rating:hover small,
.rating:active small {
    color: #FFFFFF;
}

.btn {
    background-color: #302d2b;
    color: #fff;
    border: 0;
    border-radius: 4px;
    padding: 12px 30px;
    cursor: pointer;
}

.btn:focus {
    outline: none;
}

.btn:active {
    transform: scale(.98);
}

.fa-heart {
    color: red;
    font-size: 30px;
    margin-bottom: 10px;
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
</style>



<body>

  <div id="panel" class="panel-container">
    <strong>How satisfied are you with our 
     Spice Land</strong>
    <div class="ratings-container">

      <div class="rating">
        <img src="https://whatemoji.org/wp-content/uploads/2020/07/Slightly-Frowning-Face-Emoji-1080x1080.png" width="100" height="100">
        <small>Unhappy</small>
      </div>

      <div class="rating">
        <img src="https://lh5.googleusercontent.com/proxy/qcJlicPe_Cwn1zzK2kwGFP6MH5CP4Sqj6_8TGytNYsObME86mtFYqNZVshCkLlLyDsSIWLxSmCLvnW9PX7O45GO0-FdCX3sYuyiP8bn2WlMRJTVy4PNJmlJxXkm4ZGVC2pdHv-iLZaVAaGV6Fc4ALVIrwB-tdzbNmsOz=w1200-h630-p-k-no-nu" width="100" height="100">
        <small>Neutral</small>
      </div>

      <div class="rating active">
        <img src="https://images.emojiterra.com/twitter/v11/512px/1f60c.png"  width="100" height="100">
        <small>Satisfied</small>
      </div>

    </div>
    <button class="btn" id="send">Send Review</button>
    
  </div>
<script>
const ratings = document.querySelectorAll('.rating');
const rContainer = document.querySelector('.ratings-container');
const sendBtn = document.querySelector('#send');
const panel = document.querySelector('#panel');
let selectedRating = 'Satisfied';

rContainer.addEventListener('click', (e) => {
    if (e.target.parentNode.classList.contains('rating')) {
        removeActive();
        e.target.parentNode.classList.add('active');
        selectedRating = e.target.nextElementSibling.innerHTML;
    }
});

sendBtn.addEventListener('click', (e) => {
    panel.innerHTML = `
    <i class='fas fa-heart'></i>
    <strong>Thank You!</strong>
    <br>
    <strong>for shopping with us </strong>
 <center>   <p>We'll use your feedback to improve our service visit again for world class Spices and Snacks</p></center>
 <a href="/user/userhome/${user}"><input type="submit"  name="Update" value="Back to Home" class="button-17"></a>
    `;
});

function removeActive() {
    for (let i = 0; i < ratings.length; i++) {
        ratings[i].classList.remove('active');
    }
}


</script>
  <script src="app.js"></script>
</body>

</html>