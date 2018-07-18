/*
    fonctions utilitaires
*/

//  genere un bouton de type delete
function generateDeleteButton(btnclass, id) {
    return generateButton("btn-danger", btnclass, "glyphicon glyphicon-trash", id); 
}
// genere un bouton de type edit
function generateEditButton(btnclass, id) {
    return generateButton("btn-primary", btnclass, "glyphicon glyphicon-pencil", id); 
}


function generateButton(btnclassbt, btnclass, icon, id) {
    return $("<button class='btn " + btnclassbt + " " + btnclass
        + "' dataid='" + id + "'><span class='"
        + icon + "'> </span></button>");
}

// verifie si un champ comptient un nombre positif
function checkPositive(idChamp) {
    var value = readNumberField(idChamp);
    if (isNaN(value) || value < 0) {
        $("#" + idChamp).addClass("champErreur");
        return false;
    }
    else {
        $("#" + idChamp).removeClass("champErreur");
        return true;
    }
}

// lire un champ numerique (avec conversion)
function readNumberField(fieldId) {
    return  Number($("#" + fieldId).val());
}