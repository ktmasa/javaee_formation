
function Produit(id, nom, prix, poids, stock) {
    this.id = id;
    this.nom = nom;
    this.prix = prix;
    this.poids = poids;
    this.stock = stock;

    this.genererLigne = function () {
        var tr = $("<tr></tr>");
        tr.append("<td>" + this.id + "</td>");
        tr.append("<td>" + this.nom + "</td>");
        tr.append("<td>" + this.prix + "</td>");
        tr.append("<td>" + this.poids + "</td>");
        tr.append("<td>" + this.stock + "</td>");
        var td = $("<td></td>");
        td.append(this.generateButton("btn-danger",
                "deleteproduit",
                "glyphicon glyphicon-trash",
                "l_"));

        td.append(this.generateButton("btn-primary",
                "editproduit",
                "glyphicon glyphicon-pencil",
                "e_"));
        tr.append(td);
        return tr;
    };
    this.generateButton = function (btnclassbt, btnclass, icon, prefix) {
        return $("<button class='btn " + btnclassbt + " " + btnclass
            + "' id='" + prefix + this.id + "'><span class='"
            + icon + "'> </span></button>");
    }

    // lire les champs et remplir l'objet
    this.fillFromForm = function (validate) {
        var valid = true;
        if (validate) {
            var c_prix = Number($("#prix").val());
            if (isNaN(c_prix) || c_prix < 0) {
                valid = false;
                $("#prix").addClass("champErreur");
            }
            else {
                this.prix = c_prix;
                $("#prix").removeClass("champErreur");
            }
            //------------------------------------------------
            var c_poids = Number($("#poids").val());
            if (isNaN(c_poids) || c_poids < 0) {
                valid = false;
                $("#poids").addClass("champErreur");
            }
            else {
                this.poids = c_poids;
                $("#poids").removeClass("champErreur");
            }
            //------------------------------------------------
            var c_stock = Number($("#stock").val());
            if (isNaN(c_stock) || c_stock < 0) {
                valid = false;
                $("#stock").addClass("champErreur");
            }
            else {
                this.stock = c_stock;
                $("#stock").removeClass("champErreur");
            }
        }
        else {
            this.prix = Number($("#prix").val());
            this.poids = Number($("#poids").val());
            this.stock = Number($("#stock").val());
        }
        this.nom = $("#nom").val();
        return valid;
    };


    this.toJson = function () {
        return {
            "nom": this.nom,
            "prix": this.prix,
            "poids": this.poids,
            "stock": this.stock
        };
    }
}