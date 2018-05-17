console.log("js running...")
let email = "jane@gmail.com";
let manager = false;
email = "keo@gmail.com";manager = true;
// var x = document.cookie;
 document.getElementById("username").innerHTML = email;

var managerForm = document.getElementById("managerForm");
var headline = document.getElementById("headline");
if (manager) {
	headline.innerHTML = "Request Management Form";
	managerForm.style.display = "block";
} else {
	// hide
	headline.innerHTML = "Employee Request Form";
	managerForm.style.display = "none";
}
function updateReimbursement() {
	// let email = document.getElementById("loggedInAs").innerHTML;
	let purpose = document.getElementById("purpose_input").value;
	let amount = document.getElementById("amount_input").value;

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(email + " successfully did function for amount: "
					+ amount)
			showMyReimbursements();
		}
	};
	xhttp.open("POST", "/project1/insertRequest.do");
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhttp.send("email=" + email + "&purpose=" + purpose + "&amount=" + amount);
}

function showMyReimbursements() {
	// var email = document.getElementById("loggedInAs").innerHTML;
	// console.log("showReimbursements()...")

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		// console.log("this.readyState: " + this.readyState)
		// console.log("this.status: " + this.status)
		if (this.readyState == 4 && this.status == 200) {
			console.log("this.responseText: " + this.responseText);
			let result = JSON.parse(this.responseText);
			var s = "";
			for ( var i in result) {
				s += JSON.stringify(result[i]) + '\n';
			}
			// console.log("obj: " + JSON.stringify(result[0]));

			document.getElementById("all_reimbursements").innerHTML = s;
		}
	};
	xhr.open("POST", "/project1/listRequests.do");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send("email=" + email);
}

function updateStatus() {
	let requestId = document.getElementById("requestId_input").value;
	let status = document.getElementById("status_input").value;

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// console.log(email + " successfully did function for amount: " +
			// amount)
			showMyReimbursements();
		}
	};
	xhttp.open("POST", "/project1/updateRequest.do");
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

	console.log(email + " updating: " + status + requestId);
	xhttp.send("email=" + email + "&status=" + status + "&requestId="
			+ requestId);
}

showMyReimbursements();