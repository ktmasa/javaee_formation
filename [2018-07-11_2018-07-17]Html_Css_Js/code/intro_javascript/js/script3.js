// appel uniquement quand la page est chargée
function initialisation() {
    var elem = document.getElementById("titre1");
    console.log(elem.textContent);
}

function compteur() {
    console.log("date " + new Date());
    // i est une variable locale, uniquement visible
    // depuis la fonction
    var i = 5;
}

function stopCompteur() {
    if (typeof(handle) != 'undefined') {
        window.clearInterval(handle);
        delete handle;
    }
    //console.log(i);
}


// rappeler compteur toutes les 4 secondes
var handle = window.setInterval(compteur, 4000);

//window.clearInterval(handle);

