$(document).ready(function () {
    var dessin = document.getElementById("dessin");

    //tableau vide initialement
    tableau = [];

    $("#ajouter").click(function() {
        tableau.push(Number($("#valeur").val()));
        console.log(tableau);
        graphe();
    });

    $("#clear").click(function () {
        var ctx = dessin.getContext("2d");
        ctx.clearRect(0, 0, 600, 400);
    });

    $("#graphe").click(graphe);
    

});

function graphe() {
    var ctx = dessin.getContext("2d");
    ctx.clearRect(0, 0, 600, 400);
    if (tableau.length <= 1) {
        return;
    }
    var min = 0;
    var max = 100;
    
    for (idx in tableau) {
        var v = tableau[idx];
        if (v > max)
            max = v;
        if (v < min)
            min = v;
    }
    var interval_y = max - min;
    var interval_x = 600 / tableau.length;
    ctx.beginPath();
    ctx.strokeStyle = 'black';
    var x = 0;
    for (idx in tableau) {
        var valeur = tableau[idx];
        if (idx == 0) {
            ctx.moveTo(x, 400 - (valeur / interval_y * 400));
        }
        else {
            ctx.lineTo(x, 400 - (valeur / interval_y * 400));
        }
        x = x + interval_x;
    } 
    ctx.stroke();
    ctx.closePath();
}