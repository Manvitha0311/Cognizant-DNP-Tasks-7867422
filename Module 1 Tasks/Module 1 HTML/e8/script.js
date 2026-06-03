function savePreference() {

    let event =
    document.getElementById("eventType").value;

    localStorage.setItem(
        "preferredEvent",
        event
    );

    alert("Preference Saved");
}

window.onload = function() {

    let saved =
    localStorage.getItem("preferredEvent");

    if(saved){

        document.getElementById("eventType").value =
        saved;

    }
};

function clearPreference() {

    localStorage.clear();
    sessionStorage.clear();

    alert("Preferences Cleared");
}