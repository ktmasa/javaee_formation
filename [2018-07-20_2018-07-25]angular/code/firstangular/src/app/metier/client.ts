
class Client {
    private _id : number;
    private _nom : string;
    private _email : string;

    // syntaxe spécifique pour les getter sette
    // let a = client.id  -> il appel le getter
    public get id() : number {
        return this._id;
    }

    public get nom() : string {
        return this._nom;
    }
    // client.nom = "bob" --> nom("bob")
    public set nom(nomvalue: string)  {
        this._nom = nomvalue;
    }

    public constructor(id: number, nom:string, email:string) {
        this._id = id;
        this._nom = nom;
        this._email =email;
    }
}