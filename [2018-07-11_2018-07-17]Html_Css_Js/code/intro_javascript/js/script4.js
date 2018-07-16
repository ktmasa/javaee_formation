
// je declare "a la volée" une fonction rappelée par "ready"
$(document).ready(function() {
    // executé quand la page est prete
    // recuperer le texte dans la balise d'identifiant "titre1"
    var texte = $("#titre1").text();
    console.log("texte = " + texte);
    $("#titre1").text("bonjour depuis jquery");

    //----------------------------------------
    /*var bt1 = $("button#bt1"); // récupération bouton id bt1
    // click (ajout de jquery) permet facilement d'ecouter un evenement html click
    bt1.click(function() {
        console.log("bouton 1 cliqué");
    });*/

    // appelé ajoutTexte quand bt1 est cliqué
    $("button#bt1").click(ajoutTexte);
    $("button#bt2").click(ajoutMessage);

});

function ajoutTexte() {
    var zonetexte = $('#zonetexte');
    zonetexte.append("<p>hello depuis ajoutexte</p>");

};
// ajoute le contenu du champ message dans la zonetexte de la page
function ajoutMessage() {
    var zonetexte = $('#zonetexte');
    // récuperer le contenu du champ de saisie message
    var message = $('input#message').val();
    zonetexte.append("<p> vous avez dit: " + message + "</p>");
    // ne pas soummetre le formulaire
    return false;
};