function showFee() {

let fee =
document.getElementById("eventSelect").value;

document.getElementById("feeDisplay")
.innerHTML =
"Event Fee: ₹" + fee;

}

function registerUser() {

document.getElementById("result")
.innerHTML =
"Registration Successful!";

}

function validatePhone() {

let phone =
document.getElementById("phone").value;

if(phone.length != 10){

alert("Enter valid phone number");

}

}

function countChars() {

let text =
document.getElementById("feedbackText").value;

document.getElementById("charCount")
.innerHTML =
"Characters: " + text.length;

}

function videoReady() {

document.getElementById("videoMessage")
.innerHTML =
"Video Ready To Play";

}

function savePreference() {

let value =
document.getElementById("eventSelect").value;

localStorage.setItem(
"preferredEvent",
value
);

alert("Preference Saved");

}

window.onload = function() {

let saved =
localStorage.getItem(
"preferredEvent"
);

if(saved){

document.getElementById("eventSelect").value =
saved;

}

}

function clearPreferences() {

localStorage.clear();

sessionStorage.clear();

alert("Preferences Cleared");

}

function findLocation() {

if(navigator.geolocation){

navigator.geolocation.getCurrentPosition(

function(position){

document.getElementById("location")
.innerHTML =
"Latitude: "
+ position.coords.latitude
+
"<br>Longitude: "
+ position.coords.longitude;

},

function(error){

alert(
"Location Access Denied"
);

},

{
enableHighAccuracy:true,
timeout:5000
}

);

}

}

window.onbeforeunload = function() {

return "Are you sure you want to leave?";

}