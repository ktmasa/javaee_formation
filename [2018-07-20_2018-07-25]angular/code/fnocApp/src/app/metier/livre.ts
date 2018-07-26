export class Livre {
    public constructor(public id: number,
                        public titre: string,
                        public auteur: string,
                        public prix: number) {}

    public copyFrom(source : Livre) {
        this.id = source.id;
        this.titre = source.titre;
        this.auteur = source.auteur;
        this.prix = source.prix;
    }

    public toJson() {
        return {
            titre: this.titre,
            auteur : this.auteur,
            prix: this.prix
        };
    }
}