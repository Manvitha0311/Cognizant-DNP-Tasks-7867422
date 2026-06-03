document
.getElementById("registerForm")
.addEventListener(

"submit",

function(event){

event.preventDefault();

let form=
event.target;

let name=
form.elements.username.value;

let email=
form.elements.email.value;

document
.getElementById("nameError")
.innerHTML="";

document
.getElementById("emailError")
.innerHTML="";

let valid=true;

if(name===""){

document
.getElementById("nameError")
.innerHTML="Name Required";

valid=false;

}

if(email===""){

document
.getElementById("emailError")
.innerHTML="Email Required";

valid=false;

}

if(valid){

alert("Registration Successful");

}

});