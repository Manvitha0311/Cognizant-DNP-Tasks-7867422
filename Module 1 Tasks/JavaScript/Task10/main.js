const events=[

{
name:"Music Festival",
date:"15 June 2026"
},

{
name:"Food Fair",
date:"20 June 2026"
}

];

// let keyword
let totalEvents=events.length;

// default parameter
function showEvent(
eventName="Community Event"
){
return eventName;
}

// destructuring
const {name,date}=events[0];

// spread operator
const copiedEvents=[...events];

document
.getElementById("output")
.innerHTML=

`
<h3>${showEvent()}</h3>

<p>
<b>Event Name:</b>
${name}
</p>

<p>
<b>Date:</b>
${date}
</p>

<p>
<b>Total Events:</b>
${totalEvents}
</p>

<p>
<b>Copied Events:</b>
${copiedEvents.length}
</p>
`;