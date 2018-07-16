
// je declare "a la volée" une fonction rappelée par "ready"
$(document).ready(function() {

    $("#btAdd").click(addition);
    $("#btSub").click(soustraction);
    $("#btMul").click(multiplication);
    $("#btDiv").click(division);
});


function addition() {
    var op1 = $("#operande1").val();
    var op2 = $("#operande2").val();
    // conversion texte -> number
    var nb1 = Number(op1);
    var nb2 = Number(op2);
    // calcul du resultat
    var resultat = nb1 + nb2;
    $("#zonetexte").empty()
                   .append("<p> resultat addition: " + resultat + "</p>");
    return false;
}
function soustraction() {
    var op1 = $("#operande1").val();
    var op2 = $("#operande2").val();
    // conversion texte -> number
    var nb1 = Number(op1);
    var nb2 = Number(op2);
    // calcul du resultat
    var resultat = nb1 - nb2;
    $("#zonetexte").empty()
                   .append("<p> resultat soustraction: " + resultat + "</p>");
    return false;
}
function multiplication() {
    var op1 = $("#operande1").val();
    var op2 = $("#operande2").val();
    // conversion texte -> number
    var nb1 = Number(op1);
    var nb2 = Number(op2);
    // calcul du resultat
    var resultat = nb1 * nb2;
    $("#zonetexte").empty()
                   .append("<p> resultat multiplication: " + resultat + "</p>");
    return false;
}
function division() {
    var op1 = $("#operande1").val();
    var op2 = $("#operande2").val();
    // conversion texte -> number
    var nb1 = Number(op1);
    var nb2 = Number(op2);
    // calcul du resultat
    var resultat = nb1 / nb2;
    $("#zonetexte").empty()
                   .append("<p> resultat division: " + resultat + "</p>");
    return false;
}