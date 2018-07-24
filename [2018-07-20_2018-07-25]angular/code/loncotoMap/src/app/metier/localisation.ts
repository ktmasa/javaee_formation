// objet metier représentant une localisation
export class Localisation {
    
    public constructor( public id : number,
                        public rue : string,
                        public codePostal : string,
                        public ville : string,
                        public pays: string) {}
    
    public copyFrom(other : Localisation ) {
        this.id = other.id;
        this.rue = other.rue;
        this.codePostal = other.codePostal;
        this.ville = other.ville;
        this.pays = other.pays;
    }
}