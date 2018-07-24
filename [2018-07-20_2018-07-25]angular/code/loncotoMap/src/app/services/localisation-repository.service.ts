import { Injectable } from '@angular/core';
import { Localisation, Localisation } from '../metier/localisation';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LocalisationRepositoryService {
  private localisations : Array<Localisation>;
  private localisationSubject : BehaviorSubject<Array<Localisation>>;
  private currentId : number;

  public constructor() { 
    this.localisations = [
      new Localisation(1, "221 b baker street", "123456", "londre", "angleterre"),
      new Localisation(2, "2 rue de la paix", "75001", "paris", "france"),
      new Localisation(3, "3 rue du cassoulet", "31100", "toulouse", "france"),
      new Localisation(4, "25 rue du muscle", "45345", "hollywood", "etats-unis")
    ];
    this.currentId = 5;
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
    localisation.id = this.currentId;
    this.currentId += 1;
    this.localisations.push(localisation);
    this.localisationSubject.next(this.localisations);
    console.log(this.localisations);
  }

  public updateLocalisation(localisation : Localisation) {
    // je retrouve la ligne/localisation a mettre a jour dans le tableau
    let index = this.localisations.findIndex(loc => loc.id == localisation.id);
    if (index >= 0) {
      this.localisations[index].copyFrom(localisation);
    }
  }

  public findById(id : number) : Localisation {
    let index = this.localisations.findIndex(loc => loc.id == id);
    if (index >= 0) {
      // retourner la localisation trouvée
      let loc : Localisation = new Localisation(0,"","","","");
      loc.copyFrom(this.localisations[index]);
      return loc;
    }
    else {
      return null;
    }
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
