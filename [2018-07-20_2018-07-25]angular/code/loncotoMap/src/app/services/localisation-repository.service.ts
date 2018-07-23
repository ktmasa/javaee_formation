import { Injectable } from '@angular/core';
import { Localisation } from '../metier/localisation';

@Injectable({
  providedIn: 'root'
})
export class LocalisationRepositoryService {
  private localisations : Array<Localisation>;

  public constructor() { 
    this.localisations = [
      new Localisation(1, "221 b baker street", "123456", "londre", "angleterre"),
      new Localisation(2, "2 rue de la paix", "75001", "paris", "france"),
      new Localisation(3, "3 rue du cassoulet", "31100", "toulouse", "france"),
      new Localisation(4, "25 rue du muscle", "45345", "hollywood", "etats-unis")
    ];
  }
  
// renvoie une copie du tableau des localisations
  public getLocalisations() : Array<Localisation> {
    return this.localisations.slice(0);
  }
}
