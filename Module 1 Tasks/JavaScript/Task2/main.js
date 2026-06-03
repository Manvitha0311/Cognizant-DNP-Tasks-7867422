const eventName="Music Festival";

const eventDate="15 June 2026";

let seats=50;

seats--;

let message=

`${eventName}
on ${eventDate}
| Seats Left : ${seats}`;

document.getElementById("info")
.innerHTML=message;