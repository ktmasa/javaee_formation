function Post(id, titre,corps, auteur) {
    this.id = id;
    this.titre = titre;
    this.corps = corps;
    this.auteur = auteur;

     // generer une ligne du tableau
     this.genererLigneTableau = function () {
        var tr = $("<tr></tr>");
        tr.append("<td>" + this.id + "</td>");
        tr.append("<td>" + this.titre + "</td>");
        tr.append("<td>" + this.corps + "</td>");
        tr.append("<td>" + this.auteur + "</td>");
        // cellule du tableau contenant les boutons
        var td = $("<td></td>");
        td.append(generateDeleteButton("deletepost", id));
        td.append(generateEditButton("editpost", id));
        // ajout dans la ligne du tableau
        tr.append(td);
        return tr;
    };


    // lire les champs et remplir l'objet
    this.fillFromForm = function () {
        var valid = true;
        this.titre = $("#titre").val();
        this.corps = $("#corps").val();
        this.auteur = $("#auteur").val();
        return valid;
    };

    // version json de l'objet
    this.toJson = function () {
        return {
            "titre": this.titre,
            "corps": this.corps,
            "auteur": this.auteur
        };
    };

}