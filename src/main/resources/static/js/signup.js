var submitBtn = document.getElementById("submitButton");

const createUser = async() => {
  let fName = document.getElementById("firstNameInput").value;
  let lName = document.getElementById("lastNameInput").value;
  let emailAdd = document.getElementById("emailInput").value;
  let phoneNum = document.getElementById("phoneNumberInput").value;
  let pword = document.getElementById("passwordInput").value;

  //fetch("http://ec2-13-57-25-128.us-west-1.compute.amazonaws.com:8080/users/signup"
  let response = await     fetch("/signup", {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-type': 'application/json'
    },
    body: JSON.stringify({
    firstName: fName,
    lastName: lName,
    email: emailAdd,
    phoneNumber: phoneNum,
    password: pword
    })
  });
  
  console.log(response);
}
submitBtn.addEventListener('click', createUser);