document.querySelector('#mostpopular').addEventListener('mouseenter',enterMostPopular);
document.querySelector('#mostpopular').addEventListener('mouseleave',leaveMostPopular);
document.querySelector('#random').addEventListener('mouseenter',enterRandom);
document.querySelector('#random').addEventListener('mouseleave',leaveRandom);
document.querySelector('#submitgif').addEventListener('mouseenter',enterSubmitGif);
document.querySelector('#submitgif').addEventListener('mouseleave',leaveSubmitGif);
document.querySelector('#account').addEventListener('mouseenter',enterAccount);
document.querySelector('#account').addEventListener('mouseleave',leaveAccount);


 function enterMostPopular(){
 	document.getElementById('mostpopular').style.fontSize = '18px';
 }
 function leaveMostPopular(){
	 document.getElementById('mostpopular').style.fontSize = '16px';
 }
 function enterRandom(){
	 	document.getElementById('random').style.fontSize = '18px';
	 }
	 function leaveRandom(){
		 document.getElementById('random').style.fontSize = '16px';
	 }
	 function enterSubmitGif(){
		 	document.getElementById('submitgif').style.fontSize = '18px';
		 }
		 function leaveSubmitGif(){
			 document.getElementById('submitgif').style.fontSize = '16px';
		 }
		 function enterAccount(){
			 	document.getElementById('account').style.fontSize = '18px';
			 }
			 function leaveAccount(){
				 document.getElementById('account').style.fontSize = '16px';
			 }
				 
				