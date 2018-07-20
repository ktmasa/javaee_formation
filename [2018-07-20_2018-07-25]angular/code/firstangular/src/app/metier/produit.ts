
export class Produit {
    public constructor(public id: number,
                       public nom: string,
                       public prix: number) {}

    public afficher() : string {
        return "produit: " + this.nom + ", " + this.prix;
    }

    public description() : string {
        return `produit ${this.nom} de prix ${this.prix}`;
    }
}