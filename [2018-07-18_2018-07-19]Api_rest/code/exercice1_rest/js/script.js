
$(document).ready(function() {
    get_livres();
    $("#refresh").click(get_livres);
    $("#createlivre").click(createLivre);

});

function createLivre() {
    var titre = $("#titre").val();
    var auteur = $("#auteur").val();
    var prix = Number($("#prix").val());

    var newlivre = {
        "titre" : titre,
        "auteur" : auteur,
        "prix" : prix
    };
    $.post("http://localhost:3000/livres", newlivre, function() {
        get_livres();
    }); 
    return false;
}

// envoyer la requete au serveur
function get_livres() {
    $.getJSON("http://localhost:3000/livres/", reponse_livres);
}

// recuperations données en provenance du serveur
function reponse_livres(data) {
    //console.log(data);
    var tbody = $("#tablelivres tbody");
    tbody.empty();
    for (i in data) {
        var livre = data[i];
        var tr = $("<tr></tr>");
        tr.append("<td>" + livre.id + "</td>");
        tr.append("<td>" + livre.titre + "</td>");
        tr.append("<td>" + livre.auteur + "</td>");
        tr.append("<td>" + livre.prix + " €</td>");
        tr.append("<td><button id='l_"
                    + livre.id 
                    + "' class='btn btn-danger deletelivre'><span class='glyphicon glyphicon-trash'> </span></button></td>");
        tbody.append(tr);
    }
    $("button.deletelivre").click(deleteLivre);
}

function deleteLivre() {
    var id = Number($(this).attr("id").substring(2));
    
    $.ajax({
        url: "http://localhost:3000/livres/" + id,
        type: 'DELETE',
        success: function() {
            get_livres();
        }
    });
}