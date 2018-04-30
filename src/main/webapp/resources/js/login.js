function login() {
	// let email = document.getElementById("loggedInAs").innerHTML;
	let email= document.getElementById("username").value;
	let password = document.getElementById("password").value;

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("login.onstate()");
		}
	};
	xhttp.open("POST", "/project1/login.do");
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhttp.send("email=" + email + "&password=" + password);	
}