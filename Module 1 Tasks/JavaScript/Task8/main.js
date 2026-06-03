document
.getElementById("category")
.onchange=function(){

document
.getElementById("result")
.innerHTML=

"Selected : "+
this.value;

};

document
.getElementById("search")
.addEventListener(

"keydown",

function(){

console.log(
"Searching..."
);

}

);

function registerEvent(){

alert(
"Registration Successful"
);

}