
function click1() {
    console.log("appel de click1");
}
// les fonctions en javascript sont très laxiste
// on peut appelée celle-ci avec plus ou moins de
// parametres que défini
function click2(message) {
    if (typeof(message) == 'undefined') {
        console.log("pas de message");
    }
    else {
        console.log("message = " + message);
    }
}

function survol1() {
    console.log("survol le " + new Date());
}

function click3() {
    // je recupere depuis la page la balise
    // d'identifiant "reponse" s'il y en a une
    var div = document.getElementById("reponse");
    // changement du contenu de la balise
    div.textContent = "bonjour le " + new Date();
}

