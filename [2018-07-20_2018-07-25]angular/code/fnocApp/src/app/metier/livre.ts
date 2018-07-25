export class Livre {
    public constructor(public id: number,
                        public titre: string,
                        public auteur: string,
                        public prix: number) {}

    public toJson() {
        return {
            titre: this.titre,
            auteur : this.auteur,
            prix: this.prix
        };
    }
}