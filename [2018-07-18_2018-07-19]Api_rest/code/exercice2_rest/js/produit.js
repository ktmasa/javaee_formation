
function Produit(id, nom, prix, poids, stock) {
    this.id = id;
    this.nom = nom;
    this.prix = prix;
    this.poids = poids;
    this.stock = stock;

    // generer une ligne du tableau
    this.genererLigne = function () {
        var tr = $("<tr></tr>");
        tr.append("<td>" + this.id + "</td>");
        tr.append("<td>" + this.nom + "</td>");
        tr.append("<td>" + this.prix + "</td>");
        tr.append("<td>" + this.poids + "</td>");
        tr.append("<td>" + this.stock + "</td>");
        // cellule du tableau contenant les boutons
        var td = $("<td></td>");
        td.append(generateButton("btn-danger",
            "deleteproduit",
            "glyphicon glyphicon-trash",
            "l_" + id));

        td.append(generateButton("btn-primary",
            "editproduit",
            "glyphicon glyphicon-pencil",
            "e_" + id));
        // ajout dans la ligne du tableau
        tr.append(td);
        return tr;
    };


    // lire les champs et remplir l'objet
    this.fillFromForm = function () {
        var valid = true;
        if (checkPositive("prix")) {
            this.prix = Number($("#prix").val());
        }
        else {
            valid = false;
        }
        //------------------------------------------------
        if (checkPositive("poids")) {
            this.poids = Number($("#poids").val());
        }
        else {
            valid = false;
        }
        //------------------------------------------------
        if (checkPositive("stock")) {
            this.stock = Number($("#stock").val());
        }
        else {
            valid = false;
        }
        this.nom = $("#nom").val();
        return valid;
    };

    // version json de l'objet
    this.toJson = function () {
        return {
            "nom": this.nom,
            "prix": this.prix,
            "poids": this.poids,
            "stock": this.stock
        };
    };
}