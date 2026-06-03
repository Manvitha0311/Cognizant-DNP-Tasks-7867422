function addEvent(name){

return `Added : ${name}`;

}

function registerUser(user){

return `${user} Registered`;

}

function filterEventsByCategory(
events,
callback
){

return events.filter(callback);

}

function registrationCounter(){

let count=0;

return function(){

count++;

return count;

}

}

const counter=
registrationCounter();

let events=[

{category:"Music"},

{category:"Sports"}

];

let result=
filterEventsByCategory(

events,

event=>event.category==="Music"

);

document.getElementById("result")
.innerHTML=

addEvent("Music Festival")

+"<br>"+

registerUser("Shruti")

+"<br>Total : "+

counter();