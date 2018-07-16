
$(document).ready(function() {
    $("#btAdd").click(ajouterProduit);
});

function ajouterProduit() {
    var produit = creerProduit();
    if (produit != null) {
        console.log(produit);
        $("#tableproduits tbody").append(produit.genererLigne());    
    }
    else {
        console.log("produit invalide");
    }
    return false;
}

function creerProduit() {
    // recupere les champs
    var champNom = $("#nom");
    var champPrix = $("#prix");
    var champPoids = $("#poids");

    // on extrait/convertit les valeur de ceux-ci
    var nom = champNom.val();
    var prix = Number(champPrix.val());
    var poids = Number(champPoids.val());

    var produitBon = true;
    if (isNaN(prix) || prix < 0) {
        produitBon = false;
        // changer le style duc hamp pour indiquer l'erreur
        champPrix.addClass("champErreur");
    }
    else {
        champPrix.removeClass("champErreur");
    }

    if (isNaN(poids) || poids < 0) {
        produitBon = false;
        champPoids.addClass("champErreur");
    }
    else {
        champPoids.removeClass("champErreur");
    }

    // on instancie un objet Produit avec ces valeurs
    if (produitBon)
        return new Produit(nom, prix, poids);
    else
        return null;
}

// constructeur d'un objet produit (en javascript)
function Produit(nom, prix, poids) {
    this.nom = nom;
    this.prix = prix;
    this.poids = poids;

    // ajout d'une méthode
    this.genererLigne = function() {
        // nouvelle ligne
        var tr = $("<tr></tr>");
        tr.append("<td>" + this.nom + "</td>");
        tr.append("<td>" + this.prix + "</td>");
        tr.append("<td>" + this.poids + "</td>");
        // on retourne la ligne prete a être insérée
        return tr;
    };
}