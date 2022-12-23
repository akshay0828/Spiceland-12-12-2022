<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/feedback.css" />
<title>List of Products</title>

</head>




<body>

	<div id="panel" class="panel-container">
		<strong>How satisfied are you with our Spice Land</strong>
		<div class="ratings-container">

			<div class="rating">
				<img
					src="https://whatemoji.org/wp-content/uploads/2020/07/Slightly-Frowning-Face-Emoji-1080x1080.png"
					width="100" height="100"> <small>Unhappy</small>
			</div>

			<div class="rating">
				<img
					src="https://lh5.googleusercontent.com/proxy/qcJlicPe_Cwn1zzK2kwGFP6MH5CP4Sqj6_8TGytNYsObME86mtFYqNZVshCkLlLyDsSIWLxSmCLvnW9PX7O45GO0-FdCX3sYuyiP8bn2WlMRJTVy4PNJmlJxXkm4ZGVC2pdHv-iLZaVAaGV6Fc4ALVIrwB-tdzbNmsOz=w1200-h630-p-k-no-nu"
					width="100" height="100"> <small>Neutral</small>
			</div>

			<div class="rating active">
				<img src="https://images.emojiterra.com/twitter/v11/512px/1f60c.png"
					width="100" height="100"> <small>Satisfied</small>
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