var submitBtn = document.getElementById("submitButton");

const loginUser = async() => {
  let emailAdd = document.getElementById("emailInput").value;
  let pword = document.getElementById("passwordInput").value;

  let response = await fetch("/login", {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-type': 'application/json'
    },
    body: JSON.stringify({
    email: emailAdd,
    password: pword
    })
  });
  
	if(response.status == 202) { //accepted
		 //onclick="window.location.href='search'"
		window.location.href = 'search';
	}else{ //rejected
		alert("Bad login");
	}
  
  	console.log(response);  
}
submitBtn.addEventListener('click', loginUser);