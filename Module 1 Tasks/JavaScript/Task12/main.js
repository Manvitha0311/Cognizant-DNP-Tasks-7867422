function registerUser(){

document
.getElementById("message")
.innerHTML="Sending...";

setTimeout(()=>{

fetch(
"https://jsonplaceholder.typicode.com/posts",
{
method:"POST",

body:JSON.stringify({

name:"Shruti",

event:"Music Festival"

}),

headers:{
"Content-type":
"application/json"
}
}
)

.then(response=>response.json())

.then(data=>{

document
.getElementById("message")
.innerHTML=

"✅ Registration Successful";

})

.catch(error=>{

document
.getElementById("message")
.innerHTML=

"❌ Registration Failed";

});

},2000);

}