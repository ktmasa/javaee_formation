
// je declare "a la volée" une fonction rappelée par "ready"
$(document).ready(function() {
    // executé quand la page est prete
    // recuperer le texte dans la balise d'identifiant "titre1"
    var texte = $("#titre1").text();
    console.log("texte = " + texte);
    $("#titre1").text("bonjour depuis jquery");
});