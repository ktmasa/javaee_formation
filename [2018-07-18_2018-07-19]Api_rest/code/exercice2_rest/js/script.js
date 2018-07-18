
$(document).ready(function() {
    get_produits();
    $("#refresh").click(get_produits);
    $("#createproduit").click(createProduit);
});

function deleteProduit() {
    var id = Number($(this).attr("id").substring(2));
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
    if (produit.fillFromForm(true)) {
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
}
