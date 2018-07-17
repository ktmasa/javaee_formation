
$(document).ready(function() {
    
    // loncotoModule est un objet qui contiendra toute ma logique
    // les champs
    // autres...
    loncotoModule = {};
    loncotoModule.champPays = $("#pays");
    loncotoModule.champVille = $("#ville");
    loncotoModule.champCodePostal = $("#codePostal");
    loncotoModule.champRue = $("#rue");
    // la table
    loncotoModule.table = $("#localisations tbody");

    // mes donnees localisations, vide pour commencer
    loncotoModule.localisations = [];

    // fonction ajout localisation dans les donnees
    loncotoModule.ajouterLocalisation = function() {
        var pays = loncotoModule.champPays.val();
        var ville = loncotoModule.champVille.val();
        var cp = loncotoModule.champCodePostal.val();
        var rue = loncotoModule.champRue.val();

        var locOk = false;

        // 4-6 chiffres
        // regex: [0-9]{4,6}
        var motifcp = /^[0-9]{4,6}$/;
        if (motifcp.test(cp)) {
            locOk = true;
            loncotoModule.champCodePostal.removeClass("champErreur");
        }
        else {
            locOk = false;
            loncotoModule.champCodePostal.addClass("champErreur");
            return false;
        }

        // nouvelle localisation a partir de la siasie
        var loc = new Localisation(pays, ville, cp, rue);

        // ajout de la nouvelle localisation
        loncotoModule.localisations.push(loc);
        console.log(loncotoModule.localisations);
        // rafraichir affichage
        loncotoModule.refreshTable();
        return false;
    };

    // fonction refreshTable
    loncotoModule.refreshTable = function() {
        // on vide le tableau
        loncotoModule.table.empty();
        for(idx in loncotoModule.localisations) {
            var loc = loncotoModule.localisations[idx];
            loncotoModule.table.append(loc.genererLigne(idx));
        }
        // fonction de suppression d'une ligne
        $("button.removeloc").click(function() {
            // dans this -> le bouton declencheyr du click
            // recuperer l'identifiant du bouton
            var id = $(this).attr("id");
            console.log("id = " + id);
            var numeroligne = Number(id.substring(1));
            // retirer le "morceaux/slice" du tableau contenant la loc
            loncotoModule.localisations.splice(numeroligne, 1);
            // rafrachir affichage
            loncotoModule.refreshTable();
        });
    }
    // evenements
    $("#btAdd").click(loncotoModule.ajouterLocalisation);
    $("#btClear").click(function() {
        loncotoModule.localisations = [];
        loncotoModule.refreshTable();
    });
});


// "classe" des localisations
function Localisation(pays, ville, codePostal, rue) {
    this.pays = pays;
    this.ville = ville;
    this.codePostal = codePostal;
    this.rue = rue;

    this.genererLigne = function(numero) {
        var tr = $("<tr></tr>");
        tr.append("<td>" + this.pays + "</td>");
        tr.append("<td>" + this.ville + "</td>");
        tr.append("<td>" + this.codePostal + "</td>");
        tr.append("<td>" + this.rue + "</td>");
        tr.append("<td><button class='btn btn-danger removeloc' id='l"
                + numero + "'>remove</button></td>");
        return tr;
    }
}