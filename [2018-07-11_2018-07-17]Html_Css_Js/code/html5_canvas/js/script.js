$(document).ready(function () {
    var dessin = document.getElementById("dessin");

    $("#dessin1").click(function () {
        // contexte permettant de "dessiner" dans le canvas
        var ctx = dessin.getContext("2d");
        ctx.fillStyle = 'red';
        // x,y, longueur, largeur
        ctx.fillRect(10, 10, 100, 60);
    });

    $("#clear").click(function () {
        var ctx = dessin.getContext("2d");
        ctx.clearRect(0, 0, 600, 400);
    });

    $("#lignes").click(function ( ) {
        var ctx = dessin.getContext("2d");
        ctx.strokeStyle = 'black';
        // bouger le curseur
        ctx.moveTo(200, 200);
        // faire une ligne du curseur a la position indiquer
        ctx.lineTo(300,200);
        ctx.lineTo(250,150);
        ctx.lineTo(200,200);
        // 'executer' le dessin dans le canvas
        ctx.stroke();
    });
});