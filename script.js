// Get the modal
var modal = document.getElementById("loginModal");

var loginBtn = document.getElementById("loginButton");

const trialFunc = async() => {
  // let response = await fetch("http://localhost:8080/users");
  // console.log(response);
  console.log("Hello")
}
loginBtn.addEventListener('click', trialFunc);

// Get the button that opens the login modal
var loginModalButton = document.getElementById("loginModalButton");
// When the user clicks on the button, open the modal
loginModalButton.onclick = function() {
  modal.style.display = "block";
}

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}