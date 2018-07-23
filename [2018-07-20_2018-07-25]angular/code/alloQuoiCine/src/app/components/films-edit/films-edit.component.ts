import { Component, OnInit } from '@angular/core';
import { Film } from '../../metier/film';
import { FilmRepositoryService } from '../../services/film-repository.service';

@Component({
  selector: 'app-films-edit',
  templateUrl: './films-edit.component.html',
  styleUrls: ['./films-edit.component.css']
})
export class FilmsEditComponent implements OnInit {

  // film en cours d'edition
  public currentFilm : Film;

  constructor(private filmRepository : FilmRepositoryService) { }

  ngOnInit() {
    // temporaire
    this.currentFilm = new Film(0, "inconnu", "inconnu", 2000);
  }

  public saveFilm() {
    // si id == 0, c'est un nouveau film
    if (this.currentFilm.id == 0){
      this.filmRepository.addFilm(this.currentFilm);
    }
    // remettre sur un nouveau film
    this.currentFilm = new Film(0, "inconnu", "inconnu", 2000);
  }

}
