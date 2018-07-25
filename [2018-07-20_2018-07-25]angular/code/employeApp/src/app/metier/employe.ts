export class Employe {
    public constructor(public id: number,
                        public nom: string,
                        public prenom: string,
                        public email: string,
                        public salaire: number) {}
    
    public copyFrom(source : Employe) {
        this.id = source.id;
        this.nom = source.nom;
        this.prenom = source.prenom;
        this.email = source.email;
        this.salaire = source.salaire;
    }

}
