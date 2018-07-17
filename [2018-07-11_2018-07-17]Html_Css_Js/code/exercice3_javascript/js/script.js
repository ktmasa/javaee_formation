$(document).ready(function () {
    var dessin = document.getElementById("dessin");

    //tableau vide initialement
    tableau = [];

    $("#ajouter").click(function() {
        tableau.push(Number($("#valeur").val()));
        console.log(tableau);
    });

    $("#clear").click(function () {
        var ctx = dessin.getContext("2d");
        ctx.clearRect(0, 0, 600, 400);
    });

    $("#graphe").click(function() {
        var ctx = dessin.getContext("2d");
        ctx.clearRect(0, 0, 600, 400);
        ctx.strokeStyle = 'black';
        var x = 0;
        for (idx in tableau) {
            var valeur = tableau[idx];
            if (idx == 0) {
                ctx.moveTo(x, 400 - (valeur * 4));
            }
            else {
                ctx.lineTo(x, 400 - (valeur * 4));
            }
            x = x + 20;
        } 
        ctx.stroke();
    });
    

});