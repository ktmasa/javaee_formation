
$(document).ready(function() {
    get_produits();
    $("#refresh").click(get_produits);
    $("#createproduit").click(save_produit);

    editMode = 0; // mode creation = 0, mode edition = 1
});

function deleteProduit() {
    var id = Number($(this).attr("dataid"));
    $.ajax({
        url: "http://localhost:3000/produits/" + id,
        type: "DELETE",
        success: function() {
            get_produits();
        }
    });
}

function createProduit() {
    var produit = new Produit(0);
    if (produit.fillFromForm()) {
        $.post("http://localhost:3000/produits", produit.toJson(), function() {
            get_produits();
        });
    }
    else {
        console.log("produit invalide");
    }
    return false;
}

function get_produits() {
    $.getJSON("http://localhost:3000/produits", refresh_liste);
}

function refresh_liste(data) {
    var tbody = $("#tableproduits tbody");
    tbody.empty();
    for (var i = 0; i < data.length; i++) {
        var p = data[i];
        var produit = new Produit(p.id, p.nom, p.prix, p.poids, p.stock);
        tbody.append(produit.genererLigne());
    }
    $(".deleteproduit").click(deleteProduit);
    $(".editproduit").click(edit_produit);
}

function edit_produit() {
    // recupere le bouton qui a déclencher le click
    // et dedans l'identifiant du produit stocké dans l'attribut dataid
    var id = $(this).attr("dataid");
    console.log("edit produit no " + id);
    // envoie de la requette vers l'api rest
    $.getJSON("http://localhost:3000/produits/" + id, remplir_formulaire);
}

function remplir_formulaire(data) {
    console.log(data);

    $("#id").val(data.id);
    $("#nom").val(data.nom);
    $("#prix").val(data.prix);
    $("#poids").val(data.poids);
    $("#stock").val(data.stock);
    // passage en mode edition
    editMode = 1;
}

function save_produit() {
    if (editMode == 0) {
        return createProduit();
    }
    else {
        return updateProduit();
    }
}

function updateProduit() {
    var produit = new Produit(0);
    if (produit.fillFromForm()) {
        // identifiant du produit
        var id = $("#id").val();
        $.ajax({
            url: "http://localhost:3000/produits/" + id,
            type: 'PUT',
            data: produit.toJson(),
            success : function() {
                editMode = 0; // on repasse en mode creation (edit fini)
                $("#id").val(0);
                $("#nom").val("");
                $("#prix").val(0);
                $("#poids").val(0);
                $("#stock").val(0);
                get_produits(); // rafraichir la liste
            }
        })
    }
    return false;
}