function findLocation() {

    if(navigator.geolocation){

        navigator.geolocation.getCurrentPosition(

            showPosition,

            showError,

            {
                enableHighAccuracy:true,
                timeout:5000
            }

        );

    }
}

function showPosition(position){

    document.getElementById("location").innerHTML =

    "Latitude : " +
    position.coords.latitude +

    "<br>Longitude : " +
    position.coords.longitude;
}

function showError(error){

    switch(error.code){

        case error.PERMISSION_DENIED:
            alert("Location Permission Denied");
            break;

        case error.TIMEOUT:
            alert("Request Timed Out");
            break;

        default:
            alert("Error Getting Location");
    }
}