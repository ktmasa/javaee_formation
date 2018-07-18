$(document).ready(function() {
    compteur = 0;

    // appeler affiche compteur toutes les secondes
    window.setInterval(affiche_compteur, 1000);

    $("#popup").click(function() {
        alert('un popup!');
    });
});

function affiche_compteur() {
    compteur = compteur + 1;
    $("#texte").empty().append("compteur = " + compteur);
}