const events=[

{name:"Music Festival",seats:20},

{name:"Food Fair",seats:0},

{name:"Sports Meet",seats:10}

];

events.forEach(event=>{

if(event.seats>0){

document.getElementById("events")
.innerHTML+=

`<div class="card">

<h3>${event.name}</h3>

<p>Seats : ${event.seats}</p>

</div>`;

}

});

function register(seats){

try{

if(seats<=0){

throw "No Seats Available";

}

console.log("Registered");

}

catch(error){

console.log(error);

}

}

register(0);