import { Injectable } from '@angular/core';
import { Film } from '../metier/film';

@Injectable({
  providedIn: 'root'
})
export class FilmRepositoryService {
  private films : Array<Film>;
  
  constructor() { 
    this.films = [
      new Film(1, "antman et la guepe", "steve", 2018),
      new Film(2, "antman et le scorpion", "dragos", 2015),
      new Film(3, "thor", "vincent", 2011)
    ];
  }

  public getFilms() : Array<Film> {
    // slice -> extrait morceau de tableau
    // slice(pos debut, longueur)
    // slice(0) -> copir complete du tableau
    return this.films.slice(0);
  }
}
