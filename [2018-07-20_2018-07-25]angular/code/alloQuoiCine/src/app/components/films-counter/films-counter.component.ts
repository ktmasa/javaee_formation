import { Component, OnInit, OnDestroy } from '@angular/core';
import { FilmRepositoryService } from '../../services/film-repository.service';
import { Observable, Subscription } from 'rxjs';
import { Film } from '../../metier/film';

@Component({
  selector: 'app-films-counter',
  templateUrl: './films-counter.component.html',
  styleUrls: ['./films-counter.component.css']
})
export class FilmsCounterComponent implements OnInit,OnDestroy {

  public compteur : number;
  // ce qu'on observe
  private filmsObservable : Observable<Array<Film>>;
  // notre "abonnement"
  private filmsSouscription : Subscription;

  constructor(private filmRepository : FilmRepositoryService) { }
  
  ngOnInit() {
    //this.compteur = this.filmRepository.getFilms().length;
    this.compteur = 0;
    // on récupere l'observable sur les films
    this.filmsObservable = this.filmRepository.getFilmsObservable();
    // on s'abonne a cet observable
    this.filmsSouscription = this.filmsObservable.subscribe(
      data => {
        // dans data, je recevrait mon nouveau tableau de films a chaque
        // mise a jour de celui-ci
        this.compteur = data.length;
    });
  }
  ngOnDestroy(): void {
    // quand le composant sera détruit
    // se desabonner "proprement" de l'observable sur la liste des films
    this.filmsSouscription.unsubscribe();
  }
}
