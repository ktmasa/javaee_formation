import { Component, OnInit } from '@angular/core';
import { Film } from '../../metier/film';
import { FilmRepositoryService } from '../../services/film-repository.service';

@Component({
  selector: 'app-films-display',
  templateUrl: './films-display.component.html',
  styleUrls: ['./films-display.component.css']
})
export class FilmsDisplayComponent implements OnInit {
  public films : Array<Film>;
  title = 'allo quoi cine';

  // angular va automatiquement m'injecter le service filmRepository
  constructor(private filmRepository : FilmRepositoryService) {
  }

  ngOnInit() {
    this.films = this.filmRepository.getFilms();
  }

}
