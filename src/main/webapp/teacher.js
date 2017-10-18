/**
 * Teacher JavaScript File
 */


window.onload = function(){
	console.log('DOM READY');
	loadHome();
}


function loadHome(){
	
	console.log('Loading Home');
	
	//Use AJAX to grab the view html fragment
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			document.getElementById("view").innerHTML = xhr.responseText;
			getUserInfo();
			
		}
	}
	
	xhr.open("GET", "ajaxTeacherHome", true);
	xhr.send();
	
}



var user = null
function getUserInfo(){
	
	console.log('Loading user info');
	
	//Use AJAX to grab a JSON Object from server that holds UserTable data
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			user = JSON.parse(xhr.responseText);
			document.getElementById("firstName").innerHTML = user.firstName;
			document.getElementById("lastName").innerHTML = user.lastName;
			document.getElementById("username").innerHTML = user.username;
			document.getElementById("password").innerHTML = user.password;
			document.getElementById("email").innerHTML = user.email;
			
		}
	}
	
	xhr.open("GET", "ajaxUserInfo", true);
	xhr.send();
	
}