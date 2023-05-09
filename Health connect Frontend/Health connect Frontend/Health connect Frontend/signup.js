

function senddts(){

    let pname=document.querySelector("#name").value;
    let pdob=document.querySelector("#dob").value;
    let pgender=document.querySelector("#gender").value;
    let password=document.querySelector("#password").value;
    let aadhar = document.querySelector("#aadhar").value;
    let pan=document.querySelector("#pan").value;
    let address=document.querySelector("#address").value;
    let pincode=document.querySelector("#pincode").value;
    let city = document.querySelector("#city").value;
    let state = document.querySelector("#state").value;
    let mobNo = document.querySelector("#mobNo").value;

    console.log(city);

let myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

let  raw = JSON.stringify({
  "user": {
    "name": pname,
    "dob": pdob,
    "gender": pgender,
    "address": address,
    "city": city,
    "password": password,
    "state": state,
    "pincode": pincode,
    "pancardNo": {
      "number": pan
    },
    "aadharCardNo": {
      "number": aadhar
    }
  },
  "registration": {
    "mobNo": mobNo
  }
});

let requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

console.log("done......",raw);

fetch("http://localhost:8080/app/user", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));

}

// send();

let submit = document.querySelector(".bttn");

submit.addEventListener("click", senddts);
