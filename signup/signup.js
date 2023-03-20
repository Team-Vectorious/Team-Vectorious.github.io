var submitBtn = document.getElementById("submitButton");

const createUser = async() => {
  let fName = document.getElementById("firstNameInput").value;
  let lName = document.getElementById("lastNameInput").value;
  let emailAdd = document.getElementById("emailInput").value;
  let phoneNum = document.getElementById("phoneNumberInput").value;
  let pword = document.getElementById("passwordInput").value;
  
  let response = await     fetch("http://localhost:8080/users/signup", {
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