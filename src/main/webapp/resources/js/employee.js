console.log("js running...")
//var x = document.cookie;
//document.getElementById("loggedInAs").innerHTML = x.substring(9);

function updateReimbursement() {
	let email = "jane@gmail.com";
	// let email = document.getElementById("loggedInAs").innerHTML;
	let purpose = document.getElementById("purpose_input").value;
	let amount = document.getElementById("amount_input").value;

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(email + " successfully did function for amount: " + amount)
			showMyReimbursements();
		}
	};
	xhttp.open("POST", "/project1/insertRequest.do");
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhttp.send("email=" + email + "&purpose=" + purpose + "&amount=" + amount);

}

function showMyReimbursements() {
	let email = "jane@gmail.com";
//	var email = document.getElementById("loggedInAs").innerHTML;
//	console.log("showReimbursements()...")

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
//		console.log("this.readyState: " + this.readyState)
//		console.log("this.status: " + this.status)
		if (this.readyState == 4 && this.status == 200) {
			console.log("this.responseText: " + this.responseText);
			let result = JSON.parse(this.responseText);
			var s = "";
			for(var i in result){
				s += JSON.stringify(result[i]) + '\n';			
			}
//			console.log("obj: " + JSON.stringify(result[0]));
			
			document.getElementById("all_reimbursements").innerHTML = s;
		}
	};
	xhr.open("POST", "/project1/listRequests.do");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send("email="+email);
}

showMyReimbursements();