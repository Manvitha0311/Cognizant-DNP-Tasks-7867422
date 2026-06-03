const events=[

"Music Festival",
"Sports Meet",
"Food Fair"

];

const container=
document.querySelector("#events");

events.forEach(event=>{

let card=
document.createElement("div");

card.className="card";

card.innerHTML=

`<h3>${event}</h3>

<button onclick="register(this)">
Register
</button>`;

container.appendChild(card);

});

function register(btn){

btn.innerHTML="Registered";

btn.style.background="green";

}

function cancel(btn){

btn.innerHTML="Register";

btn.style.background="#0d6efd";

}