
$(document).ready(function() {
    get_posts();
    $("#refresh").click(get_posts);
    $("#createpost").click(save_post);


    editMode = 0; // mode creation = 0, mode edition = 1

    $.getJSON("http://localhost:3000/auteurs/", function(data){
        $("#auteurselect").append(generateSelect(data));
    });
});



function deletePost() {
    var id = Number($(this).attr("dataid"));
    $.ajax({
        url: "http://localhost:3000/posts/" + id,
        type: "DELETE",
        success: function() {
            get_posts();
        }
    });
}

function createPost() {
    var post = new Post(0);
    if (post.fillFromForm()) {
        $.post("http://localhost:3000/posts", post.toJson(), function() {
            get_posts();
        });
    }
    else {
        console.log("post invalide");
    }
    return false;
}

function get_posts() {
    $.getJSON("http://localhost:3000/posts", refresh_post);
}

function refresh_post(data) {
    var tbody = $("#tableposts tbody");
    tbody.empty();
    for (var i = 0; i < data.length; i++) {
        var p = data[i];
        var post = new Post(p.id, p.titre, p.corps, p.auteur);
        tbody.append(post.genererLigneTableau());
    }
    $(".deletepost").click(deletePost);
    $(".editpost").click(edit_post);
}

function edit_post() {
    // recupere le bouton qui a déclencher le click
    // et dedans l'identifiant du produit stocké dans l'attribut dataid
    var id = $(this).attr("dataid");
    console.log("edit post no " + id);
    // envoie de la requette vers l'api rest
    $.getJSON("http://localhost:3000/posts/" + id, remplir_formulaire);
}

function remplir_formulaire(data) {
    console.log(data);

    $("#id").val(data.id);
    $("#titre").val(data.titre);
    $("#corps").val(data.corps);
    $("#auteur").val(data.auteur);
    // passage en mode edition
    editMode = 1;
}

function save_post() {
    if (editMode == 0) {
        return createPost();
    }
    else {
        return updatePost();
    }
}

function updatePost() {
    var post = new Post(0);
    if (post.fillFromForm()) {
        // identifiant du produit
        var id = $("#id").val();
        $.ajax({
            url: "http://localhost:3000/posts/" + id,
            type: 'PUT',
            data: post.toJson(),
            success : function() {
                editMode = 0; // on repasse en mode creation (edit fini)
                $("#id").val(0);
                $("#titre").val("");
                $("#corps").val("");
                $("#auteur").val("");
                get_posts(); // rafraichir la liste
            }
        })
    }
    return false;
}

function generateSelect(auteurs) {
    var select = $("<select id='auteur' name='auteur'></select>");
    for (var i in auteurs) {
        var auteur = new Auteur(auteurs[i].id, auteurs[i].nom);
        select.append(auteur.generateOption());
    }
    return select;
}