import { Article } from "./article";

export class Famille {

    constructor(public id : number,
                public libelle: string,
                public articles? : Array<Article>){}

}