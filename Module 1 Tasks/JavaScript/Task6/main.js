let events=[

"Music Festival",
"Food Fair"

];

events.push("Workshop on Baking");

let musicEvents=
events.filter(event=>
event.includes("Music")
);

let display=
events.map(event=>

`<div class="card">

${event}

</div>`

);

document.getElementById("events")
.innerHTML=display.join("");