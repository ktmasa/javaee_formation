function Auteur(id, nom){
    this.id = id;
    this.nom = nom;

    this.generateOption = function() {
        return $("<option>" + this.nom + "</option>");
    };
}