var x = document.cookie;
document.getElementById("loggedInAs").innerHTML = x.substring(9);
function updateReimbursement() {

	var email = document.getElementById("loggedInAs").innerHTML;
	var reason = document.getElementById("reason_input").value;
	var amount = document.getElementById("amount_input").value;
	var image = document.getElementById("image_input").value;
	console.log(email + "  succesfully did function  for amount " + amount)

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("sent the info")
		}
	};
	xhttp.open("POST", "/reimbursement/createRequest.do");
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhttp.send("email=" + email + "&reason=" + reason + "&amount=" + amount
			+ "&image=" + image);

}
function showMyReimbursements() {

	var email = document.getElementById("loggedInAs").innerHTML;
	console.log("  succesfully started showReimbursements ")

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			var test = this.responseText;
			console.log(test);
			document.getElementById("all_reimbursements").innerHTML = this.responseText;
			console.log("sucessucesffully finished showReimbursements");

		}
	};
	xhttp.open("POST", "/reimbursement/getAllMyReimbursements.do");
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhttp.send("email=" + email);

}