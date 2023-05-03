var postBtn = document.getElementById("postButton");

const createRoomListing = async() => {
  let titleName = document.getElementById("titleInput").value;
  let desc = document.getElementById("descriptionInput").value;
  let priceMoney = document.getElementById("priceInput").value;
  let addr = document.getElementById("addressInput").value;

//fetch("http://ec2-13-57-25-128.us-west-1.compute.amazonaws.com:8080/users/signup"

  let response = await     fetch("/createroomlisting", {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-type': 'application/json'
    },
    body: JSON.stringify({
    title: titleName,
    description: desc,
    price: priceMoney,
    address: addr
    })
  });

  console.log(response);
}
postBtn.addEventListener('click', createRoomListing);