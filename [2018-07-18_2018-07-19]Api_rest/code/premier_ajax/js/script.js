$(document).ready(function () {

    $("#listeContact").click(function () {

        // envoie d'une requette ajax au serveur pour recupérer du json
        $.getJSON("http://localhost:3000/contacts/", traiter_reponse);

        console.log("fin click");
    });
});

function traiter_reponse(data) {
    // on recoit dans cette fonction le json
    // dans "data"
    var pre = $("#reponse");
    pre.empty();
    console.log(data);
    for (idx in data) {
        var contact = data[idx];
        pre.append(contact.nom + ", " + contact.prenom + "\n");
    }
}