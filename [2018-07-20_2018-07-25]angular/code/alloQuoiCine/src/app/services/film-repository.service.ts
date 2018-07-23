import { Injectable } from '@angular/core';
import { Film } from '../metier/film';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmRepositoryService {
  private films : Array<Film>;
  // behaviorSubject
  // c'est notre sujet/topic dans lequel nous "publieront"
  // toute modification/nouvelle version du tableau des films
  private filmSubject : BehaviorSubject<Array<Film>>;

  constructor() { 
    this.films = [
      new Film(1, "antman et la guepe", "steve", 2018),
      new Film(2, "antman et le scorpion", "dragos", 2015),
      new Film(3, "thor", "vincent", 2011)
    ];
    this.filmSubject = new BehaviorSubject(this.films);
  }

  public getFilmsObservable() : Observable<Array<Film>> {
    // renvoyer un observable sur notre subjet "filmsSubject"
    return this.filmSubject.asObservable();
  }

  public getFilms() : Array<Film> {
    // slice -> extrait morceau de tableau
    // slice(pos debut, longueur)
    // slice(0) -> copir complete du tableau
    return this.films.slice(0);
  }

  public addFilm(film : Film) : void {
    film.id = this.films.length + 1;
    this.films.push(film);
    console.log(this.films);
    // je publie une nouvelle copie du tableau modifié
    this.filmSubject.next(this.films.slice(0));
  }


}
