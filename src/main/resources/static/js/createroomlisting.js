var postBtn = document.getElementById("postButton");

 //elements for image upload
const input = document.getElementById("imageInput");
const avatar = document.getElementById("imageBox");

const convertBase64 = (file) => {
    return new Promise((resolve, reject) => {
        const fileReader = new FileReader();
        fileReader.readAsDataURL(file);

        fileReader.onload = () => {
            resolve(fileReader.result);
        };

        fileReader.onerror = (error) => {
            reject(error);
        };
    });
};
let base64 = ""
const uploadImage = async (event) => {
    const file = event.target.files[0];
    base64 = await convertBase64(file);
    avatar.src = base64;
};

input.addEventListener("change", (e) => {
    uploadImage(e);
});


const createRoomListing = async() => {
  let titleName = document.getElementById("titleInput").value;
  let desc = document.getElementById("descriptionInput").value;
  let priceMoney = document.getElementById("priceInput").value;
  let addr = document.getElementById("addressInput").value;
  
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
    address: addr,
    image:base64
    })
  });

  console.log(response);
  window.location.href = 'search';
}
postBtn.addEventListener('click', createRoomListing);