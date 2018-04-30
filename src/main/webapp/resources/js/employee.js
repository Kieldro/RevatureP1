console.log("js running...")
//var x = document.cookie;
//document.getElementById("loggedInAs").innerHTML = x.substring(9);

//function updateReimbursement() {
//	var email = document.getElementById("loggedInAs").innerHTML;
//	var reason = document.getElementById("reason_input").value;
//	var amount = document.getElementById("amount_input").value;
//	var image = document.getElementById("image_input").value;
//	console.log(email + " succesfully did function  for amount " + amount)
//
//	var xhttp = new XMLHttpRequest();
//	xhttp.onreadystatechange = function() {
//		if (this.readyState == 4 && this.status == 200) {
//			console.log("sent the info")
//		}
//	};
//	xhttp.open("POST", "/reimbursement/createRequest.do");
//	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//	xhttp.send("email=" + email + "&reason=" + reason + "&amount=" + amount
//			+ "&image=" + image);
//
//}

function showMyReimbursements() {
	let email = "jane@gmail.com";
//	var email = document.getElementById("loggedInAs").innerHTML;
	console.log("showReimbursements()...")

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("this.readyState: " + this.readyState)
		if (this.readyState == 4 && this.status == 200) {
			var test = this.responseText;
			console.log("this.responseText" + test);
			document.getElementById("all_reimbursements").innerHTML = this.responseText;
			console.log("sucessfully finished showReimbursements().");
		}
	};
	xhr.open("POST", "/project1/listRequests.do");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send("email=" + email);
}

showMyReimbursements();