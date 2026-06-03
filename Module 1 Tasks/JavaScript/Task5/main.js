class Event{

constructor(name,seats){

this.name=name;
this.seats=seats;

}

}

Event.prototype.checkAvailability=
function(){

return this.seats>0
? "Available"
: "Full";

};

const event=
new Event(
"Music Festival",
25
);

let text="";

Object.entries(event)
.forEach(item=>{

text+=

`${item[0]} :
${item[1]}<br>`;

});

text+=
"<br>Status : "+
event.checkAvailability();

document.getElementById("output")
.innerHTML=text;