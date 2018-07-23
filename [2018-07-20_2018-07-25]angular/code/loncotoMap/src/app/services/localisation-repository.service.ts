import { Injectable } from '@angular/core';
import { Localisation } from '../metier/localisation';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LocalisationRepositoryService {
  private localisations : Array<Localisation>;
  private localisationSubject : BehaviorSubject<Array<Localisation>>;

  public constructor() { 
    this.localisations = [
      new Localisation(1, "221 b baker street", "123456", "londre", "angleterre"),
      new Localisation(2, "2 rue de la paix", "75001", "paris", "france"),
      new Localisation(3, "3 rue du cassoulet", "31100", "toulouse", "france"),
      new Localisation(4, "25 rue du muscle", "45345", "hollywood", "etats-unis")
    ];
    this.localisationSubject = new BehaviorSubject(this.localisations);
  }
  
// renvoie une copie du tableau des localisations
  public getLocalisations() : Array<Localisation> {
    return this.localisations.slice(0);
  }

  public getLocalisationsObservable() : Observable<Array<Localisation>> {
    return this.localisationSubject.asObservable();
  }

  public addLocalisation(localisation : Localisation) {
    localisation.id = this.localisations.length + 1;
    this.localisations.push(localisation);
    this.localisationSubject.next(this.localisations);
    console.log(this.localisations);
  }

  public removeLocalisation(id : number) {
    // rechercher l'index de la localisation avec le bon id
    let index = this.localisations.findIndex(loc => loc.id == id);
    if (index >= 0) {
      this.localisations.splice(index, 1);
      // je previens tous ceux qui ecoute le sujet
      this.localisationSubject.next(this.localisations);
    }

  }
}
