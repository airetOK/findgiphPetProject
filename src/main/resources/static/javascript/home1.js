document.querySelector('#contactUs').addEventListener('mouseenter',enterContactUs);
document.querySelector('#contactUs').addEventListener('mouseleave',leaveContactUs);
document.querySelector('#back').addEventListener('mouseenter',enterBack);
document.querySelector('#back').addEventListener('mouseleave',leaveBack);
document.querySelector('#registration').addEventListener('mouseenter',enterRegistration);
document.querySelector('#registration').addEventListener('mouseleave',leaveRegistration);


	 function enterContactUs(){
		 	document.getElementById('contactUs').style.fontSize = '18px';
		 }
		 function leaveContactUs(){
			 document.getElementById('contactUs').style.fontSize = '16px';
		 }
		 function enterBack(){
			 	document.getElementById('back').style.fontSize = '18px';
			 }
			 function leaveBack(){
				 document.getElementById('back').style.fontSize = '16px';
			 }
	 function enterRegistration(){
		 	document.getElementById('registration').style.fontSize = '18px';
		 }
		 function leaveRegistration(){
			 document.getElementById('registration').style.fontSize = '16px';
		 }