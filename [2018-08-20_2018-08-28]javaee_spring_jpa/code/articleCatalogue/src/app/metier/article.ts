import { Famille } from "./famille";

export class Article {
    constructor(public id: number,
                public dateCreation: string,
                public nom: string,
                public marque : string,
                public famille? : Famille) {}
}