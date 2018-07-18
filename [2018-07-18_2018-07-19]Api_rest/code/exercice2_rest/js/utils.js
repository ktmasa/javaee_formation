/*
    fonctions utilitaires
*/

function generateButton(btnclassbt, btnclass, icon, id) {
    return $("<button class='btn " + btnclassbt + " " + btnclass
        + "' id='" + id + "'><span class='"
        + icon + "'> </span></button>");
}

function checkPositive(idChamp) {
    var value = Number($("#" + idChamp).val());
    if (isNaN(value) || value < 0) {
        $("#" + idChamp).addClass("champErreur");
        return false;
    }
    else {
        $("#" + idChamp).removeClass("champErreur");
        return true;
    }
}