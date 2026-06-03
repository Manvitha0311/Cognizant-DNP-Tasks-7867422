fetch(
"https://jsonplaceholder.typicode.com/posts"
)

.then(response=>
response.json()
)

.then(data=>{

document
.getElementById("loading")
.style.display="none";

document
.getElementById("events")
.innerHTML=

data.slice(0,5)
.map(item=>

`<p>${item.title}</p>`

)

.join("");

})

.catch(error=>{

console.log(error);

});

async function loadEvents(){

try{

let response=
await fetch(
"https://jsonplaceholder.typicode.com/posts"
);

let data=
await response.json();

console.log(data);

}

catch(error){

console.log(error);

}

}

loadEvents();