// objet metier représentant une localisation
export class Localisation {
    
    public constructor( public id : number,
                        public rue : string,
                        public codePostal : string,
                        public ville : string,
                        public pays: string) {}
}